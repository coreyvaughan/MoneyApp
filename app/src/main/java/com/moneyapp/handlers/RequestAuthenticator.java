/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.handlers;

import io.netty.handler.codec.http.HttpHeaderNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 *
 * @author corey
 */
public class RequestAuthenticator implements Handler {

    private static final Logger LOG = LoggerFactory.getLogger(RequestAuthenticator.class);

    @Override
    public void handle(Context ctx) throws Exception {
        try {
            LOG.info("Checking authorization header...");
            String authHeader = ctx.getRequest().getHeaders().get(HttpHeaderNames.AUTHORIZATION);

            if (authHeader == null || !authHeader.startsWith("Bearer")) {
                throw new Exception("No token supplied in request header");
            }

            String token = authHeader.substring(7);

            // Validate token
            if (!"TOKEN".equals(token)) {
                ctx.getResponse().send("INVALID TOKEN");
            }

            ctx.next();
        } catch (Exception e) {
            ctx.getResponse().send("401 - Unauthorized");
        }
    }

}
