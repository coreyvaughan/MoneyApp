/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.handlers;

import com.moneyapp.objects.Transaction;
import com.moneyapp.services.TransactionService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

/**
 *
 * @author corey
 */
public class TransactionHandler implements Handler {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionHandler.class);

    @Override
    public void handle(Context ctx) throws Exception {
        LOG.info("Handling transaction...");

        // Get all transactions
        TransactionService ts = new TransactionService();
        List<Transaction> response = ts.getAllUserTransactions(1);

        ctx.render(Jackson.json(response));
    }
}
