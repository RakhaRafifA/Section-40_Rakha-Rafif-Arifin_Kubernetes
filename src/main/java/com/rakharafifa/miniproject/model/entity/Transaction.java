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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;
    private Long price;
    private Long total_price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable =  false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable =  false)
    private User user;
}
