/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.handlers;

import com.moneyapp.objects.User;
import com.moneyapp.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 *
 * @author corey
 */
public class BalanceHandler implements Handler {

    private static final Logger LOG = LoggerFactory.getLogger(BalanceHandler.class);
    private final User user = new User(1);

    @Override
    public void handle(Context ctx) throws Exception {
        LOG.info("Handling balance...");
//        String TOKEN = ctx.maybeGet(String.class).orElse(null);
//        LOG.info("Token is: {}", TOKEN);
        // Get user token from db

        // Get all transactions
        // TODO: Change to ctx.get(TransactionService.class)
        TransactionService ts = new TransactionService();
        String totalBalance = ts.getTotalUserBalance(1).toString();

        ctx.render(totalBalance);

    }

}
