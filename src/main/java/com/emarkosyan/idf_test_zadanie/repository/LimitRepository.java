package com.emarkosyan.idf_test_zadanie.repository;

import com.emarkosyan.idf_test_zadanie.model.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface LimitRepository extends JpaRepository<Limit, Long> {
    Limit findByCategoryAndSetDate(String category, LocalDate setDate);

    Optional<Limit> findMonthlyLimitByCategory(String category);
}
