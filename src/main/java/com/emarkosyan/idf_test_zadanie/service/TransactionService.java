package com.emarkosyan.idf_test_zadanie.service;

import com.emarkosyan.idf_test_zadanie.model.Limit;
import com.emarkosyan.idf_test_zadanie.model.Transaction;
import com.emarkosyan.idf_test_zadanie.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final LimitService limitService;

    private List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    private void checkLimitExceeded(Transaction transaction) {
        Limit limit = limitService.getLimitByCategoryAndDate(transaction.getExpenseCategory(), LocalDate.now());
        if (limit != null) {
            BigDecimal totalAmountForCategory = transactionRepository.sumAmountByCategoryAndDate(
                    transaction.getExpenseCategory(),
                    LocalDate.now().withDayOfMonth(1),
                    LocalDate.now().plusMonths(1).withDayOfMonth(1));
            if (totalAmountForCategory != null && totalAmountForCategory.add(transaction.getAmount()).compareTo(limitService.getMonthlyLimitForCategory(transaction.getExpenseCategory())) > 0) {
                transaction.setLimitExceeded(true);
            }
        }
    }
}
