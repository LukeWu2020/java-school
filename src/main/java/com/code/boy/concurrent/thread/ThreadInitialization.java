package com.code.boy.concurrent.thread;

public class ThreadInitialization {

  /**
   * A sub class extends Thread class.
   */
  private void initializeCustomThread() {
    Thread customThread = new Thread() {
      @Override
      public void run() {
        System.out.println("Custom Thread");
      }
    };
    customThread.start();
  }

  /**
   * A thread initialized with a runnable object.
   */
  private void initializeRunnableThread() {
    Thread runnableThread = new Thread(new Runnable() {
      public void run() {
        System.out.println("Runnable Thread");
      }
    });
    runnableThread.start();
  }

  public static void main(String[] args) {
    ThreadInitialization initialization = new ThreadInitialization();
    initialization.initializeCustomThread();
    initialization.initializeRunnableThread();
  }
}
