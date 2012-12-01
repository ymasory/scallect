package com.yuvimasory.scallect

import com.google.caliper.Runner
import org.clapper.classutil.ClassFinder

object Main extends App {

  val classes = ClassFinder.concreteSubclasses(
    classOf[com.google.caliper.SimpleBenchmark].getName,
    ClassFinder() getClasses()
  )
  classes.foreach { info =>
    val name = info.name
    println("running " + name)
    trapExits {
      Runner main ((name :: args.toList): _*)
    }
  }

  def trapExits(thunk: => Unit): Unit = {
    val originalSecManager = System.getSecurityManager
    case class NoExitsException() extends SecurityException
    System setSecurityManager new SecurityManager() {
      import java.security.Permission
      override def checkPermission(perm: Permission) {
        if (perm.getName startsWith "exitVM") throw NoExitsException()
      }
    }
    try {
      thunk
    } catch {
      case _: NoExitsException =>
    } finally {
      System setSecurityManager originalSecManager
    }
  }
}
