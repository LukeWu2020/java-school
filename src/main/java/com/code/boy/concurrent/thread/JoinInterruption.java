package com.code.boy.concurrent.thread;

public class JoinInterruption {
  private Thread joinThread() {
    Thread joinThread = new Thread(new Runnable() {
      public void run() {
        int num = 10;
        while (num-- > 0) {
          System.out.println("Dancing " + num);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    joinThread.start();
    return joinThread;
  }

  public static void main(String[] args) {
    JoinInterruption interruption = new JoinInterruption();
    Thread joinThread = interruption.joinThread();
    try {
      joinThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Dancer rest");
  }
}
