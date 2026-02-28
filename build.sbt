name := "lambda-project"

version := "0.1.0"

scalaVersion := "3.3.2"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-core" % "1.2.3",
  "com.amazonaws" % "aws-lambda-java-events" % "3.11.0"
)

// Assembly settings
ThisBuild / fork := true
assembly / mainClass := Some("com.example.LambdaHandler") // replace with your Lambda handler full class name
assembly / assemblyJarName := "lambda-project-fat.jar"