package org.example;

public class Node {
    public ElementFacture elementFacture;
    public Node next;

    public Node(ElementFacture elementFacture){
        this.elementFacture = elementFacture;
        next = null;
    }
}
