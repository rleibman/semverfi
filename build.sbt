import java.lang.Boolean.{ parseBoolean => bool }

organization := "me.lessis"

version := "0.1.5"

name := "semverfi"

scalaVersion := "2.12.0"

description := "Always Faithful, always loyal semantic versions"

homepage := Some(url("https://github.com/softprops/semverfi"))

crossScalaVersions := Seq("2.11.8", "2.12.0")

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
	"org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6",
	"org.specs2" %% "specs2-core" % "3.8.6" % "test"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")

publishMavenStyle := true

publishTo := Some(Opts.resolver.sonatypeStaging)

publishArtifact in Test := false

licenses <<= version(v => Seq("MIT" -> url("https://github.com/softprops/semverfi/blob/%s/LICENSE" format v)))

pomExtra := (
  <scm>
    <url>git@github.com:softprops/semverfi.git</url>
    <connection>scm:git:git@github.com:softprops/semverfi.git</connection>
  </scm>
  <developers>
    <developer>
      <id>softprops</id>
      <name>Doug Tangren</name>
      <url>https://github.com/softprops</url>
    </developer>
  </developers>)

logLevel in Global := { if (bool(sys.env.getOrElse("TRAVIS", "false"))) Level.Warn else Level.Info }

logLevel in Compile := { if (bool(sys.env.getOrElse("TRAVIS", "false"))) Level.Warn else Level.Info }

logLevel in Test := { if (bool(sys.env.getOrElse("TRAVIS", "false"))) Level.Info else Level.Info }

seq(lsSettings:_*)

enablePlugins(ScalaJSPlugin)

LsKeys.tags in LsKeys.lsync := Seq("semver", "version")
