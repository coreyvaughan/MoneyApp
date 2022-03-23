/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.module;

import com.google.inject.AbstractModule;
import com.moneyapp.objects.Transaction;
import com.moneyapp.objects.User;
import ratpack.session.SessionModule;

/**
 * Defines the allowed types for serialization by the SessionModule
 *
 * @author corey
 */
public class SessionTypesModule extends AbstractModule {

    @Override
    protected void configure() {
        SessionModule.allowTypes(binder(),
                Transaction.class,
                User.class
        );
    }
}
