package com.sathish.OrderService.command.api.aggregate;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sathish.OrderService.command.api.command.CreateOrderCommand;
import com.sathish.OrderService.command.api.events.OrderCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;

@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private String productID;
    private String userId;
    private String address;
    private Integer quantity;
    private String orderStatus;

    public OrderAggregate()
    {

    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand)
    {
        //Validate the Command
        OrderCreatedEvent orderCreatedEvent =
                new OrderCreatedEvent();

        BeanUtils.copyProperties(createOrderCommand,orderCreatedEvent);

        AggregateLifecycle.apply(orderCreatedEvent);
    }

    @EventSourcingHandler
    public void on ( OrderCreatedEvent orderCreatedEvent)
    {
        this.address = orderCreatedEvent.getAddress();
        this.orderId = orderCreatedEvent.getOrderId();
        this.orderStatus = orderCreatedEvent.getOrderStatus();
        this.productID = orderCreatedEvent.getProductID();
        this.quantity = orderCreatedEvent.getQuantity();
        this.userId = orderCreatedEvent.getOrderId();
    }

}
