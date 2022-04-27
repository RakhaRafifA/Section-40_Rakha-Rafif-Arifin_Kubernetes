package com.rakharafifa.miniproject.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String name;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable =  false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable =  false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable =  false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable =  false)
    private Wallet wallet;
}
