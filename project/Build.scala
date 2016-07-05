import sbt._
import sbt.Keys._
import sbtassembly.AssemblyPlugin.autoImport._

object ApplicationBuild extends Build {

  lazy val appSettings = Seq(

    name := "jeetest",
    organization := "tomek",
    crossPaths := false,
    mainClass in Compile := Some("tomek.Main"),
    jarName in assembly := "tomek.jar",

    resolvers ++= Seq(
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
    ),

    libraryDependencies ++= Seq(
      "org.modelmapper" % "modelmapper" % "0.6.2"
    )
  )

  lazy val root = Project(
    id = "jeetest",
    base = file("."),
    settings =  appSettings
  )

}
