package com.code.boy.rocketmq;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.consumer.MQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class PullConsumer {

  private static final Logger logger = LoggerFactory.getLogger(PullConsumer.class);

  private void consume() {
    MQPullConsumer consumer = MQFactory.defaultMQPullConsumer();
    try {
      consumer.start();
    } catch (MQClientException e) {
      e.printStackTrace();
      return;
    }
    Set<MessageQueue> queues;
    try {
      queues = consumer.fetchSubscribeMessageQueues("broker-a");
    } catch (MQClientException e) {
      e.printStackTrace();
      return;
    }
    for (MessageQueue queue : queues) {
      PullResult pullResult = null;
      try {
        pullResult = consumer.pullBlockIfNotFound(queue, null, 0, 32);
      } catch (Exception e) {
        e.printStackTrace();
      }
      logger.info("Message: {}.", JSONObject.toJSONString(pullResult));
    }

  }

  public static void main(String[] args) {
    new PullConsumer().consume();
  }
}
