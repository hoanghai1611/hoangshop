package com.hoanghai.hoangshop.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId ;
    @Column(columnDefinition = "nvarchar(50) not null")
    private  String userName;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String password ;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
