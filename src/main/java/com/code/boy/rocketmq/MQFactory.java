package com.code.boy.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MQPullConsumer;
import org.apache.rocketmq.client.consumer.MQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;

class MQFactory {
  private static final String DEFAULT_NAME_SERVER = "47.94.219.170:9876";
  private static final String DEFAULT_PRODUCER_GROUP = "my_producer";
  private static final String DEFAULT_CONSUMER_GROUP = "my_consumer";
  private static final String DEFAULT_TOPIC = "lovely_orange";
  private static final String DEFAULT_TAG = "my_tag";

  /**
   * Create an instance of {@link MQProducer}.
   *
   * @return
   */
  static MQProducer defaultMQProducer() {
    DefaultMQProducer producer = new DefaultMQProducer();
    producer.setNamesrvAddr(DEFAULT_NAME_SERVER);
    producer.setProducerGroup(DEFAULT_PRODUCER_GROUP);
    producer.setRetryTimesWhenSendFailed(0); // Do not retry sending message when using sync way.
    producer.setRetryTimesWhenSendAsyncFailed(0); // Don not retry sending message when using async way.
    producer.setVipChannelEnabled(false);
    return producer;
  }

  /**
   * Create an instance of {@link MQPushConsumer}.
   * This mq push consumer subscribes all message queues belong to default topic.
   *
   * @param listener
   * @return
   */
  static MQPushConsumer defaultMQPushConsumer(MessageListenerConcurrently listener) throws MQClientException {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
    consumer.setConsumerGroup(DEFAULT_CONSUMER_GROUP);
    consumer.setNamesrvAddr(DEFAULT_NAME_SERVER);
    consumer.subscribe(DEFAULT_TOPIC, DEFAULT_TAG);
    consumer.registerMessageListener(listener);
    consumer.setVipChannelEnabled(false);
    return consumer;
  }

  /**
   * Create an instance of {@link MQPullConsumer}.
   *
   * @return
   */
  static MQPullConsumer defaultMQPullConsumer() {
    DefaultMQPullConsumer consumer = new DefaultMQPullConsumer();
    consumer.setNamesrvAddr(DEFAULT_NAME_SERVER);
    consumer.setConsumerGroup(DEFAULT_CONSUMER_GROUP);
    return consumer;
  }

  /**
   * Create an instance of message.
   * This message will be sent to default topic.
   *
   * @param input
   * @return
   */
  static Message defaultMessage(String input) {
    Message message = new Message();
    message.setTopic(DEFAULT_TOPIC);
    message.setBody(input.getBytes());
    message.setTags(DEFAULT_TAG);
    return message;
  }
}
