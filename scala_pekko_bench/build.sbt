name := "pekko-grpc-quickstart-scala"

version := "1.0"

scalaVersion := "2.13.16"

run / fork := true

val pekkoVersion = "1.1.3"
val pekkoHttpVersion = "1.1.0"

enablePlugins(PekkoGrpcPlugin)

// to get latest versions
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.5.16",
  "org.apache.pekko" %% "pekko-actor-typed" % pekkoVersion,
  "org.apache.pekko" %% "pekko-http" % pekkoHttpVersion,
  "org.apache.pekko" %% "pekko-http-core" % pekkoHttpVersion,
  "org.apache.pekko" %% "pekko-parsing" % pekkoHttpVersion,
  "org.apache.pekko" %% "pekko-stream" % pekkoVersion,
  "org.apache.pekko" %% "pekko-discovery" % pekkoVersion,
  "org.apache.pekko" %% "pekko-pki" % pekkoVersion,
  "org.apache.pekko" %% "pekko-slf4j" % pekkoVersion,
  "org.apache.pekko" %% "pekko-actor-testkit-typed" % pekkoVersion % Test,
  "org.apache.pekko" %% "pekko-stream-testkit" % pekkoVersion % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test
)

// pekko and Google provided proto files seem to differ a bit so we need to choose
// (doesn't seem to be important)
assembly / assemblyMergeStrategy := {
  case PathList(ps @ _*) if ps.last endsWith ".proto" => MergeStrategy.first
  case PathList("module-info.class") => MergeStrategy.last
  case path if path.endsWith("/module-info.class") => MergeStrategy.last
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}
