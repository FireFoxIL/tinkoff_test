ThisBuild / scalaVersion := "2.12.7"
ThisBuild / version := "0.1"
ThisBuild / organization := "ivan.lyagaev"
ThisBuild / name := "tinkoff_test"

lazy val root = (project in file("."))
  .settings {
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % Test
    )
  }
