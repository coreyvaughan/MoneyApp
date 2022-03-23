/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author corey
 */
public class Transaction implements Serializable {

    private int userId;
    private Date date;
    private String description;
    // Make this an enum??
    private String currency;
    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(int userId, Date date, String description, String currency, BigDecimal amount) {
        this.userId = userId;
        this.date = date;
        this.description = description;
        this.currency = currency;
        this.amount = amount;
    }

    // Use a lib to get rid of these?
    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
