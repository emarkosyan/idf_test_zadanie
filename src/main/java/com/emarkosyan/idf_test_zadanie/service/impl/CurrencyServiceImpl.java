package com.emarkosyan.idf_test_zadanie.service.impl;

import com.emarkosyan.idf_test_zadanie.model.Currency;
import com.emarkosyan.idf_test_zadanie.repository.CurrencyRepository;
import com.emarkosyan.idf_test_zadanie.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    @Override
    public Optional<Currency> getCurrencyById(Long id) {
        return currencyRepository.findById(id);
    }

    @Override
    public Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public void deleteCurrency(Long id) {
        currencyRepository.deleteById(id);
    }
}
