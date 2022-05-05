package com.rakharafifa.miniproject.model.entity;

import java.time.Instant;

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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;
    private Long total_price;
    private Long quantity;
    private Instant created_at;
    private Instant updated_at;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable =  false)
    private Product product;
}
