/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.handlers;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.registry.Registry;

/**
 *
 * @author corey
 */
public class LoginHandler implements Handler{

    static String TOKEN = "TOKEN";
    
    @Override
    public void handle(Context ctx) throws Exception {
        // Add the token to the registry for all downstream requests.
        Registry.single(TOKEN);
        // Return the token to the client
        ctx.getResponse().send(TOKEN);
    }
    
}
