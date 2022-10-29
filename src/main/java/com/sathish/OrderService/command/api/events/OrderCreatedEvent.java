package com.sathish.OrderService.command.api.events;

import lombok.Data;

@Data
public class OrderCreatedEvent {
    private String orderId;
    private String productID;
    private String userId;
    private String address;
    private Integer quantity;
    private String orderStatus;
}
