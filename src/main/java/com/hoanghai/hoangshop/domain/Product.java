package com.hoanghai.hoangshop.domain;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import org.hibernate.annotations.DialectOverride;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId ;
    @Column(columnDefinition = "varchar(100) not null")
    private String name ;
    @Column(columnDefinition = "varchar(100) not null")
    private String description ;
    @Column(columnDefinition = "varchar(100) not null")
    private String price ;
    @Column(columnDefinition = "varchar(100) not null")
    private String discount ;
    @Column(columnDefinition = "varchar(100) not null")
    private String stock ;
 @ManyToOne
 @JoinColumn(name = "categoryId")
 private Category category;

 @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
 private List<OrderDetail> orderDetails;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
