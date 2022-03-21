package com.moneyapp;

import com.moneyapp.handlers.BalanceHandler;
import com.moneyapp.handlers.LoginHandler;
import com.moneyapp.handlers.RequestAuthenticator;
import com.moneyapp.handlers.SpendHandler;
import com.moneyapp.handlers.TransactionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.server.RatpackServer;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                .post("login", new LoginHandler())
                .all(new RequestAuthenticator())
                .get("balance", new BalanceHandler())
                .get("transactions", new TransactionHandler())
                .post("spend", new SpendHandler())
                )
        );
    }

}
