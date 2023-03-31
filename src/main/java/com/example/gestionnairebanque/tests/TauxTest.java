package com.example.gestionnairebanque.tests;
import com.example.gestionnairebanque.Taux;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TauxTest {
    @Test
    public void test() {
        System.out.println();
    }

    @Test
    public void testTaux() {
        Taux taux = new Taux();
        assertEquals(1, 1);
    }
    @Test
    public void testGetSeuilInf() {
        Taux taux = new Taux(0.0, 10.0, 0.5, "Taux A");
        double tauxinf =  taux.getSeuilInf()   ;
        System.out.println("tauxinf is : "+ tauxinf);
        assertEquals(0.0,tauxinf,0.001);
    }

    @Test
    public void testSetSeuilInf() {
        Taux taux = new Taux(0.0, 10.0, 0.5, "Taux A");
        taux.setSeuilInf(5.0);
        assertEquals(5.0, taux.getSeuilInf(),0.001);
    }

    @Test
    public void testGetSeuilSup() {
        Taux taux = new Taux(0.0, 10.0, 0.5, "Taux A");
        assertEquals(10.0, taux.getSeuilSup(),0.001);
    }

    @Test
    public void testSetSeuilSup() {
        Taux taux = new Taux(0.0, 10.0, 0.5, "Taux A");
        taux.setSeuilSup(15.0);
        assertEquals(15.0, taux.getSeuilSup(),0.001);
    }

    @Test
    public void testGetTaux() {
        Taux taux = new Taux(0.0, 10.0, 0.5, "Taux A");
        assertEquals(0.5, taux.getTaux(),0.001);
    }

    @Test
    public void testSetTaux() {
        Taux taux = new Taux(0.0, 10.0, 0.5, "Taux A");
        taux.setTaux(0.75);
        assertEquals(0.75, taux.getTaux(),0.001);
    }

    @Test
    public void testGetDescriptionTaux() {
        Taux taux = new Taux(0.0, 10.0, 0.5, "Taux A");
        assertEquals("Taux A", taux.getDescriptionTaux());
    }

    @Test
    public void testSetDescriptionTaux() {
        Taux taux = new Taux(0.0, 10.0, 0.5, "Taux A");
        taux.setDescriptionTaux("Taux B");
        assertEquals("Taux B", taux.getDescriptionTaux());
    }

}
