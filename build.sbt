
name := "sbt-scriptcc"

ThisBuild / version := "0.4.17.SNAP1"
ThisBuild / organization := "nl.uva.sne.cci"
ThisBuild / scalaVersion := "2.12.10"
licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0"))


ThisBuild / resolvers += Resolver.bintrayRepo("uva-cci","script-cc-grammars")
//ThisBuild / resolvers += Resolver.mavenLocal

ThisBuild / libraryDependencies += "nl.uva.sne.cci" % "parser" % "0.2.17.SNAP1"
ThisBuild / libraryDependencies += "nl.uva.sne.cci" % "scala-generator" % "0.2.17.SNAP1"

lazy val root = (project in file("."))
  .settings(
    sbtPlugin := true,
    publishMavenStyle := true,
    bintrayOrganization := Some("uva-cci"),
    bintrayRepository := "script-cc-grammars",
    bintrayOmitLicense := true,
    name := "sbt-scriptcc"
  )
