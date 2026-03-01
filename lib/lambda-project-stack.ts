import * as cdk from 'aws-cdk-lib';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import { Construct } from 'constructs';
import * as path from 'path';

export class LambdaProjectStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    // Scala Lambda function
    new lambda.Function(this, 'ScalaLambdaHandler', {
      runtime: lambda.Runtime.JAVA_21,
      code: lambda.Code.fromAsset(path.join(__dirname, '../target/scala-3.3.2/lambda-project-fat.jar')),
      handler: 'com.example.LambdaHandler',
      memorySize: 512,
      timeout: cdk.Duration.seconds(30),
      environment: {
        JAVA_TOOL_OPTIONS: '-XX:+TieredCompilation -XX:TieredStopAtLevel=1', // Optional: improves cold start
      },
    });
  }
}
