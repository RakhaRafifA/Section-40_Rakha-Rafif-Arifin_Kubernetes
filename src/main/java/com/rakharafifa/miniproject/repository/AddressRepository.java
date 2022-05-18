package com.rakharafifa.miniproject.repository;

import com.rakharafifa.miniproject.model.entity.AddressEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    
}
