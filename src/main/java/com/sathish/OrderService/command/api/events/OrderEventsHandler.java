package com.sathish.OrderService.command.api.events;

import com.sathish.OrderService.command.api.data.Order;
import com.sathish.OrderService.command.api.data.OrderRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsHandler {

    private OrderRepository orderRepository;

    public OrderEventsHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @EventHandler
    public void on ( OrderCreatedEvent orderCreatedEvent)
    {
        Order order = new Order();
        BeanUtils.copyProperties(orderCreatedEvent, order);
        orderRepository.save(order);
    }
}
