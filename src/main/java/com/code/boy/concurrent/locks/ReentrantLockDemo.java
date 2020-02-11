package com.code.boy.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("unused")
public class ReentrantLockDemo {

  /**
   * Get fair lock.
   */
  private void fairLockAndRelease() {
    final ReentrantLock fairLock = new ReentrantLock(true);

    Runnable task = new Runnable() {
      public void run() {
        fairLock.lock();
        fairLock.unlock();
      }
    };

    Thread t1 = new Thread(task);
    t1.start();
  }

  private void competitiveLock() {
    final ReentrantLock fairLock = new ReentrantLock(true);

    Runnable task = new Runnable() {
      public void run() {
        fairLock.lock();
      }
    };

    Thread t1 = new Thread(task);
    t1.start();

    try {
      Thread.sleep(5000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Thread t2 = new Thread(task);
    t2.start();
  }

  public static void main(String[] args) {
    ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
    reentrantLockDemo.competitiveLock();
  }

}
