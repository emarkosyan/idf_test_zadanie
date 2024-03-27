package com.emarkosyan.idf_test_zadanie.controller;

import com.emarkosyan.idf_test_zadanie.dto.TransactionDTO;
import com.emarkosyan.idf_test_zadanie.model.Transaction;
import com.emarkosyan.idf_test_zadanie.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

//    @PostMapping("/transactions")
//    public ResponseEntity<String> createTransaction(@RequestBody TransactionDTO transactionDTO) {
//        Transaction transaction = transactionService.saveTransaction(transactionDTO);
//    }

}
