package com.emarkosyan.idf_test_zadanie.repository;

import com.emarkosyan.idf_test_zadanie.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select sum (t.amount) from Transaction t where t.expenseCategory = ?1 and t.datetime >= ?2 and t.datetime < ?3")
    BigDecimal sumAmountByCategoryAndDate(String category, LocalDate startDate, LocalDate endDate);
}
