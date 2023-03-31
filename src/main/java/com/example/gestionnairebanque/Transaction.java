package com.example.gestionnairebanque;

import java.io.Serializable;
import java.util.Objects;
/**
 * Classe Transaction qui contient les attributs et les methodes de transaction
 */
public class Transaction implements Serializable {
    private String nom;
    private Character c;
    private double montant;

    /**
     * Constructeur par defaut
     */
    public Transaction() {
    }

    /**
     * Constructeur avec parametre de transaction
     * @param nom
     * @param c
     * @param montant
     */
    public Transaction(String nom, Character c, double montant) {
        this.nom = nom;
        this.c = c;
        this.montant = montant;
    }
/**methode pour retourner le nom*/
    public String getNom() {
        return nom;
    }
/**methode pour modifier le nom*/
    public void setNom(String nom) {
        this.nom = nom;
    }

/**methode pour retourner le montant*/
    public double getmontant() {
        return montant;
    }
    /**methode pour modifier le montant */
    public void setmontant(double montant) {
        this.montant = montant;
    }

    /**
     * methode pour retourner le nom, le caractere et le montant
     * @return result
     */
    @Override
    public String toString() {
        String result = "";
        result += "| nom: " + nom;
        result += "| c: " + c;
        result += "| montant: " + montant;
        return result;
    }

    /**
     * methode pour retourner le caractere
     * @return c
     */
    public Character getC() {
        return c;
    }

    /**
     * methode equals pour comparer les transactions
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.montant, montant) == 0 &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(c, that.c);
    }

    /**
     * methode pour creer le hashcode
     * @return hascode
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(nom, c, montant);
    }

    /**
     * methode pour retourner  le montant
     * @param montant
     *
     * @return montant
     */
    public double getMontant() {
        return montant;
    }


}