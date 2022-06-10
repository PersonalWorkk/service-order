package com.wedeliver.serviceorder.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Float price;
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    public Item(){}
    public Item(String name, Float price, Order order){
        this.name = name;
        this.price = price;
        this.order = order;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Long getOrderId() {
        return order.getId();
    }
    public Float getPrice() {
        return price;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

}
