package com.example.gestionnairebanque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui permet de gérer les transactions bancaires
 */
public class GestionnaireBancaire {


    private ArrayList<Transaction> transactions;
    private ArrayList<Taux> taux;
    private double solde;

    /**
     * Constructeur par défaut
     */
    public GestionnaireBancaire() {
        this.transactions = new ArrayList<Transaction>();
        this.taux = new ArrayList<Taux>();
        this.solde = 0.0;
    }

    /**
     * Constructeur si parametre
     */
    public GestionnaireBancaire(ArrayList<Transaction> transactions, ArrayList<Taux> taux, double solde) {
        this.transactions = transactions;
        this.taux = taux;
        this.solde = solde;
    }

    public void ajouterTransaction(Transaction t) {
        this.transactions.add(t);
        calculSolde();
    }


    /**
     * methode qui permet de calculer le coefficient trouver dans le fichier taux
     *
     * @param t
     * @return result
     */

    public Double getCoefficient(Transaction t) {
        Double result = 0.0;
        for (int i = 0; i < this.taux.size(); i++) {
            if (t.getMontant() > this.taux.get(i).getSeuilInf()) {
                result = this.taux.get(i).getTaux();
            }
        }
        System.out.println("result is : \n" + result);
        return result;
    }


    /**
     * methode qui permet de calculer le solde
     *
     * @return double
     */
    public Double calculSolde() {
        double total = 0.0;
        loadReferences();
        for (Transaction transaction : this.transactions) {


            System.out.println("transaction.getMontant() is " + transaction.toString());
            if (transaction.getC() == 'C') {

                double resultcoed = transaction.getMontant() * getCoefficient(transaction);
                System.out.println("        resultcoed is " + resultcoed);
                total += transaction.getMontant() - resultcoed;

            } else {

                total -= transaction.getMontant();
            }

            System.out.println("        total is  \n" + total);
        }
        return total;
    }


    /**
     * methode qui de creer un objet Taux
     *
     * @param Ligne
     */
    public void CreateteRef(String Ligne) {
        String[] values = Ligne.split(" ");
        //System.out.println("ligne is "+values.toString());
        Taux taux = new Taux(Double.parseDouble(values[1]), Double.parseDouble(values[2]),
                Double.parseDouble(values[3]), values[0]);
        System.out.println("taux is " + taux.toString());
        this.taux.add(taux);

    }

    /**
     * methode qui permet de lire le fichier taux.txt
     * appel la methode CreateteRef
     */
    private void loadReferences() {
        try {
            Path P1 = Paths.get("src\\main\\resources\\data\\taux.txt");
            List<String> lignes = Files.readAllLines(P1);
// Parcours et affichage
            for (String string : lignes) {
                System.out.println("Ligne is : " + string);
                CreateteRef(string);
            }


        } catch (Exception i) {
            System.out.println("Critere file not found");
        }


    }

    /**
     * methode qui retourne la liste des transactions
     *
     * @return
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * methode qui permet de modifier la liste des transactions
     *
     * @param transactions
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * methode qui retourne la liste des taux
     *
     * @return taux ArrayList
     */
    public ArrayList<Taux> getTaux() {
        return taux;
    }


    /**
     * methode qui permet de retourner le solde
     *
     * @return double solde du compte
     */
    public double getSolde() {
        return solde;
    }


    /**
     * methode qui d'appliquer le taux
     * appel la methode calculSolde
     */
    public void appliquerTaux() {
        this.solde = this.calculSolde();
    }

    /**
     * methode qui permet de savoir si le solde est positif
     *
     * @return boolean
     */
    public Boolean soldePositif() {
        return this.solde > 0;
    }

    /**
     * Singleton de la classe GestionnaireBancaire
     */
    public static GestionnaireBancaire instance = null;
    public static GestionnaireBancaire getInstance() {
        if (instance == null) {
            instance = new GestionnaireBancaire();
        }
        return instance;
    }
    public static void setInstance(GestionnaireBancaire instance) {
        GestionnaireBancaire.instance = instance;
    }

    public String getSoldeString() {
        return String.format("%.2f", this.solde);
    }
}
