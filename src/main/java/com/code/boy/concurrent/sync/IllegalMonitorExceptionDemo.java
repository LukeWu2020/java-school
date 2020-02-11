package com.code.boy.concurrent.sync;

public class IllegalMonitorExceptionDemo {
  private final Object sync = new Object();

  /**
   * if the number of lock actions on the monitor of sync instance is zero,
   * a {@link IllegalMonitorStateException} will be thrown upon invocation of wait() method.
   */
  private void illegalMonitorException() {
    try {
      sync.wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void sync() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        synchronized (sync) {
          try {
            sync.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    t.start();
  }

  public static void main(String[] args) {
    IllegalMonitorExceptionDemo demo = new IllegalMonitorExceptionDemo();
    demo.sync();
    try {
      Thread.sleep(3000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    demo.illegalMonitorException();
  }
}
