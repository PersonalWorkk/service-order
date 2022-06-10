package com.wedeliver.serviceorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wedeliver.serviceorder.domain.Item;
import com.wedeliver.serviceorder.domain.Order;
import com.wedeliver.serviceorder.payroll.ItemNotFoundException;
import com.wedeliver.serviceorder.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public ItemService(){}
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    @Transactional
    public void updateItemWithOrderId(Long id, Order order){
        Item item = itemRepository.findById(id)
            .orElseThrow(() -> new ItemNotFoundException(id));
        item.setOrder(order);
        itemRepository.save(item);
    }
}
