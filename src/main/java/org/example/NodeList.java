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
        Node tmp;

        System.out.println("Content of the linked list");
        System.out.println("==========================");
        tmp = firstNode;
        for (int i = 0; i < nbNode; i++) {
            System.out.println(tmp.object + " --> ");
            tmp = tmp.next;
        }
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
