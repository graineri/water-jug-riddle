import scala.sys.process._

lazy val ScalaTestVersion = "3.0.5"
lazy val MockitoVersion = "2.23.4"

lazy val waterJugRiddle = (project in file("."))
  // Basic
  .settings(
  name := "water-jug-riddle",
  version := "1.0.0"
  )
  // Dependencies
  .settings(
    libraryDependencies ++= {
      Seq(
        // Test dependencies.
        "org.mockito"    % "mockito-core" % MockitoVersion   % Test,
        "org.scalatest" %% "scalatest"    % ScalaTestVersion % Test
      )
    }
  )
  // Testing
  .settings(
    parallelExecution in Test := true,
    // Write test output ASAP
    logBuffered in Test := false,
  )
  // Build
  .settings(
    scalaVersion := "2.12.8",
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
    ),
  )
