
ThisBuild / name := "sbt-scriptcc"

ThisBuild / version := "4.41"
ThisBuild / organization := "io.github.mostafamohajeri"
ThisBuild / organizationName := "CCI Group"
ThisBuild / scalaVersion := "2.12.10"
ThisBuild / organizationHomepage := Some(url("https://cci-research.nl/"))
licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/mostafamohajeri/sbt-scriptcc"),
    "scm:git@github.com:mostafamohajeri/sbt-scriptcc.git"
  )
)


ThisBuild / developers := List(
  Developer(
    id    = "mostafamohajeri",
    name  = "Mostafa",
    email = "m.mohajeriparizi@uva.nl",
    url   = url("https://github.com/mostafamohajeri/")
  )
)

ThisBuild / description := "sbt plugin for agentscript compiler"
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/mostafamohajeri/sbt-scriptcc"))




//resolvers += ("agent-script" at "http://145.100.135.102:8081/repository/agent-script/").withAllowInsecureProtocol(true)
//githubTokenSource := TokenSource.GitConfig("github.token")
//resolvers += Resolver.githubPackages("mostafamohajeri", "scriptcc-translator")
//ThisBuild / resolvers += Resolver.bintrayRepo("uva-cci","script-cc-grammars")
//ThisBuild / resolvers += Resolver.mavenLocal

ThisBuild / libraryDependencies += "io.github.mostafamohajeri" % "agentscript-parser" % "2.50"
ThisBuild / libraryDependencies += "io.github.mostafamohajeri" % "agentscript-scala-generator" % "2.50"

lazy val root = (project in file("."))
  .settings(
    sbtPlugin := true,
//    publishMavenStyle := true,
    name := "sbt-scriptcc",
////    githubOwner := "mostafamohajeri",
////    githubRepository := "sbt-scriptcc",
////    githubTokenSource := TokenSource.GitConfig("github.token")
//      credentials += Credentials(Path.userHome / ".sbt" / ".sonatype_credentials"),
//      publishTo := {
//          val nexus = "http://145.100.135.102:8081/repository/agent-script/"
//          if (isSnapshot.value)
//              Some(("snapshots" at nexus).withAllowInsecureProtocol(true))
//          else
//              Some(("releases"  at nexus).withAllowInsecureProtocol(true))
//      }
  )

ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
