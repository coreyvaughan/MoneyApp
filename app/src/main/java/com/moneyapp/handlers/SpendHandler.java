/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.handlers;

import com.moneyapp.objects.Transaction;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

/**
 *
 * @author corey
 */
public class SpendHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(Transaction.class).then(transaction -> {
            ctx.render(Jackson.json(transaction));
        });
    }

}
