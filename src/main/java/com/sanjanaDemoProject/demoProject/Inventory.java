package com.sanjanaDemoProject.demoProject;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NamedQuery(name="findItemById", query="SELECT C FROM Inventory AS C WHERE C.id = :id")

public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name= "price")
    private BigDecimal price;

    @Column
    private Integer quantity;

    @ManyToMany(mappedBy = "inventoryList")
    private List<OrderItem> orders = new ArrayList<>();

    //== Constructors ==
    //==================

    protected Inventory() {};

    public Inventory(Long id, String name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //== Getters ==
    //=============

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }


    //== Setters ==
    //=============

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }


    //== toString Override ==
    //=======================


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
