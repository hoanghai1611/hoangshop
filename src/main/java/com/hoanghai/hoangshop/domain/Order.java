package com.hoanghai.hoangshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date", nullable = false)
    private Date orderDate;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String phone ;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String shippedDate ;
    @Column(columnDefinition = "nvarchar(250) not null")
    private String shippingAddress ;
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String paymentType ;
    @Column(nullable = false)
    private double totalPrice;
    @Column(nullable = false, name = "status_checkout")
    private boolean status_checkout ;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String description;
    @Column(nullable = false)
    private short status;


    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

}





