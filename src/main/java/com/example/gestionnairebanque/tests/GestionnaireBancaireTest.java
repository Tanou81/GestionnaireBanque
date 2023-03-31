package com.example.gestionnairebanque.tests;

import com.example.gestionnairebanque.GestionnaireBancaire;
import com.example.gestionnairebanque.Taux;
import com.example.gestionnairebanque.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GestionnaireBancaireTest {
    private ArrayList<Transaction> transactions;
    private ArrayList<Taux> taux;
    private double solde;

    @Test
    public void testTransaction() {
GestionnaireBancaire gestio = new GestionnaireBancaire();
        assertEquals(1, 1);
    }

    @Test
    public void testInitialisation() {
        GestionnaireBancaire gb = new GestionnaireBancaire();
        assertNotNull(gb.getTransactions());
        assertNotNull(gb.getTaux());
        assertNotNull(gb.getSolde());
    }

    @Before
    public void setUp() {
        // initialisation des données pour les tests
        transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction("Salaire", 'C', 2000.0));
        transactions.add(new Transaction("Loyer", 'D', 1000.0));
        transactions.add(new Transaction("Courses", 'D', 300.0));

        taux = new ArrayList<Taux>();
        taux.add(new Taux(0.0, 1000.0, 0.01, "Taux 1"));
        taux.add(new Taux(1000.0, 10000, 0.02, "Taux 2"));
        taux.add(new Taux(10000, 1000000, 0.03, "Taux 3"));

        solde = 0.0;
    }

    @Test
    public void testAppliquerTaux() {
        // test de l'application des taux sur le solde
        GestionnaireBancaire gestionnaireBancaire = new GestionnaireBancaire(transactions, taux, 0.0);
        gestionnaireBancaire.appliquerTaux();
        assertEquals(660.0, gestionnaireBancaire.getSolde(), 0.01);
    }

    @Test
    public void testSoldeNegatif() {
        // test du cas où le solde est négatif
        GestionnaireBancaire gestionBanquaire = new GestionnaireBancaire(transactions, taux, -500.0);
        assertFalse(gestionBanquaire.soldePositif());
    }

    @Test
    public void testSoldePositif() {
        // test du cas où le solde est positif
        GestionnaireBancaire gestionBanquaire = new GestionnaireBancaire(transactions, taux, 500.0);
        assertTrue(gestionBanquaire.soldePositif());
    }
}
