package com.code.boy.common;

public class ReferenceTransmit {
  private Object obj = new Object();

  private Object copyObj = obj;

  private void updateReference() {
    this.obj = new Object();
    System.out.println(obj);
    System.out.println(this.copyObj);
  }

  private void referenceTransmit() {
    Object copy = obj;
    this.obj = new Object();
    System.out.println(copy);
    System.out.println(obj);
  }

  public static void main(String[] args) {
    ReferenceTransmit referenceTransmit = new ReferenceTransmit();
    referenceTransmit.referenceTransmit();
    referenceTransmit.updateReference();
  }
}
