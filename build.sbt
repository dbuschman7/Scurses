import sbt.Keys._
import sbt._

scalaVersion in ThisBuild := "2.12.6"

lazy val commonSettings: Seq[Setting[_]]  = Seq(
  name := "Scurses Project",
  version := "1.0",
  scalacOptions ++= Seq("-feature", "-unchecked")
)

lazy val scurses_root = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(scurses, onions)

lazy val scurses = (project in file("scurses"))
  .settings(commonSettings: _*)
  .settings(
    name := "Scurses",
    libraryDependencies += "com.lihaoyi" %% "fastparse" % "1.0.0",
    mainClass in (Compile, run) := Some("net.team2xh.scurses.examples.GameOfLife")
  )

lazy val onions = (project in file("onions"))
  .settings(commonSettings: _*)
  .dependsOn(scurses)
  .settings(
    name := "Onions",
    mainClass in (Compile, run) := Some("net.team2xh.onions.examples.ExampleUI")
  )
