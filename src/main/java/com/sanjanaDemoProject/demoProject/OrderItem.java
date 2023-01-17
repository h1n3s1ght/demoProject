package com.sanjanaDemoProject.demoProject;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NamedQuery(name="orderByID", query= "SELECT C FROM OrderItem AS C WHERE C.id = :id")
//        @NamedQuery(name="itemsListedInOrder", query= "SELECT C.name FROM Inventory AS C WHERE C.id = :id")
//        @NamedQuery(name="itemsInAnOrder", query = "SELECT C.Item_Num FROM Ordered_Items AS C WHERE C.Order_Num = :order_id")
//        SELECT * FROM INVENTORY, ORDERED_ITEMS WHERE ORDERED_ITEMS.ITEM_NUM = INVENTORY.ID AND ORDERED_ITEMS.ORDER_NUM = 60002

public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name= "date_Ordered")
    private java.sql.Date dateOrdered;

    @Column(name= "time_Ordered")
    private java.sql.Time timeOrdered;

    @Column
    private String status;

    @ManyToOne
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="Ordered_Items",
            joinColumns = @JoinColumn(name = "Order_Num"),
            inverseJoinColumns = @JoinColumn(name = "Item_Num"))
    private List<Inventory> inventoryList = new ArrayList<>();



    //== Constructors ==
    //==================

    protected OrderItem() {}

    public OrderItem(Long id, Date dateOrdered, Time timeOrdered, String status, Customer customer, List<Inventory> inventoryList) {
        this.id = id;
        this.dateOrdered = dateOrdered;
        this.timeOrdered = timeOrdered;
        this.status = status;
        this.customer = customer;
        this.inventoryList = inventoryList;
    }


    //== Getters ==
    //=============

    public Long getId() {
        return id;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public Time getTimeOrdered() {
        return timeOrdered;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }


    //== Setters ==
    //=============

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public void setTimeOrdered(Time timeOrdered) {
        this.timeOrdered = timeOrdered;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }


    //== toString Override ==
    //=======================


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", dateOrdered=" + dateOrdered +
                ", timeOrdered=" + timeOrdered +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", Item List=" + inventoryList +
                '}';
    }
}
