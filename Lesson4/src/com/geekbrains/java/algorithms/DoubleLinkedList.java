package com.geekbrains.java.algorithms;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T>{

    private Node<T> first;
    private Node<T> last;

    public DoubleLinkedList() {
        first = new Node<>(null);
        last = new Node<>(null);
        first.next = last;
        last.prev = first;
    }

    public void insertTail(T value) {
        Node<T> lastPrev = this.last.prev;
        Node<T> newNode = new Node<>(value);
        newNode.next = this.last;
        newNode.prev = lastPrev;
        lastPrev.next = newNode;
        last.prev = newNode;
    }

    public void insertHead(T value) {
        Node<T> firstNext = this.first.next;
        Node<T> newNode = new Node<>(value);
        newNode.prev = this.first;
        newNode.next = firstNext;
        first.next = newNode;
        firstNext.prev = newNode;
    }

    public T deleteHead() {
        T value = first.next.value;
        Node<T> temp = first.next.next;
        first.next = temp;
        temp.prev = first;
        return value;
    }

    public T deleteTail() {
        T value = last.prev.value;
        Node<T> temp = last.prev.prev;
        last.prev = temp;
        temp.next = last;
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> curr = first.next;

            @Override
            public boolean hasNext() {
                return curr != last;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    public void display() {
        Node<T> current = first.next;
        while (current != last) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

    }
}
