package com.emarkosyan.idf_test_zadanie.service;

import com.emarkosyan.idf_test_zadanie.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransactionById(Long id);
    Transaction saveTransaction(Transaction transaction);
    void deleteTransaction(Long id);
}
