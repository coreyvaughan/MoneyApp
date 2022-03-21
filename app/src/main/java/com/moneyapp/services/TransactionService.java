/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneyapp.services;

import com.moneyapp.objects.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author corey
 */
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    public TransactionService() {
        transactions.add(new Transaction(1, new Date(), "Cheese sandwich", "GBP", new BigDecimal("2.40")));
        transactions.add(new Transaction(1, new Date(), "Kebab", "GBP", new BigDecimal("590")));
        transactions.add(new Transaction(1, new Date(), "Hot Dog", "GBP", new BigDecimal("440")));
        transactions.add(new Transaction(1, new Date(), "Tuna Wrap", "GBP", new BigDecimal("350")));

    }

    public BigDecimal getTotalUserBalance(int userId) {
        return transactions.stream()
                .map(t -> t.getAmount())
                .reduce(BigDecimal.ZERO, (total, amount) -> total.add(amount));
    }

    public List<Transaction> getAllUserTransactions(int userId) {
        return transactions.stream()
                .filter(t -> t.getUserId() == userId)
                .toList();
    }

}
