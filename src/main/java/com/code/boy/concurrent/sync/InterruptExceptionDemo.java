package com.code.boy.concurrent.sync;

public class InterruptExceptionDemo {
  private final Object syncLock = new Object();

  /**
   * if thread is interrupted, an interrupted exception will be thrown upon invocation of wait() method.
   */
  private void interruptException() {
    Thread t = new Thread(new Runnable() {
      @SuppressWarnings("ResultOfMethodCallIgnored")
      public void run() {
        synchronized (syncLock) {
          try {
            syncLock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.interrupted();
          }
        }
      }
    });
    t.start();

    try {
      Thread.sleep(5000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    t.interrupt();
  }

  public static void main(String[] args) {
    InterruptExceptionDemo demo = new InterruptExceptionDemo();
    demo.interruptException();
  }
}
