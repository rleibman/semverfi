lazy val root = project
	.in(file("."))
	.aggregate(semverfiJS, semverfiJVM)
	.settings( 
		scalaVersion := "2.12.2",
		publish := {},
		publishLocal := {}
	)

lazy val semverfi = crossProject
	.in(file("."))
	.settings(commonSettings)
	.settings(
		name := "semverfi",
		libraryDependencies ++= Seq(
			"org.scala-lang.modules" %%% "scala-parser-combinators" % "1.0.5",
			"org.specs2" %% "specs2-core" % "3.9.5" % "test"
		)).
		jvmSettings(
			// Add JVM-specific settings here
			name := "semverfi"
		).
		jsSettings(
			// Add JS-specific settings here
			name := "semverfi-js"
	)

lazy val semverfiJVM = semverfi.jvm
lazy val semverfiJS = semverfi.js

lazy val commonSettings = Seq(
	version := "0.2.0",
	scalaVersion := "2.12.2",
	crossScalaVersions := Seq("2.12.2"),
	moduleName         := "semverfi",
	organization       := "net.leibman",
	description := "Always Faithful, always loyal semantic versions",
	homepage := Some(url("https://github.com/rleibman/semverfi")),
	scalacOptions ++= Seq(
	  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
	  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
	  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
	  "-language:implicitConversions",     // Allow definition of implicit functions called views
	  "-language:postfixOps"
	),
	publishMavenStyle := true,
	publishTo := Some(
	  if (isSnapshot.value)
	    Opts.resolver.sonatypeSnapshots
	  else
	    Opts.resolver.sonatypeStaging
	),
	publishArtifact in Test := false,
	licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
	pomExtra := (
	  <scm>
	    <url>git@github.com:rleibman/semverfi.git</url>
	    <connection>scm:git:git@github.com:rleibman/semverfi.git</connection>
	  </scm>
	  <developers>
	    <developer>
	      <id>rleibman</id>
	      <name>Robero Leibman</name>
	      <url>https://github.com/rleibman</url>
	    </developer>
	  </developers>)
)
