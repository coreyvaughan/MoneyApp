/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.handlers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.moneyapp.objects.Transaction;
import com.moneyapp.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;
import ratpack.session.Session;

/**
 *
 * @author corey
 */
@Singleton
public class SpendHandler implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(SpendHandler.class);

//    private final TransactionService transactionService;
//    @Inject
//    public SpendHandler(TransactionService transactionService) {
//        this.transactionService = transactionService;
//    }
    @Override
    public void handle(Context ctx) throws Exception {
        LOG.info("Handling spend...");
        ctx.parse(Transaction.class).then(transaction -> {
//            Session session = ctx.get(Session.class);
//            session.set("payment", transaction);
            ctx.render(Jackson.json(transaction));
        });
    }

}
