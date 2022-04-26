package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.entity.Transaction;

public interface TransactionService {
    List<Transaction> getAllTransaction();
    Transaction getTransactionById(Long transaction_id);
    Transaction createTransaction(Transaction transaction);
    void updateTransaction(Long transaction_id, Transaction transaction);
    void deleteTransaction(Long transaction_id);
}
