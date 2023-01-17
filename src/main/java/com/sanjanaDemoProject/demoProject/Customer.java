package com.sanjanaDemoProject.demoProject;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Customer {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_seq")
    @Id
    private Long id;

    @Column
    private String email;

    @Column
    private String fullName;

    @Column
    private String phone;

    @OneToMany
    private List<OrderItem> orders = new ArrayList<>();


    //== Constructors ==
    //==================

    protected Customer() {}

    public Customer(String email, String fullName, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
    }

    //== Getters ==
    //=============

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }


    //== Setters ==
    //=============

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    //== toString Override ==
    //=======================


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + fullName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
