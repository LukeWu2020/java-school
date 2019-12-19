package com.code.boy.jvm;


import java.util.Scanner;

public class EchoGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Game Start!");
    System.out.println("<<< ");
    String input;
    while (!"q".equalsIgnoreCase(input = scanner.next())) {
      long st = System.currentTimeMillis();
      for (int i = 0; i < Integer.parseInt(input); i++) {
        new String(i + "");
      }
      long end = System.currentTimeMillis();
      System.out.println(">>> done " + (end - st) + " msec");
    }

    System.out.println("Game Over！");
  }
}
