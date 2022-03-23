/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.handlers;

import java.util.Arrays;
import org.pac4j.http.client.direct.HeaderClient;
import org.pac4j.jwt.config.encryption.EncryptionConfiguration;
import org.pac4j.jwt.config.encryption.SecretEncryptionConfiguration;
import org.pac4j.jwt.config.signature.SecretSignatureConfiguration;
import org.pac4j.jwt.config.signature.SignatureConfiguration;
import org.pac4j.jwt.credentials.authenticator.JwtAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.registry.Registry;

/**
 *
 * @author corey
 */
public class LoginHandler implements Handler {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionHandler.class);

//    private static final String SALT = "12345678901234567890123456789012";
//
//    final SignatureConfiguration signatureConfiguration = new SecretSignatureConfiguration(SALT);
//    final EncryptionConfiguration encryptionConfiguration = new SecretEncryptionConfiguration(SALT);
//
//    // This is used to validate credentials
//    final JwtAuthenticator jwtAuthenticator = new JwtAuthenticator(Arrays.asList(signatureConfiguration), Arrays.asList(encryptionConfiguration));
//    final HeaderClient headerClient = new HeaderClient("Authorization", jwtAuthenticator);
    static String TOKEN = "TOKEN";

    // TODO: Generate random token. (Pac4j JWT??)
    // TODO: Use Session for persistent storage
    @Override
    public void handle(Context ctx) throws Exception {
        LOG.info("Handling login...");
        // Add the token to the registry for all downstream requests.
        Registry.single(TOKEN);
        // Return the token to the client 
        ctx.getResponse().send(TOKEN);
    }

}
