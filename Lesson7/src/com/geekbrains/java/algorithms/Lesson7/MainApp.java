package com.geekbrains.java.algorithms.Lesson7;

public class MainApp {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
//        graph.addVertex("G");

        graph.addEdge("A", "B"); //AB
        graph.addEdge("B", "C"); //BC
        graph.addEdge("B", "F"); //BF
        graph.addEdge("C", "F"); //CF
        graph.addEdge("A", "D"); //AD
        graph.addEdge("D", "E"); //DE
/*
*       A ->    B ->    C  ->    F
*                 ->    F
*         ->    D ->    E
* */
        graph.depthFirstSearch();
        System.out.println("-----------------------------");
        graph.breadthFirstSearch();
        graph.breadthFirstSearch(new Vertex("F"), new Vertex("E"));
    }
}
