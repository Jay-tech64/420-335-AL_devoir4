package org.example;

import javax.swing.text.Element;

public class Facture {

    public Facture() {

    }

    public void ajouterElementFacture(ElementFacture el) {
        // A implementer
    }

    // Transformer les deux méthodes suivants par une liste chainés
    public ElementFacture[] getElementsFacture() {
        return new ElementFacture[0];
    }

    private ElementFacture[] elements = new ElementFacture[3];

}
