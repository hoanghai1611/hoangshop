package com.hoanghai.hoangshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "orderdetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    private  int quantity;
    @Column( nullable = false, name = "unti_price")
    private double untilPrice;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;




}
