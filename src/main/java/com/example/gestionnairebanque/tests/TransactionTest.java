package com.example.gestionnairebanque.tests;
import com.example.gestionnairebanque.Transaction;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {

    @Test
    public void testTransaction1 () {

        Transaction transaction = new Transaction();
        assertEquals(transaction,  transaction);
    }

    @Test
    public void testGetNom() {
        Transaction transaction = new Transaction("client1", 'C', 1000.0);
        assertEquals("client1", transaction.getNom());
    }

    @Test
    public void testSetNom() {
        Transaction transaction = new Transaction("client1", 'C', 1000.0);
        transaction.setNom("client2");
        assertEquals("client2", transaction.getNom());
    }

    @Test
    public void testGetMontant() {
        Transaction transaction = new Transaction("client1", 'C', 1000.0);
        assertEquals(1000.0, transaction.getmontant(), 0.01);
    }

    @Test
    public void testSetMontant() {
        Transaction transaction = new Transaction("client1", 'C', 1000.0);
        transaction.setmontant(2000.0);
        assertEquals(2000.0, transaction.getmontant(), 0.01);
    }

    @Test
    public void testToString() {
        Transaction transaction = new Transaction("client1", 'C', 1000.0);
        String expectedString = " nom: client1 c: C montant: 1000.0";
        assertEquals(expectedString, transaction.toString());
    }

    @Test
    public void testConstructor() {
        Transaction t = new Transaction("John", 'D', 100.0);
        assertNotNull(t);
        assertEquals("John", t.getNom());
        Character c = 'D';
        assertEquals('D', c.charValue());
        assertEquals(100.0, t.getmontant(), 0.001);
    }

    @Test
    public void testSetNomBis() {
        Transaction t = new Transaction();
        t.setNom("Jane");
        assertEquals("Jane", t.getNom());
    }

    @Test
    public void testSetMontantBis() {
        Transaction t = new Transaction();
        t.setmontant(50.0);
        assertEquals(50.0, t.getmontant(), 0.001);
    }

    @Test
    public void testEquals() {
        Transaction t1 = new Transaction("John", 'D', 100.0);
        Transaction t2 = new Transaction("John", 'D', 100.0);
        assertEquals(t1, t2);
    }

    @Test
    public void testNotEquals() {
        Transaction t1 = new Transaction("John", 'D', 100.0);
        Transaction t2 = new Transaction("Jane", 'D', 100.0);
        assertNotEquals(t1, t2);
    }

    @Test
    public void testToStringBis() {
        Transaction t = new Transaction("John", 'D', 100.0);
        String expected = " nom: John c: D montant: 100.0";
        assertEquals(expected, t.toString());
    }
}
