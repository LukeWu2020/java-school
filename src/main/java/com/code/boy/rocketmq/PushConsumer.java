package com.code.boy.rocketmq;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.consumer.MQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class PushConsumer {

  private static final Logger logger = LoggerFactory.getLogger(PushConsumer.class);

  /**
   * Start consumer.
   */
  private void startConsumer() {
    MQPushConsumer consumer;
    try {
      consumer = MQFactory.defaultMQPushConsumer(new MessageListenerConcurrently() {
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messages, ConsumeConcurrentlyContext context) {
          for (MessageExt message : messages) {
            logger.info("Receive message: {}", JSONObject.toJSONString(message));
          }
          return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
      });
      consumer.start();
      logger.info("Consumer is running.");
    } catch (MQClientException e) {
      logger.error("Listening error!", e);
    }
  }

  public static void main(String[] args) {
    new PushConsumer().startConsumer();
  }
}
