package com.example

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent

import scala.jdk.CollectionConverters._

class LambdaHandler extends RequestHandler[APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent] {
  override def handleRequest(input: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent = {
    val logger = context.getLogger
    logger.log("Received request: " + input.getBody)

    new APIGatewayProxyResponseEvent()
      .withStatusCode(200)
      .withBody("Hello from Scala Lambda!")
      .withIsBase64Encoded(false)
      .withHeaders(Map("Content-Type" -> "text/plain").asJava)
  }
}
