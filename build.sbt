name := """EventManagement"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.14"

libraryDependencies += guice
libraryDependencies += ws

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test

libraryDependencies ++= Seq(
  "org.playframework" %% "play-slick"            % "6.1.0",    // Enables to work with database
  "org.playframework" %% "play-slick-evolutions" % "6.1.0",    // Support for database migrations, similar to Flyway
  "mysql" % "mysql-connector-java" % "8.0.26",
  "org.slf4j" % "slf4j-api" % "1.7.30"
)

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.2"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "3.4.0" // Add the correct version of Kafka client


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
