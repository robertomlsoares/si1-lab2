name := """Gigs Radar"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  "org.apache.directory.api" % "api-all" % "1.0.0-M30",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.hibernate" % "hibernate-core" % "4.3.10.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.10.Final"
)
