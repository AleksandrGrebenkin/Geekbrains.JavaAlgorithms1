package com.geekbrains.java.algorithms.Lesson8;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private List<Item>[] hashArr;
    private int arrSize;
    private int capacity;

    public HashTable(int size){
        this.arrSize = size;
        hashArr = new LinkedList[arrSize];
        capacity = size;
    }

    public void display(){
        for(int i=0;i<arrSize;i++){
            if(hashArr[i] != null){
                hashArr[i].forEach(item -> System.out.println(item.getKey()));
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key){
        return key % arrSize;
    }

    public void insert(Item item){
        int hashVal = hashFunc(item.getKey());
        if (hashArr[hashVal] == null) {
            List<Item> cur = new LinkedList<>();
            cur.add(item);
            hashArr[hashVal] = cur;
        } else {
            hashArr[hashVal].add(item);
        }
    }

    public Item delete(int key){
        int hashVal = hashFunc(key);
        List<Item> cur = hashArr[hashVal];
        Item result = null;
        for (Item i : cur) {
            if (i.getKey() == key) {
                result = i;
            }
        }
        cur.remove(result);
        return result;
    }

    public Item find(int key){
        int hashVal = hashFunc(key);
        List<Item> cur = hashArr[hashVal];
        for (Item i : cur) {
            if (i.getKey() == key) {
                return i;
            }
        }
        return null;
    }

}
