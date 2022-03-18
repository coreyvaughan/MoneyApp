package com.moneyapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.server.RatpackServer;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                .post("login", ctx -> ctx.render("Login"))
                .get("balance", ctx -> ctx.render("Balance"))
                .get("transactions", ctx -> ctx.render("Transactions"))
                .post("spend", ctx -> ctx.render("Spend"))
                )
        );
    }

}
