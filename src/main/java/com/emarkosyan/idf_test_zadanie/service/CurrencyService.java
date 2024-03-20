package com.emarkosyan.idf_test_zadanie.service;

import com.emarkosyan.idf_test_zadanie.model.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {
    List<Currency> getAllCurrencies();
    Optional<Currency> getCurrencyById(Long id);
    Currency saveCurrency(Currency currency);
    void deleteCurrency(Long id);
}
