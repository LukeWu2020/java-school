package com.code.boy.rocketmq;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * A example about how to send message to topic.
 */
class AsyncProducer {

  private static final Logger logger = LoggerFactory.getLogger(AsyncProducer.class);

  /**
   * Start producer.
   */
  private void startProducer() {
    MQProducer producer = MQFactory.defaultMQProducer();
    try {
      producer.start();
      logger.info("Producer is running.");
    } catch (MQClientException e) {
      logger.error("Failed to start producer.", e);
      return;
    }

    Scanner scanner = new Scanner(System.in);
    logger.info("Enter message:");
    String input;
    while (!"exit".equalsIgnoreCase((input = scanner.nextLine()))) {
      try {
        producer.send(MQFactory.defaultMessage(input), new SendCallback() {
          public void onSuccess(SendResult sendResult) {
            logger.info("Sending result: {}", JSONObject.toJSONString(sendResult));
          }

          public void onException(Throwable e) {
            logger.error("Sending error!", e);
          }
        });
      } catch (Exception e) {
        logger.error("Failed to send message to topic.", e);
        break;
      }
    }
    producer.shutdown();
    logger.info("Producer complete.");
  }


  public static void main(String[] args) {
    final AsyncProducer asyncProducer = new AsyncProducer();
    asyncProducer.startProducer();
  }
}
