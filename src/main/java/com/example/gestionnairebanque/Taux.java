package com.example.gestionnairebanque;

import java.io.Serializable;

public class Taux {
    public Taux() {
    }

    private double seuilInf;
    private double seuilSup;

    private double taux;

private String descriptionTaux;


  public Taux(double seuilInf, double seuilSup, double taux, String descriptionTaux) {
        this.seuilInf = seuilInf;
        this.seuilSup = seuilSup;
        this.taux = taux;
        this.descriptionTaux = descriptionTaux;
    }
    public double getSeuilInf() {
      //System.out.println("getSeuilInf is : "+ this.seuilInf);
        return  this.seuilInf;
    }

    public void setSeuilInf(double seuilInf) {
        this.seuilInf = seuilInf;
    }

    public double getSeuilSup() {
        return seuilSup;
    }

    public void setSeuilSup(double seuilSup) {
        this.seuilSup = seuilSup;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public String getDescriptionTaux() {
        return descriptionTaux;
    }

    public void setDescriptionTaux(String descriptionTaux) {
        this.descriptionTaux = descriptionTaux;
    }


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
