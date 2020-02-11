package com.code.boy.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReentrantLock;

public class Connector {

  private volatile JedisPool jedisPool;
  private final ReentrantLock initLock = new ReentrantLock();

  private JedisPoolConfig jedisPoolConfig() {
    JedisPoolConfig config = new JedisPoolConfig();
    config.setTestOnCreate(true);
    config.setTestOnBorrow(true);
    config.setTestWhileIdle(true);
    return config;
  }

  private JedisPool jedisPool() {
    if (jedisPool != null) {
      return this.jedisPool;
    }
    try {
      this.initLock.lock();
      if (this.jedisPool == null) {
        this.jedisPool = new JedisPool(jedisPoolConfig(), "47.94.219.170", 6379, 12000, "Wu20191008");
      }
      return this.jedisPool;
    } finally {
      this.initLock.unlock();
    }
  }

  public Jedis connection() {
    return this.jedisPool().getResource();
  }

  public static void main(String[] args) {
    Connector connector = new Connector();
    System.out.println(connector.connection().get("aaa"));
  }
}
