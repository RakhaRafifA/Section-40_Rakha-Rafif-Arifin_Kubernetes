package com.rakharafifa.miniproject.repository;

import com.rakharafifa.miniproject.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getDistinctTopByUsername(String username);
}
