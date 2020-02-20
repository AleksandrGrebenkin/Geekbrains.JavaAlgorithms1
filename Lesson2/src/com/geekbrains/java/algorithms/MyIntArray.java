package com.geekbrains.java.algorithms;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class MyIntArray {
    private int[] arr;
    private int size;

    public MyIntArray(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public void add(int value){
        arr[size] = value;
        size++;
    }
    public int get(int index){
        return arr[index];
    }

    public void set(int index, int value){
        arr[index] = value;
        if(size < index) {
            size = index+1;
        }
    }

    public void removeByIndex(int index){
        if (index >= arr.length){
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = index; i < size-1 ; i++) {
                arr[i] = arr[i+1];
            }
            arr[size-1] = 0;
        }
    }

    public void removeByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value){
                removeByIndex(i);
                i--;
            }
        }
    }

    public void randomFill(int minValue, int maxValue){
        if (minValue > maxValue){
            System.err.println("randomFill: minValue > maxValue");
            return;
        }
        size = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*((long) maxValue-minValue) + minValue);
            size++;
        }
    }

    public void randomFill(){
        randomFill(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void print(int elementsInRow){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            if ((i+1)%elementsInRow == 0 && i > 0 && (i+1) < arr.length) {
                System.out.println();
            }
        }
        System.out.printf("\n\n");
    }

    public void print(){
        print(arr.length);
    }

    public void bubbleSort() {
        long ts = System.currentTimeMillis();
        for (int i = arr.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(j, j+1);
                }
            }
        }
        System.out.println("BubbleSort: " + (System.currentTimeMillis() - ts));

    }

    public void selectSort() {
        long ts = System.currentTimeMillis();
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            tmp = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[tmp]){
                    tmp = j;
                }
            }
            swap(i, tmp);
        }
        System.out.println("SelectSort: " + (System.currentTimeMillis() - ts));
    }

    public void insertSort() {
        long ts = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] >= tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
        System.out.println("InsertSort: " + (System.currentTimeMillis() - ts));
    }

    public void mergeSort() {
        long ts = System.currentTimeMillis();
        int[] tmp = new int[arr.length];
        mergeSortInt(arr, tmp, 0, arr.length-1);
        System.out.println("MergeSort: " + (System.currentTimeMillis() - ts));
    }

    private void mergeSortInt(int[] arr, int[] tmp, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSortInt(arr, tmp, lo, mid);
        mergeSortInt(arr, tmp, mid+1, hi);
        merge(arr, tmp, lo, mid, hi);
    }

    private void merge(int[] arr, int[] tmp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }

        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = tmp[j++];
            } else if (j > hi) {
                arr[k] = tmp[i++];
            } else if (tmp[j] < tmp[i]) {
                arr[k] = tmp[j++];
            } else {
                arr[k] = tmp[i++];
            }
        }
    }

    private void swap(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
