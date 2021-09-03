package org.example;

import javax.swing.text.Element;

public class Facture {
    public Node firstNode;
    public Node lastNode;
    private int nbNode;

    public Facture() {
        firstNode = null;
        lastNode = null;
        nbNode = 0;
    }

    public void ajouterElementFacture(ElementFacture el) {
        Node newNode = new Node(el);
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



    public ElementFacture[] getElementsFacture() {
        ElementFacture[] items = new ElementFacture[nbNode];
        Node tmp;

        tmp = firstNode;
        for (int i = 0; i < nbNode; i++) {
            items[i] = tmp.elementFacture;
            tmp = tmp.next;
        }
        return items;
    }

}
