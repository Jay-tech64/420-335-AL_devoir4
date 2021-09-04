package org.example;

public class Node<T> {
    public T object;
    public Node<T> next;

    public Node(T t){
        this.object = t;
        next = null;
    }
}
