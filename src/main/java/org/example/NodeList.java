package org.example;

public class NodeList {
    public Node firstNode;
    public Node lastNode;
    private int nbNode;

    public NodeList(){
        firstNode = null;
        lastNode = null;
        nbNode = 0;
    }

    public void print(int idx){

    }

    public void addNode(Object object){
        Node newNode = new Node(object);
        Node tmp;

        if (nbNode > 0){
            tmp = lastNode;
            tmp.next = newNode;
            lastNode = newNode;
        } else {
            firstNode = lastNode = newNode;
        }
        nbNode++;

    }

    public int getSize(){
        return nbNode;
    }
}
