package com.emarkosyan.idf_test_zadanie.service;

import com.emarkosyan.idf_test_zadanie.model.Limit;
import com.emarkosyan.idf_test_zadanie.repository.LimitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LimitService {

    private final LimitRepository limitRepository;

    public List<Limit> getAllLimits() {
        return limitRepository.findAll();
    }

    public BigDecimal getMonthlyLimitForCategory(String category) {
        Optional<Limit> limitOptional = limitRepository.findMonthlyLimitByCategory(category);
        return limitOptional.map(limit -> new BigDecimal(String.valueOf(limit.getLimitAmount()))).orElse(BigDecimal.ZERO);
    }

    public Limit getLimitByCategoryAndDate(String category, LocalDate date) {
        return limitRepository.findByCategoryAndSetDate(category, date);
    }

    public Limit setNewLimit(Limit limit) {
        if(limitRepository.findByCategoryAndSetDate(limit.getCategory(), LocalDate.now()) != null) {
            throw new RuntimeException("Limit for this category already exists for the current date.");
        }
        limit.setSetDate(LocalDateTime.from(LocalDate.now()));
        return limitRepository.save(limit);
    }
}
