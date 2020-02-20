package com.geekbrains.java.algorithms;

public class Deque {
    private int maxSize;
    private int[] deque;
    private int left;
    private int right;
    private int items;

    public Deque(int size) {
        maxSize = size;
        deque = new int[maxSize];
        int left = 0;
        int right = -1;
        int items = 0;
    }

    public boolean isFull() {
        return items == maxSize;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public int size() {
        return items;
    }

    public void insertLeft(int value) {
        if (!isFull()) {
            if (left == 0) {
                left = maxSize;
            }
            deque[--left] = value;
            items++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Deque is full.");
        }
    }

    public int removeLeft() {
        if (!isEmpty()) {
            int result = deque[left++];
            if (left == maxSize){
                left = 0;
            }
            items--;
            return result;
        } else {
            throw new ArrayIndexOutOfBoundsException("Deque is empty.");
        }
    }

    public void insertRight(int value) {
        if (!isFull()){
            if (right == maxSize - 1){
                right = -1;
            }
            deque[++right] = value;
            items++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Deque is full.");
        }
    }

    public int removeRight() {
        if (!isEmpty()){
            int result = deque[right--];
            if (right == -1){
                right = maxSize - 1;
            }
            items--;
            return result;
        } else {
            throw new ArrayIndexOutOfBoundsException("Deque is empty.");
        }
    }

    public int peekRight() {
        return deque[right];
    }

    public int peekLeft() {
        return deque[left];
    }
}
