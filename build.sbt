name := "leetcode"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.6",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.9.6",
  "org.json4s" %% "json4s-native" % "3.6.1",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)
