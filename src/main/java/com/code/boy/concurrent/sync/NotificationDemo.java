package com.code.boy.concurrent.sync;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class NotificationDemo {
  private final Object syncLock = new Object();

  /**
   * A thread is added to wait set.
   */
  private Thread waiting() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        synchronized (syncLock) {
          try {
            System.out.println("Waiting");
            syncLock.wait();
            System.out.println("Over");
          } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
          }
        }
      }
    });
    t.start();
    return t;
  }

  /**
   * Remove a thread selected from wait set.
   * There is no guarantee about which thread in the wait set is selected.
   */
  private void notification() {
    synchronized (this.syncLock) {
      System.out.println("Notification");
      this.syncLock.notify();
    }
  }

  public static void main(String[] args) {
    NotificationDemo demo = new NotificationDemo();
    Thread t = demo.waiting();
    // enable
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    demo.notification();
    try {
      t.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
