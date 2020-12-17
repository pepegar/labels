import Dependencies._

ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
  ThisBuild / organizationName := "example"

resolvers +=
  "JSBoss ThirdParty Releases" at "https://repository.jboss.org/nexus/content/repositories/thirdparty-releases"

lazy val root = (project in file("."))
  .settings(
    name := "labels",
    libraryDependencies ++= Seq(
      "org.apache.xmlgraphics" % "fop" % "2.5"
    )
  )
