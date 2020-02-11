package com.code.boy.concurrent.sync;

/**
 * A thread is both notified and interrupted. it may either:
 * return normally from wait, while still having a pending interrupt (in other words, a call to Thread.interrupted would return true)
 * return from wait by throwing an InterruptedException.
 */
@SuppressWarnings("DuplicatedCode")
public class InterruptAndNotificationDemo {

  private final Object syncLocker = new Object();

  /**
   * A thread is added to wait set.
   *
   * @return
   */
  private Thread waiting() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        synchronized (syncLocker) {
          try {
            System.out.println("Waiting");
            syncLocker.wait();
            System.out.println("Notification");
          } catch (InterruptedException e) {
            System.out.println("Interruption");
          }
        }
      }
    });
    t.start();
    return t;
  }

  private void interrupt(Thread t) {
    t.interrupt();
  }

  private void notification() {
    synchronized (this.syncLocker) {
      this.syncLocker.notify();
    }
  }

  public static void main(String[] args) {
    InterruptAndNotificationDemo demo = new InterruptAndNotificationDemo();
    Thread t = demo.waiting();
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    demo.notification();
    demo.interrupt(t);
    try {
      t.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
