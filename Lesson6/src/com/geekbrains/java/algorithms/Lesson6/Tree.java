package com.geekbrains.java.algorithms.Lesson6;

public class Tree {

    private Node root;

    public Node find(int value){
        Node current = root;
        while (current != null && current.value != value) {
            if (value < current.value) {
                current = current.leftNode;
            } else {
                current = current.rightNode;
            }
        }
        return current;
    }

    public void insert(int value){
        Node node = new Node();
        node.value = value;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parrent;
            while (true) {
                parrent = current;
                if (value == current.value) {
                    return;
                }
                if (value < current.value) {
                    current = current.leftNode;
                    if (current == null) {
                        parrent.leftNode = node;
                        return;
                    }
                } else {
                    current = current.rightNode;
                    if (current == null) {
                        parrent.rightNode = node;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int value) {
        Node current = root;
        Node parent = root;
        boolean isLeftNode = true;

        while (current.value != value) {
            parent = current;
            if (value < current.value) {
                isLeftNode = true;
                current = current.leftNode;
            } else {
                isLeftNode = false;
                current = current.rightNode;
            }

            if (current == null) {
                return false;
            }
        }

        if (current.leftNode == null && current.rightNode == null) {
            if (current == root) {
                root = null;
            } else if (isLeftNode) {
                parent.leftNode = null;
            } else {
                parent.rightNode = null;
            }
        } else if (current.leftNode == null) {
            if (current == root) {
                root = current.rightNode;
            } else if (isLeftNode) {
                parent.leftNode = current.rightNode;
            } else {
                parent.rightNode = current.rightNode;
            }
        } else if (current.rightNode == null) {
            if (current == root) {
                root = current.leftNode;
            } else if (isLeftNode) {
                parent.leftNode = current.leftNode;
            } else {
                parent.rightNode = current.leftNode;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftNode) {
                parent.leftNode = successor;
            } else {
                parent.rightNode = successor;
            }
            successor.leftNode = current.leftNode;
        }
        return true;
    }

    public void displayTree(){
        Stack stack = new Stack(500);
        stack.push(root);
        int nBlanks = 64;
        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack localStack = new Stack(500);
            isRowEmpty = true;
            for(int i=0;i<nBlanks;i++){
                System.out.print(" ");
            }
            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                if (temp != null){
                    temp.display();
                    localStack.push(temp.leftNode);
                    localStack.push(temp.rightNode);
                    if(temp.leftNode != null || temp.rightNode != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("..........................................");
        }
    }


    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightNode;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }

        if (successor != node.rightNode) {
            successorParent.leftNode = successor.rightNode;
            successor.rightNode = node.rightNode;
        }

        return successor;
    }
}
