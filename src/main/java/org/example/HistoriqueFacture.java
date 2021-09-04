package org.example;

public class HistoriqueFacture {
    public Node<Facture> firstNode;
    public Node<Facture> lastNode;
    private int nbNode;
    private double totalFactures;

    public HistoriqueFacture() {
        firstNode = null;
        lastNode = null;
        nbNode = 0;
        totalFactures = 0;
    }

    public void ajouterFacture(Facture facture){
        Node<Facture> newNode = new Node(facture);
        Node<Facture> tmp;

        if (nbNode > 0){
            tmp = lastNode;
            tmp.next = newNode;
            lastNode = newNode;
        } else {
            firstNode = lastNode = newNode;
        }
        setTotalFactures(getTotalFactures() + newNode.object.getTotal());
        nbNode++;
    }

    public Facture[] getFactures() {
        Facture[] factures = new Facture[nbNode];
        Node<Facture> tmp;

        tmp = firstNode;
        for (int i = 0; i < nbNode; i++) {
            factures[i] = tmp.object;
            tmp = tmp.next;
        }
        return factures;
    }

    public double getTotalFactures() {
        return totalFactures;
    }

    public void setTotalFactures(double totalFactures) {
        this.totalFactures = totalFactures;
    }
}
