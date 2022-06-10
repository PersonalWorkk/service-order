package com.wedeliver.serviceorder.rabbitmq.config.consumer;

import java.util.List;
import java.util.Set;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionMessage.ItemsBuilder;
import org.springframework.stereotype.Component;

import com.wedeliver.serviceorder.domain.Item;
import com.wedeliver.serviceorder.domain.Order;
import com.wedeliver.serviceorder.gateways.OrderDTO;
import com.wedeliver.serviceorder.rabbitmq.config.MessagingConfig;
import com.wedeliver.serviceorder.service.ItemService;
import com.wedeliver.serviceorder.service.OrderService;

@Component
public class OrderConsumer {
    // Consumes order messages from QUEUE sent by the restaurant service
    @Autowired
    OrderService orderService;
    @Autowired
    private ItemService itemService;
    
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeOrderMessageFromQueue(OrderDTO orderDTO){
        Order order = orderService.saveOrder(orderDTO);
        Set<Item> orderItems = orderDTO.getItems();
        for (Item item : orderItems) {
            item.setOrder(order);
            itemService.saveItem(item);
        }
        // itemService.saveItems(orderItems);
        // List<Item> items = itemService.saveItems(order.getItems());
        // Update items with order
        // for (Item item : items) {
        //     itemService.updateItemWithOrderId(item.getId(), order);
        // }
        if (order != null){
            System.out.println("Order has been created.");
        }
    }
}
