package com.geekbrains.java.algorithms;

public class Stack {
    private int maxSize;
    private int[] stack;
    private int top;

    public Stack(int size) {
        maxSize = size;
        this.stack = new int[this.maxSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int value) {
        if (top + 1 < maxSize){
            stack[++top] = value;
        }
        else throw new ArrayIndexOutOfBoundsException();
    }

    public int pop() {
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }
}
