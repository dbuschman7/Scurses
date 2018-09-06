import sbt.Keys._
import sbt._

version in ThisBuild := "1.0.0"
organization in ThisBuild := "io.timeli"
scalaVersion in ThisBuild := "2.12.6"
resolvers in ThisBuild += "Symphony Releases" at "https://symphonyai.jfrog.io/symphonyai/symphony-local/"
scalacOptions in ThisBuild ++= Seq("-feature", "-unchecked")

publishTo in ThisBuild  := Some("Artifactory Realm" at "https://symphonyai.jfrog.io/symphonyai/symphony-local")
//
pomExtra in ThisBuild  :=
  <url>http://www.symphonyindustrial.ai</url>
    <licenses>
      <license>
        <name>Symphony Industrial AI</name>
        <distribution>repo</distribution>
      </license>
    </licenses>


lazy val scurses_root = (project in file("."))
  .aggregate(scurses, onions)

lazy val scurses = (project in file("scurses"))
  .settings(
    name := "scurses",
    libraryDependencies += "com.lihaoyi" %% "fastparse" % "1.0.0",
    mainClass in(Compile, run) := Some("net.team2xh.scurses.examples.GameOfLife"),
  )

lazy val onions = (project in file("onions"))
  .dependsOn(scurses)
  .settings(
    name := "Onions",
    mainClass in(Compile, run) := Some("net.team2xh.onions.examples.ExampleUI"),
  )
