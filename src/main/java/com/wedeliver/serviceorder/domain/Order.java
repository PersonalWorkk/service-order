package com.wedeliver.serviceorder.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String clientFirstName;
    private String clientLastName;
    private Float totalPrice;
    private String deliveryAddress;
    @OneToMany(mappedBy = "order")
    private Set<Item> items;

    public Order(){}
    public Order(String clientFirstName, String clientLastName, Float totalPrice, String deliveryAddress, Set<Item> items){
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }
    public String getClientFirstName() {
        return clientFirstName;
    }
    public String getClientLastName() {
        return clientLastName;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public Set<Item> getItems() {
        return items;
    }
    public Float getTotalPrice() {
        return totalPrice;
    }
    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }
    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
