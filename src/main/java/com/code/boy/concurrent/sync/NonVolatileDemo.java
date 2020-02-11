package com.code.boy.concurrent.sync;

public class NonVolatileDemo {
  private boolean flag = false;

  private Thread loop() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        while (!flag) {
          System.out.println("Running");
          try {
            Thread.sleep(1000L);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    t.start();
    return t;
  }

  public static void main(String[] args) {
    NonVolatileDemo demo = new NonVolatileDemo();
    Thread t = demo.loop();

    try {
      Thread.sleep(10000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    demo.flag = true;

    try {
      t.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
