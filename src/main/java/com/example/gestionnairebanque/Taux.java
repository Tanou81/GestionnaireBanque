package com.example.gestionnairebanque;

import java.io.Serializable;


/**
 * Classe Taux qui contient les attributs et les methodes de taux
 */
public class Taux {
    public Taux() {
    }

    private double seuilInf;
    private double seuilSup;

    private double taux;

private String descriptionTaux;

    /**
     * Constructeur avec parametre de taux
     * @param seuilInf
     * @param seuilSup
     * @param taux
     * @param descriptionTaux
     */
  public Taux(double seuilInf, double seuilSup, double taux, String descriptionTaux) {
        this.seuilInf = seuilInf;
        this.seuilSup = seuilSup;
        this.taux = taux;
        this.descriptionTaux = descriptionTaux;
    }

    /**
     * methode pour retourner le seuilInf
     * @return
     */
    public double getSeuilInf() {
      //System.out.println("getSeuilInf is : "+ this.seuilInf);
        return  this.seuilInf;
    }

    /**
     * methode pour modifier le seuilInf
     * @param seuilInf
     */
    public void setSeuilInf(double seuilInf) {
        this.seuilInf = seuilInf;
    }

    /**
     * methode pour retourner le seuilSup
     * @return
     */
    public double getSeuilSup() {
        return seuilSup;
    }

    /**
     * methode pour modifier le seuilSup
     * @param seuilSup
     */
    public void setSeuilSup(double seuilSup) {
        this.seuilSup = seuilSup;
    }

    /**
     * methode pour retourner le taux
     * @param taux
     */
    public double getTaux() {
        return taux;
    }

    /**
     * methode pour modifier le taux
    @param taux

     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

    /**
     * methode pour retourner la description du taux
     * @return String
     */
    public String getDescriptionTaux() {
        return descriptionTaux;
    }

    /**
     * methode pour modifier la description du taux
     * @param descriptionTaux
     */
    public void setDescriptionTaux(String descriptionTaux) {
        this.descriptionTaux = descriptionTaux;
    }

    /**
     * methode pour retourner le seuilInf, le seuilSup, le taux et la description du taux
     * refitinition de la methode toString
     * @return
     */
    @Override
    public String toString(){
        String result = "";
        result += " seuilInf: " + seuilInf ;
        result += " seuilSup: " + seuilSup ;
        result += " taux: " + taux ;
        result += " descriptionTaux: " + descriptionTaux ;
        return result;
    }
}
