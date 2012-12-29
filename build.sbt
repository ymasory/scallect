/* basic project info */
name := "scallect"

organization := "com.yuvimasory"

version := "0.1.0-SNAPSHOT"

description := "benchmarks of various Scala/Java collections libraries"

homepage := Some(url("https://github.com/ymasory/scallect"))

startYear := Some(2012)

licenses := Seq(
  ("GPLv3", url("http://www.gnu.org/licenses/gpl-3.0.txt"))
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/ymasory/scallect"),
    "scm:git:https://github.com/ymasory/scallect.git",
    Some("scm:git:git@github.com:ymasory/scallect.git")
  )
)

/* scala versions and options */
scalaVersion := "2.10.0"

// crossScalaVersions := Seq("2.9.1")

offline := false

scalacOptions ++= Seq(
  "-feature",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:experimental.macros",
  "-deprecation",
  "-unchecked"
)

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

// CONTINUATIONS
// autoCompilerPlugins := true
// addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.2")
// scalacOptions += "-P:continuations:enable"

/* dependencies */
libraryDependencies ++= Seq (
  //utilities
  "com.google.code.java-allocation-instrumenter" % "java-allocation-instrumenter" % "2.0",
  "com.google.code.gson" % "gson" % "1.7.1",
  "org.clapper" %% "classutil" % "1.0.0",
  //being tested
  // "org.scalaz" %% "scalaz-core" % "7.0.0-M4",
  // "org.scalaz" %% "scalaz-effect" % "7.0.0-M4",
  // "org.scalaj" %% "scalaj-collection" % "1.2",
  // "com.chuusai" %% "shapeless" % "1.2.2",
  "com.google.guava" % "guava" % "13.0.1"
)

libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-compiler" % _)

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

/* caliper necessities */
javaOptions in run <++= (fullClasspath in Runtime) map { cp =>
  Seq("-cp", sbt.Build.data(cp) mkString ":")
}

fork in run := true

