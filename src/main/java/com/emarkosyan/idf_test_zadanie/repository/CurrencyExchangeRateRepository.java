package com.emarkosyan.idf_test_zadanie.repository;

import com.emarkosyan.idf_test_zadanie.model.CurrencyExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyExchangeRateRepository extends JpaRepository<CurrencyExchangeRate, Long> {
    Optional<CurrencyExchangeRate> findByCurrencyPairAndExchangeDate(String fromCurrency, String toCurrency, LocalDate exchangeDate);
    List<CurrencyExchangeRate> findByExchangeDate(LocalDate date);

    List<CurrencyExchangeRate> findFirstByOrderByExchangeDateDesc();

    List<CurrencyExchangeRate> findByExchangeDateBetween(LocalDate startDate, LocalDate endDate);

    List<CurrencyExchangeRate> findByBaseCurrencyOrTargetCurrency(String currency, String currency1);

    CurrencyExchangeRate findFirstByBaseCurrencyAndTargetCurrencyOrderByExchangeDateDesc(String baseCurrency, String targetCurrency);
}
