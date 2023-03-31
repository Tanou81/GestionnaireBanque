package com.example.gestionnairebanque.tests;
import com.example.gestionnairebanque.Transaction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TransactionTest {

    @Test
    public void testTransactionNull () {

        Transaction transaction = new Transaction();
        assertNull( transaction);
    }
}
