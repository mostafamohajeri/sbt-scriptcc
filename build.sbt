name := "sbt-scriptcc"

version := "0.4.1"
organization := "nl.uva.sne.cci"
scalaVersion := "2.12.10"

ThisBuild / resolvers += Resolver.bintrayRepo("uva-cci","script-cc-grammars")
ThisBuild / resolvers += Resolver.mavenLocal

ThisBuild / libraryDependencies += "nl.uva.sne.cci" % "parser" % "0.2.7.M2"
ThisBuild / libraryDependencies += "nl.uva.sne.cci" % "scala-generator" % "0.2.7.M2"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-scriptcc"
  )
