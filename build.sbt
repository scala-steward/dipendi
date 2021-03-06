name := "dipendi"
organization := "com.protenus"

description := "Dipendi - Scala Dependency Injection Library"
homepage := Some(url("https://github.com/protenus/dipendi"))
licenses := Seq("Apache License, ASL Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

crossScalaVersions := Seq("2.11.12", "2.12.10", "2.13.1")
scalaVersion := "2.13.1"

mimaPreviousArtifacts := Set("0.6.0").map(organization.value %% name.value % _)

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.6",
  "com.typesafe" % "config" % "1.4.0" % Optional,
  "org.scalatest" %% "scalatest" % "3.1.1" % Test
)

fork := true
git.remoteRepo := "git@github.com:protenus/dipendi.git"

// Publishing

publishArtifact in Test := false
pomIncludeRepository := (_ => false)

// Site and docs

enablePlugins(SiteScaladocPlugin)
enablePlugins(GhpagesPlugin)

// nice *magenta* prompt!

shellPrompt in ThisBuild := { state =>
  scala.Console.MAGENTA + Project.extract(state).currentRef.project + "> " + scala.Console.RESET
}

// Additional meta-info

startYear := Some(2011)
organizationHomepage := Some(url("https://github.com/protenus"))
scmInfo := Some(ScmInfo(
  browseUrl = url("https://github.com/protenus/dipendi"),
  connection = "scm:git:git@github.com:protenus/dipendi.git"
))
developers := List(
  Developer("AprilAtProtenus", "April Hyacinth", "april@protenus.com", url("https://github.com/AprilAtProtenus"))
)
