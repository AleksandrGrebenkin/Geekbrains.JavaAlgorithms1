package com.geekbrains.java.algorithms.Lesson6;

public class MainApp {
    public static void main(String[] args) {
        Tree[] trees = new Tree[20];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree();
            for (int j = 0; j < 15; j++) {
                trees[i].insert((int)(Math.random()*200-100));
            }
        }
        for (int i = 0; i < trees.length; i++) {
            trees[i].displayTree();
        }
    }
}
