package com.geekbrains.java.algorithms.Lesson7;

import java.util.*;

public class Graph {
    private final int MAX_VERTS;
    private List<Vertex> vertexList;
    private int[][] adjMat;

    public Graph(int maxVerts) {
        MAX_VERTS = maxVerts;
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        vertexList = new ArrayList<>();
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(String label) {
        if (vertexList.size() == MAX_VERTS) {
            throw new ArrayIndexOutOfBoundsException("Достигнуто максимальное количество вершин: " + MAX_VERTS);
        }
        vertexList.add(new Vertex(label));
    }

    public void addEdge(String first, String second) {
        int firstID = vertexList.indexOf(new Vertex(first));
        int secondID = vertexList.indexOf(new Vertex(second));

        adjMat[firstID][secondID] = 1;
        adjMat[secondID][firstID] = 1;
    }

    public void displayVertex(int vertexID) {
        System.out.println(vertexList.get(vertexID));
    }

    public void depthFirstSearch() {
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new LinkedHashSet<>();
        vertexList.get(0).wasVisited = true;
        visited.add(vertexList.get(0));
        stack.push(vertexList.get(0));
        while (!stack.isEmpty()) {
            Vertex v = getAdjUnvisitedVertex(stack.peek());
            if (v == null) {
                stack.pop();
            } else {
                v.wasVisited = true;
                visited.add(v);
                stack.push(v);
            }
        }
        System.out.println(visited);

        for (Vertex vertex : vertexList) {
            vertex.wasVisited = false;
        }
    }

    public void breadthFirstSearch() {
        breadthFirstSearch(vertexList.get(0));
    }

    public void breadthFirstSearch(Vertex start) {
        breadthFirstSearch(start, vertexList.get(vertexList.size()-1));
    }

    public void breadthFirstSearch(Vertex start, Vertex end) {
        Queue<Vertex> queue = new LinkedList<>();
        start.wasVisited = true;
        queue.add(start);
        Vertex currVertex;
        boolean flag = false;
        while (!queue.isEmpty()) {
            Vertex prevVertex = queue.poll();
            while ((currVertex = getAdjUnvisitedVertex(prevVertex)) != null) {
                currVertex.wasVisited = true;
                queue.add(currVertex);
                currVertex.setPrev(prevVertex);
                if (currVertex.equals(end)){
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        ArrayDeque<Vertex> traceDeq = new ArrayDeque<>();
        Vertex curr = vertexList.get(vertexList.indexOf(end));
        while (curr != null) {
            traceDeq.addFirst(curr);
            curr = curr.getPrev();
        }

        List<Vertex> trace = new ArrayList<>(traceDeq);

        System.out.println(trace);

        for (Vertex vertex : vertexList) {
            vertex.wasVisited = false;
        }
    }

    private Vertex getAdjUnvisitedVertex(Vertex vertex) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (adjMat[vertexList.indexOf(vertex)][i] == 1 && !vertexList.get(i).wasVisited) {
                return vertexList.get(i);
            }
        }
        return null;
    }


}
