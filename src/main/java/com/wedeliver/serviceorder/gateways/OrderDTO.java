package com.wedeliver.serviceorder.gateways;

import java.util.List;
import java.util.Set;

import com.wedeliver.serviceorder.domain.Item;
import com.wedeliver.serviceorder.domain.Order;

public class OrderDTO {
    private String clientFirstName;
    private String clientLastName;
    private String deliveryAddress;
    private Float totalPrice;
    private Set<Item> items;

    public OrderDTO(){}
    public OrderDTO(String clientFirstName, String clientLastName, String deliveryAddress, Float totalPrice, Set<Item> items){
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
        this.totalPrice = totalPrice;
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
    public Float getTotalPrice() {
        return totalPrice;
    }
    public Set<Item> getItems() {
        return items;
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
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order convert2Order(){
        return new Order(this.clientFirstName, this.clientLastName, this.totalPrice, this.deliveryAddress, this.items);
    }
}
