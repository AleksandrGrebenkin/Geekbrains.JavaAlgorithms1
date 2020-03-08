package com.geekbrains.java.algorithms.Lesson8;

public class MainApp {
    public static void main(String[] args) {
        Item i1 = new Item(1);
        Item i2 = new Item(2);
        Item i3 = new Item(3);
        Item i4 = new Item(4);
        Item i5 = new Item(5);
        Item i6 = new Item(6);
        Item i7 = new Item(7);

        HashTable hashTable = new HashTable(3);
        hashTable.insert(i1);
        hashTable.insert(i2);
        hashTable.insert(i3);
        hashTable.insert(i4);
        hashTable.insert(i5);
        hashTable.insert(i6);
        hashTable.insert(i7);

        hashTable.display();
        System.out.println();
        System.out.println(hashTable.find(4).getKey());
        System.out.println();
        System.out.println(hashTable.delete(6).getKey());
        System.out.println();
        hashTable.display();
    }
}
