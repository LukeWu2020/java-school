package com.code.boy.concurrent.thread;

public class SleepingInterruption {

  private volatile Boolean interruptedFlag = false;

  /**
   * Interrupt a thread that is sleeping.
   */
  private Thread interruptSleepingThread() {
    Thread runnableThread = new Thread(new Runnable() {
      public void run() {
        int num = 0;
        while (true) {
          try {
            Thread.sleep(1000);
            num++;
            System.out.println("I am alive! " + num);
            if (num == 5) {
              interruptedFlag = true;
            }
          } catch (InterruptedException e) {
            System.out.println("Interrupted");
            return;
          }
        }
      }
    });
    runnableThread.start();
    return runnableThread;
  }

  public static void main(String[] args) {
    SleepingInterruption interruption = new SleepingInterruption();
    Thread runningThread = interruption.interruptSleepingThread();
    while (true) {
      if (interruption.interruptedFlag) {
        runningThread.interrupt();
        break;
      }
    }
  }

}
