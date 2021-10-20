
name := "sbt-scriptcc"

ThisBuild / version := "4.23"
ThisBuild / organization := "nl.uva.sne.cci"
ThisBuild / scalaVersion := "2.12.10"
licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0"))

githubTokenSource := TokenSource.GitConfig("github.token")
resolvers += Resolver.githubPackages("mostafamohajeri", "scriptcc-translator")
//ThisBuild / resolvers += Resolver.bintrayRepo("uva-cci","script-cc-grammars")
//ThisBuild / resolvers += Resolver.mavenLocal

ThisBuild / libraryDependencies += "nl.uva.sne.cci" % "parser" % "2.23"
ThisBuild / libraryDependencies += "nl.uva.sne.cci" % "scala-generator" % "2.23"

lazy val root = (project in file("."))
  .settings(
    sbtPlugin := true,
//    publishMavenStyle := true,
    name := "sbt-scriptcc",
    githubOwner := "mostafamohajeri",
    githubRepository := "sbt-scriptcc",
    githubTokenSource := TokenSource.GitConfig("github.token")
  )
