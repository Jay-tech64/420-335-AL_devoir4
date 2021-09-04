package org.example;

import org.example.helper.Clavier;

import java.io.PrintStream;

public class UltimatePOS {
    private PrintStream os;
    private Facture facture;
    private HistoriqueFacture historiqueFacture = new HistoriqueFacture();


    //Ajouter une liste de facture

    public UltimatePOS(PrintStream os){
        this.os = os;
        this.facture = new Facture();
    }

    public UltimatePOS() {
        this(System.out);
    }

    public void run(){

        printStartup();
        printCommands();

        for(;;){
            runCommand(getCommand());
        }
    }

    private void printStartup(){
        os.println("***********************************************");
        os.println("* Bienvenue au mega systeme de point de vente *");
        os.println("*         U L T I M A T E - P . O . S         *");
        os.println("* Version PRO 3.1416 License indeterminable   *");
        os.println("***********************************************");
    }

    // Ajouter un méthdoe qui imprime la liste de facture

    private void printCommands(){
        os.println("Commandes : ");
        os.println("\ta : Ajoute un element a la facture");
        os.println("\tp : Imprime la facture");
        os.println("\tn : Nouvelle facture");
        os.println("\th : Afficher l'historique des factures");
        os.println("\tq : Quitter");
        os.println("\t? : Affiche la liste des commandes");
        os.println("\ts : Affiche l'ecran d'acceuil");
    }

    private void runCommand(String command){
        switch(command) {
            case "a" : commandAdd(); break;
            case "p" : commandPrint(); break;
            case "n" : commandNew(); break;
            case "h" : commandHistorique(); break;
            case "q" : commandQuit(); break;
            case "?" : printCommands(); break;
            case "s" : printStartup(); printCommands(); break;
            default : commandNotFound(command); break;

        }
    }

    private String getCommand() {
        os.print("cmd?>");
        return Clavier.lireLigne();
    }

    private void commandNotFound(String cmd){
        os.println(String.format("Commande \"%s\" non existante!\nVoici la liste des commandes disponibles :", cmd));
        printCommands();
    }



    private void commandAdd(){
        String nom;
        int qt;
        double prix;

        os.print("Nom de l'article?>");
        nom = Clavier.lireLigne();
        os.print("#?>");
        qt = Integer.parseInt(Clavier.lireLigne());
        os.print("$?>");
        prix = Double.parseDouble(Clavier.lireLigne());

        facture.ajouterElementFacture(new ElementFacture(nom, qt, prix));
    }

    private void commandHistorique(){
        os.println("L'historique des factures : ");
        for(Facture facture : historiqueFacture.getFactures()) {
            os.println(String.format("\t%s", facture.getTotal()));
        }
        os.println("-----------------------------------------------");
        os.println(String.format("total des factures : %.2f",historiqueFacture.getTotalFactures()));
        os.println("-----------------------------------------------");

    }

    private void commandPrint() {
        os.println("La facture : ");
        for(ElementFacture el : facture.getElementsFacture()) {
            os.println(String.format("\t%s", el.toString()));
        }
        os.println("-----------------------------------------------");
        os.println(String.format("prix total : %.2f", facture.getTotal()));
        os.println("-----------------------------------------------");
    }

    private void commandNew() {
        try {
            os.println("On oublie l'ancienne facture...");
            // Avant de la supprimer, l'ajouter à une historique d'une liste de facture
            historiqueFacture.ajouterFacture(facture);
            facture = new Facture();
            Thread.sleep(200);
            os.println("... Nouvelle facture prête à l'action!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void commandQuit() {
        os.println("Au revoir!! Et merci d'avoir fait vos achats avec UltimatePOS!");
        os.println("UltimatePOS : le leader des POS artisanaux bio-éthiques.");
        System.exit(0);
    }


    public static void main(String... args){
        UltimatePOS pos = new UltimatePOS();
        pos.run();
    }
}
