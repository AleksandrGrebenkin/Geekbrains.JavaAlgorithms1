package com.geekbrains.java.algorithms;



public class Main {
    public static void main(String[] args) {
        MyIntArray arr = new MyIntArray(500_000);
        long ts = System.currentTimeMillis();
        arr.randomFill(-1000, 1000);
        System.out.println("Delay: " + (System.currentTimeMillis() - ts));
        arr.bubbleSort();
        arr.randomFill(-1000, 1000);
        arr.selectSort();
        arr.randomFill(-1000, 1000);
        arr.insertSort();
        arr.randomFill(-1000, 1000);
        arr.mergeSort();
    }



}
