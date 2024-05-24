//package com.hoanghai.hoangshop.domain;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//@Entity
//@Table(name = "suppliers")
//public class Suppliers implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "suppliers_id")
//    private Long suppliersId ;
//    @Column(columnDefinition = "varchar(100) not null")
//    private String name ;
//    @Column(columnDefinition = "varchar(100) not null")
//    private String email ;
//    @Column(columnDefinition = "varchar(100) not null")
//    private String address ;
//    @Column(columnDefinition = "varchar(100) not null")
//    private String phoneNumber ;
//
//    public Long getSuppliersId() {
//        return suppliersId;
//    }
//
//    public void setSuppliersId(Long suppliersId) {
//        this.suppliersId = suppliersId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//}
