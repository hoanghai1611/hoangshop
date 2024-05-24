package com.hoanghai.hoangshop.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "roles")
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private Long roleId;
    @Column(columnDefinition = "varchar(100) not null")
    private String duty ;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
