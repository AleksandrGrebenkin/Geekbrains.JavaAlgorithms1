package com.geekbrains.java.algorithms.Lesson1;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,-1,-2,-3,-4,-5};
        task1(array);
        task2(array);
    }

    public static void task1(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                    for (int k = j + 1; k < array.length; k++) {
                        if(array[i] + array[j] + array[k] == 0){
                            System.out.println(array[i] + " " + array[j] + " " + array[k]);
                        }
                    }
            }
        }
    }
    public static void task2(int[] array){
        int max1 = array[0];
        int max2 = array[0];
        for (int i = 0; i < array.length ; i++) {
            if (array[i] > max1) {
                max1 = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max2 && array[i] < max1){
                max2 = array[i];
            }
        }
        System.out.println("max1: " + max1 + "; max2: " + max2);
    }
}
