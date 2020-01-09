package com.code.boy.concurrent.threadPool;

public class ThreadPoolCapacity {
  public static void main(String[] args) {
    int countBits = Integer.SIZE - 3;
    int capacity = (1 << countBits) - 1;
    System.out.println(Integer.toBinaryString(countBits));
    System.out.println(Integer.toBinaryString(1 << countBits));
    System.out.println(Integer.toBinaryString(capacity));
  }
}
