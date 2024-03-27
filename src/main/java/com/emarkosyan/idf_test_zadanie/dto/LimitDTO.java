package com.emarkosyan.idf_test_zadanie.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LimitDTO {
    private Long id;
    private String category;
    private BigDecimal amount;
    private String currency;
    private String limitDatetime;
}
