package com.code.boy.redis;

import redis.clients.jedis.Jedis;

public class MemoryManagement {
  private Connector connector = new Connector();

  private void addData() {
    int i = 0;
    Jedis jedis = this.connector.connection();
    while (true) {
      i++;
      String kv = String.valueOf(i);
      try {
        String resp = jedis.set(kv, kv);
        System.out.println(resp + " - " + kv);
      } catch (Exception e) { // reach max memory.
        System.out.println("Reach maximum");
        break;
      }
    }
  }

  /**
   * Set a memory usage limit to the specified amount of bytes.
   * By default, memory management policy is no-eviction.
   */
  private void limitedMemoryWithoutEviction() {
    Jedis jedis = this.connector.connection();
    System.out.println("Collect: " + jedis.get("0")); // Redis still services read operations.
    System.out.println(jedis.set("0", "0")); // Write operations will be refused.
  }

  public static void main(String[] args) {
    MemoryManagement memoryManagement = new MemoryManagement();
    memoryManagement.addData();
    memoryManagement.limitedMemoryWithoutEviction();
  }
}
