lazy val root = project.in(file(".")).
	aggregate(semverfiJS, semverfiJVM)
	.settings(
		publish := {},
		publishLocal := {}
	)

lazy val semverfi = crossProject.in(file(".")).
  settings(commonSettings).
  settings(name := "semverfi",
	libraryDependencies ++= Seq(
		"org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.5",
		"org.specs2" %% "specs2-core" % "3.8.9" % "test"
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
	version := "0.1.9",
	scalaVersion := "2.12.2",
	crossScalaVersions := Seq("2.11.11", "2.12.2"),
	moduleName         := "semverfi",
	description := "Always Faithful, always loyal semantic versions",
	homepage := Some(url("https://github.com/softprops/semverfi")),
	scalacOptions ++= Seq(
	  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
	  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
	  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
	  "-language:implicitConversions",     // Allow definition of implicit functions called views
	  "-language:postfixOps"
	),
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
)
