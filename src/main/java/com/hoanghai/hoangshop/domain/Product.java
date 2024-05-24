package com.hoanghai.hoangshop.domain;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.hibernate.annotations.DialectOverride;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(columnDefinition = "varchar(100) not null")
    private String name ;
    @Column(nullable = false)
    private String quantity ;
    @Column(nullable = false)
    private String newPrice ;
    @Column(nullable = false)
    private String oldPrice ;
  @Column(length = 200)
  private String image;
    @Column(columnDefinition = "varchar(100) not null")
    private String description ;
    @Column(columnDefinition = "varchar(100) not null")
    private String note ;
    @Column(nullable = false)
    private String discount ;


 @ManyToOne
 @JoinColumn(name = "categoryId")
 private Category category;

 @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
 private List<OrderDetail> orderDetails;


}
