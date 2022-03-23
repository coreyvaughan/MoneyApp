package com.moneyapp;

import com.moneyapp.handlers.BalanceHandler;
import com.moneyapp.handlers.LoginHandler;
import com.moneyapp.handlers.RequestAuthenticator;
import com.moneyapp.handlers.SpendHandler;
import com.moneyapp.handlers.TransactionHandler;
import com.moneyapp.module.SessionTypesModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.guice.Guice;
import ratpack.server.RatpackServer;
import ratpack.session.SessionModule;
import ratpack.session.store.RedisSessionModule;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                // TODO: Fix java.lang.reflect.InaccessibleObjectException
//                .registry(Guice.registry(r -> { r
//                            .module(SessionModule.class)
//                            .module(SessionTypesModule.class)
//                            .module(RedisSessionModule.class, c -> {
//                                c.setHost("localhost");
//                                c.setPort(6379);
//                                c.setPassword("");
//                            });
//                }))
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
