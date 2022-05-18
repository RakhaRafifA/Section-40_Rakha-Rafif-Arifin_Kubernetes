package com.rakharafifa.miniproject.repository;

import com.rakharafifa.miniproject.model.entity.WalletEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
    
}
