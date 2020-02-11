package com.code.boy.concurrent.sync;

/**
 * Data race.
 * it should be noted that this code is improperly synchronized:
 * there is a write in one thread,
 * a read of the same variable by another thread,
 * and the write and read are not ordered by synchronization.
 */
public class DataRaceDemo {
  private int shareA;
  private int shareB;

  private void printLocalA() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        int localB = shareB;
        shareA = 1;
        System.out.println(localB);
      }
    });
    t.start();
  }

  private void printLocalB() {
    Thread t = new Thread(new Runnable() {
      public void run() {
        int localA = shareA;
        shareB = 2;
        System.out.println(localA);
      }
    });
    t.start();
  }

  public static void main(String[] args) {
    DataRaceDemo demo = new DataRaceDemo();
    demo.printLocalA();
    demo.printLocalB();
  }
}
