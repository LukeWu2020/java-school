package com.code.boy.concurrent.locks;

public class SyncDeadLock {
  private final Object lockerA = new Object();
  private final Object lockerB = new Object();

  private void acquisitionBA() {
    synchronized (lockerB) {
      System.out.println("Get access to B.");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.interrupted();
        e.printStackTrace();
      }
      synchronized (lockerA) {
        System.out.println("Get access to A");
      }
    }
  }

  private void acquisitionAB() {
    synchronized (lockerA) {
      System.out.println("Get access to A.");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.interrupted();
        e.printStackTrace();
      }
      synchronized (lockerB) {
        System.out.println("Get access to B");
      }
    }
  }

  public static void main(String[] args) {
    final SyncDeadLock syncDeadLock = new SyncDeadLock();
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        syncDeadLock.acquisitionAB();
      }
    });
    t1.start();

    Thread t2 = new Thread(new Runnable() {
      public void run() {
        syncDeadLock.acquisitionBA();
      }
    });
    t2.start();
  }
}
