package com.rakharafifa.miniproject.controller;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.TransactionDto;
import com.rakharafifa.miniproject.model.entity.TransactionEntity;
import com.rakharafifa.miniproject.service.interfaces.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miniproject/transaction")
public class TransactionController {
    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionEntity>> getAllTransaction(){
        List<TransactionEntity> transactions = transactionService.getAllTransaction();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<TransactionDto>> getAllTransactionDto(){
        List<TransactionDto> transactionDtos = transactionService.getAllTransactionDto();
        return new ResponseEntity<>(transactionDtos, HttpStatus.OK);
    }

    @GetMapping("/{transaction_id}")
    public ResponseEntity<TransactionEntity> getTransactionById(@PathVariable("transaction_id") Long transaction_id){
        return new ResponseEntity<>(transactionService.getTransactionById(transaction_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionEntity transaction){
        transactionService.createTransaction(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PutMapping("/{transaction_id}")
    public ResponseEntity<TransactionEntity> updateTransaction(@PathVariable("transaction_id") Long transaction_id, @RequestBody TransactionEntity transaction){
        transactionService.updateTransaction(transaction_id, transaction);
        return new ResponseEntity<>(transactionService.getTransactionById(transaction_id), HttpStatus.OK);
    }

    @DeleteMapping("/{transaction_id}")
    public ResponseEntity<TransactionEntity> deleteTransaction(@PathVariable("transaction_id") Long transaction_id){
        transactionService.deleteTransaction(transaction_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
