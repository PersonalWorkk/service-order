package com.wedeliver.serviceorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wedeliver.serviceorder.domain.Order;
import com.wedeliver.serviceorder.gateways.OrderDTO;
import com.wedeliver.serviceorder.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public OrderService(){}
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order saveOrder(OrderDTO orderDTO){
        Order order = orderDTO.convert2Order();
        return orderRepository.save(order);
    }
}
