package com.emarkosyan.idf_test_zadanie.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")
    private Long id;

    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @OneToMany(mappedBy = "currency")
    private List<Transaction> transactions;
}
