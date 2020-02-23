package com.geekbrains.java.algorithms;

public class Queue {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == maxSize;
    }

    public int size() {
        return items;
    }

    public void insert(int value) {
        if (isFull()){
            throw new ArrayIndexOutOfBoundsException("Queue is full.");
        } else {
            if(rear == maxSize-1){
                rear = -1;
            }
            queue[++rear] = value;
            items++;
        }
    }

    public int remove() {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Queue is empty.");
        } else{
            int result = queue[front++];
            if (front == maxSize){
                front = 0;
            }
            items--;
            return result;
        }
    }

    public int peek() {
        return queue[front];
    }
}
