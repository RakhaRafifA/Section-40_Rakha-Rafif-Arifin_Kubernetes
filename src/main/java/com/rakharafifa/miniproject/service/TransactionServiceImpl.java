package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto.ProductDto;
import com.rakharafifa.miniproject.model.dto.TransactionDto;
import com.rakharafifa.miniproject.model.dto.UserDto;
import com.rakharafifa.miniproject.model.entity.Product;
import com.rakharafifa.miniproject.model.entity.Transaction;
import com.rakharafifa.miniproject.model.entity.User;
import com.rakharafifa.miniproject.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransaction() {
        List<Transaction> transactions = new ArrayList<>();
        transactionRepository.findAll().forEach(transactions::add);
        return transactions;
    }

    @Override
    public List<TransactionDto> getAllTransactionDto() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for(Transaction transaction : transactions){
            TransactionDto transactionDto = new TransactionDto();
            UserDto userDto = new UserDto();
            ProductDto productDto = new ProductDto();

            transactionDto.setTransaction_id(transaction.getTransaction_id());
            transactionDto.setPrice(transaction.getPrice());
            transactionDto.setTotal_price(transaction.getTotal_price());
            transactionDto.setProduct_id(transaction.getProduct().getProduct_id());
            transactionDto.setUser_id(transaction.getUser().getUser_id());

            userDto.setUser_id(transaction.getUser().getUser_id());
            userDto.setName(transaction.getUser().getName());
            userDto.setUsername(transaction.getUser().getUsername());

            productDto.setProduct_id(transaction.getProduct().getProduct_id());
            productDto.setName(transaction.getProduct().getName());
            productDto.setPrice(transaction.getPrice());
            
            transactionDtos.add(transactionDto);
        }
        return transactionDtos;
    }

    @Override
    public Transaction getTransactionById(Long transaction_id) {
        return transactionRepository.findById(transaction_id).get();
    }

    @Override
    public void createTransactionDto(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        Product product = new Product();
        User user = new User();
        
        product.setProduct_id(transactionDto.getProduct_id());
        user.setUser_id(transactionDto.getUser_id());
        transaction.setTransaction_id(transactionDto.getTransaction_id());
        transaction.setPrice(transactionDto.getPrice());
        transaction.setTotal_price(transactionDto.getTotal_price());

        transactionRepository.save(transaction);
    }

    @Override
    public void updateTransaction(Long transaction_id, Transaction transaction) {
        Transaction transaction2 = transactionRepository.findById(transaction_id).get();
        System.out.println(transaction2.toString());
        transaction2.setPrice(transaction.getPrice());
        transaction2.setTotal_price(transaction.getTotal_price());
        transactionRepository.save(transaction2);
    }

    @Override
    public void deleteTransaction(Long transaction_id) {
        transactionRepository.deleteById(transaction_id);
        
    }
}
