package com.example.gestionnairebanque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireBancaire {
    /*
    private ArrayList<Transaction> transactions;
    private ArrayList<Taux> taux;
    private double solde;
    public GestionnaireBancaire() {
        this.transactions = new ArrayList<Transaction>();
        this.taux = new ArrayList<Taux>();
        this.solde = 0.0;
    }
    public GestionnaireBancaire(ArrayList<Transaction> transactions, ArrayList<Taux> taux, double solde) {
        this.transactions = new ArrayList<Transaction>();
        this.taux = new ArrayList<Taux>();
        this.solde = 0.0;
    }

    public void chargerTransactions(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String line = reader.readLine();
        while (line != null) {
            String[] values = line.split(",");
            Transaction transaction = new Transaction(values[0], values[1].charAt(0), Double.parseDouble(values[2]));
            this.transactions.add(transaction);
            line = reader.readLine();
        }
        reader.close();
    }

    public void chargerTaux(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String line = reader.readLine();
        while (line != null) {
            String[] values = line.split(",");
            Taux taux = new Taux(Double.parseDouble(values[0]), Double.parseDouble(values[1]),
                    Double.parseDouble(values[2]), values[3]);
            this.taux.add(taux);
            line = reader.readLine();
        }
        reader.close();
    }

    public Double calculSolde() {
        double total = 0.0;
        for (Transaction transaction : this.transactions) {
            total += transaction.getMontant() * getCoefficient(transaction.getC());
        }
        return total;
    }

    private double getCoefficient(char c) {
        for (Taux taux : this.taux) {

                return taux.getTaux();

        }
        return 0.0;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Taux> getTaux() {
        return taux;
    }

    public void setTaux(ArrayList<Taux> taux) {
        this.taux = taux;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void appliquerTaux() {
        this.solde = this.calculSolde();
    }

    public Boolean soldePositif() {
        return this.solde > 0;
    }*/

    private ArrayList<Transaction> transactions;
    private ArrayList<Taux> taux;
    private double solde;

    public GestionnaireBancaire() {
        this.transactions = new ArrayList<Transaction>();
        this.taux = new ArrayList<Taux>();
        this.solde = 0.0;
    }

    public GestionnaireBancaire(ArrayList<Transaction> transactions, ArrayList<Taux> taux, double solde) {
        this.transactions = transactions;
        this.taux = taux;
        this.solde = solde;
    }

    public void chargerTransactions(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String line = reader.readLine();
        while (line != null) {
            String[] values = line.split(",");
            Transaction transaction = new Transaction(values[0], values[1].charAt(0), Double.parseDouble(values[2]));
            this.transactions.add(transaction);
            line = reader.readLine();
        }
        reader.close();
    }

    public void chargerTaux(String cheminFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
        String line = reader.readLine();
        while (line != null) {
            String[] values = line.split(",");
            Taux taux = new Taux(Double.parseDouble(values[0]), Double.parseDouble(values[1]),
                    Double.parseDouble(values[2]), values[3]);
            this.taux.add(taux);
            line = reader.readLine();
        }
        reader.close();
    }



    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Taux> getTaux() {
        return taux;
    }

    public void setTaux(ArrayList<Taux> taux) {
        this.taux = taux;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void appliquerTaux() {
        this.solde = this.calculSolde();
    }

    public Boolean soldePositif() {
        return this.solde > 0;
    }
}
