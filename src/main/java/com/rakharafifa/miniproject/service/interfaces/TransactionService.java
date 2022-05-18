package com.rakharafifa.miniproject.service.interfaces;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.TransactionDto;
import com.rakharafifa.miniproject.model.entity.TransactionEntity;

public interface TransactionService {
    List<TransactionEntity> getAllTransaction();
    List<TransactionDto> getAllTransactionDto();
    TransactionEntity getTransactionById(Long transaction_id);
    void createTransaction(TransactionEntity transaction);
    void updateTransaction(Long transaction_id, TransactionEntity transaction);
    void deleteTransaction(Long transaction_id);
}
