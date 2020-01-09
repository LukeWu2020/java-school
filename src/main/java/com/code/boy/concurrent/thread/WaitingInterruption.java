package com.code.boy.concurrent.thread;

public class WaitingInterruption {

  private final Object waitingLocker = new Object();

  /**
   * Interrupt a thread that is waiting.
   * @return
   */
  private Thread waitingInterruption() {
    Thread waitingThread = new Thread(new Runnable() {
      public void run() {
        System.out.println("Waiting");
        try {
          synchronized (waitingLocker) {
            waitingLocker.wait();
          }
        } catch (InterruptedException e) {
          System.out.println("Interrupted");
        }
      }
    });
    waitingThread.start();
    return waitingThread;
  }

  public static void main(String[] args) {
    WaitingInterruption interruption = new WaitingInterruption();
    Thread waitingThread = interruption.waitingInterruption();
    waitingThread.interrupt();
  }
}
