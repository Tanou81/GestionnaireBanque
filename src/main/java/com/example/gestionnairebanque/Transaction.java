package com.example.gestionnairebanque;

import java.io.Serializable;
import java.util.Objects;

public class Transaction implements Serializable {
    private String nom;
    private Character c;
    private double montant;

    public Transaction() {
    }

    public Transaction(String nom, Character c, double montant) {
        this.nom = nom;
        this.c = c;
        this.montant = montant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public double getmontant() {
        return montant;
    }

    public void setmontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        String result = "";
        result += " nom: " + nom;
        result += " c: " + c;
        result += " montant: " + montant;
        return result;
    }
    public Character getC() {
        return c;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.montant, montant) == 0 &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(c, that.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, c, montant);
    }

    public double getMontant() {
        return montant;
    }

    public Character getc() {
        return c;
    }
}