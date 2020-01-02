package com.code.boy.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    List<Future<Void>> futures = new LinkedList<Future<Void>>();
    for (int i = 0; i < 6; i++) {
      Callable<Void> callable = new Callable<Void>() {
        public Void call() throws Exception {
          Thread.sleep(1000);
          System.out.println("Hi");
          return null;
        }
      };
      futures.add(executorService.submit(callable));
    }
    for (Future<Void> future : futures) {
      try {
        future.get();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }
}
