package com.hoanghai.hoangshop.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String firstName;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String lastName;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String email;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String address;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String phoneNumber;
    @Column(columnDefinition = "nvarchar(30) not null")
    private String birthday;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Roles role;

    @OneToOne
    @JoinColumn(name = "accountId" )
    private Account account;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}


