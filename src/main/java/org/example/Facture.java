package org.example;

public class Facture {
    public Node<ElementFacture> firstNode;
    public Node<ElementFacture> lastNode;
    private int nbNode;
    private double total;

    public Facture() {
        firstNode = null;
        lastNode = null;
        nbNode = 0;
    }

    public void ajouterElementFacture(ElementFacture el) {
        Node<ElementFacture> newNode = new Node(el);
        Node<ElementFacture> tmp;

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
        Node<ElementFacture> tmp;

        tmp = firstNode;
        for (int i = 0; i < nbNode; i++) {
            items[i] = tmp.object;
            tmp = tmp.next;
        }
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
