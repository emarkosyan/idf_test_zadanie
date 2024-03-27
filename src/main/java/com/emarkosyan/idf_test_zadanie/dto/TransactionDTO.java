package com.emarkosyan.idf_test_zadanie.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDTO {
    private Long id;
    private String accountFrom;
    private String accountTo;
    private String currencyShortname;
    private BigDecimal amount;
    private String expenseCategory;
    private String datetime;
    private Boolean limitExceeded;
}
