package com.wedeliver.serviceorder.repository;

import org.springframework.stereotype.Repository;

import com.wedeliver.serviceorder.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
