package com.yuvimasory.scallect

import com.google.caliper.Param

import com.google.common.collect.ImmutableList
import java.util.{ ArrayList, LinkedList }
import scala.collection.{ mutable => m }

class AppendBenchmark extends SimpleScalaBenchmark {
  
  @Param(Array("1000"))
  val length: Int = 0
  
  def timeAppendArrayListJava(reps: Int) = repeat(reps) {
    var iter = 0
    var col: ArrayList[String] = new ArrayList()
    while(iter < length) {
      col add iter.toString
      iter += 1
    }
    col
  }

  def timeAppendLinkedListJava(reps: Int) = repeat(reps) {
    var iter = 0
    var col: LinkedList[String] = new LinkedList()
    while(iter < length) {
      col add iter.toString
      iter += 1
    }
    col
  }

  def timeAppendArrayBufferScala(reps: Int) = repeat(reps) {
    var iter = 0
    var col: m.ArrayBuffer[String] = m.ArrayBuffer.empty
    while(iter < length) {
      col += iter.toString
      iter += 1
    }
    col
  }

  def timeAppendListBufferScala(reps: Int) = repeat(reps) {
    var iter = 0
    var col: m.ListBuffer[String] = m.ListBuffer.empty
    while(iter < length) {
      col += iter.toString
      iter += 1
    }
    col
  }

  def timeAppendVectorScala(reps: Int) = repeat(reps) {
    var iter = 0
    var col: Vector[String] = Vector.empty
    while(iter < length) {
      col :+ iter.toString
      iter += 1
    }
    col
  }

  def timeAppendImmutableListGuava(reps: Int) = repeat(reps) {
    var iter = 0
    var builder = new ImmutableList.Builder[String]()
    while(iter < length) {
      builder add iter.toString
      iter += 1
    }
    builder.build
  }
}

