package com.geekbrains.java.algorithms;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T>{

    private Node<T> first = null;
    private Node<T> last = null;
    private int size = 0;

    public void add(T element) {
        add(element, size);
    }

    private void addFirst(T element) {
        Node<T> node = new Node<>(element);
        if (first == null) {
            last = node;
        } else {
            node.next = first;
        }
        first = node;
        size++;
    }

    private void addLast(T element) {
        Node<T> node = new Node<>(element);
        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    public void add(T element, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            if (index == 0) {
                addFirst(element);
            } else if (index == size) {
                addLast(element);
            } else {
                Node<T> newNode = new Node<>(element);
                Node<T> current = first;
                for (int i = 0; i < index ; i++) {
                    if (i == index - 1) {
                        newNode.next = current.next;
                        current.next = newNode;
                        break;
                    }
                    current = current.next;
                }
            }
        }
    }

    public T removeAt(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            if (index == 0) {
                return removeFirst();
            } else if (index == size -1) {
                return removeLast();
            } else {
                Node<T> current = first;
                Node<T> prev = null;
                T value;
                for (int i = 0; i <= index; i++) {
                    if (i == index) {
                        value = current.value;
                        prev.next = current.next;
                        return value;
                    }
                    prev = current;
                    current = current.next;
                }
                return null;
            }
        }
    }

    private T removeFirst() {
        if (first == null) {
            throw new IndexOutOfBoundsException();
        } else {
            T value = first.value;
            first = first.next;
            if (first == null) {
                last = null;
            }
            size--;
            return value;
        }
    }

    private T removeLast() {
        if (last == null) {
            throw new IndexOutOfBoundsException();
        } else {
            T value = last.value;
            Node<T> prev = findPrev(last);
            last = prev;
            if (last == null) {
                first = null;
            } else {
                prev.next = null;
            }
            return value;
        }
    }

    public void push(T value) {
        addLast(value);
    }

    public T pop() {
        return removeLast();
    }

    public T peek() {
        return last.value;
    }

    public void enqueue(T value) {
        addLast(value);
    }

    public T dequeue() {
        return removeFirst();
    }

    private Node<T> findPrev(Node<T> node) {
        if (node == first) {
            return null;
        } else {
            Node<T> prev = first;
            while (prev != null && prev.next != node) {
                prev = prev.next;
            }
            return prev;
        }
    }

    public void display() {
        Node<T> current = first;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> curr = first;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
