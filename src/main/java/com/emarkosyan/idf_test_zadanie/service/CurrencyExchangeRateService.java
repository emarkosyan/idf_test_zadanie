package com.emarkosyan.idf_test_zadanie.service;

import com.emarkosyan.idf_test_zadanie.model.CurrencyExchangeRate;
import com.emarkosyan.idf_test_zadanie.repository.CurrencyExchangeRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrencyExchangeRateService {

    private final CurrencyExchangeRateRepository currencyExchangeRateRepository;

    public BigDecimal getExchangeRate(String baseCurrency, String targetCurrency, LocalDate date) {
        Optional<CurrencyExchangeRate> exchangeRateOptional = currencyExchangeRateRepository.findByCurrencyPairAndExchangeDate(baseCurrency, targetCurrency, date);
        return exchangeRateOptional.map(CurrencyExchangeRate::getExchangeRate).orElse(BigDecimal.ONE); // If rate is not found, assume rate is 1:1
    }

    public void saveExchangeRate(CurrencyExchangeRate exchangeRate) {
        currencyExchangeRateRepository.save(exchangeRate);
    }

    public List<CurrencyExchangeRate> getExchangeRatesForDate(LocalDate date) {
        return currencyExchangeRateRepository.findByExchangeDate(date);
    }

    public List<CurrencyExchangeRate> getLatestExchangeRates() {
        return currencyExchangeRateRepository.findFirstByOrderByExchangeDateDesc();
    }

    public List<CurrencyExchangeRate> getExchangeRatesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return currencyExchangeRateRepository.findByExchangeDateBetween(startDate, endDate);
    }

    public List<CurrencyExchangeRate> getExchangeRatesForCurrency(String currency) {
        return currencyExchangeRateRepository.findByBaseCurrencyOrTargetCurrency(currency, currency);
    }

    public CurrencyExchangeRate getLatestExchangeRate(String baseCurrency, String targetCurrency) {
        return currencyExchangeRateRepository.findFirstByBaseCurrencyAndTargetCurrencyOrderByExchangeDateDesc(baseCurrency, targetCurrency);
    }
}
