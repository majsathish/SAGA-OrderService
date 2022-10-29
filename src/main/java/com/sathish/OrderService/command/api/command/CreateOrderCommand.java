package com.sathish.OrderService.command.api.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
    private String productID;
    private String userId;
    private String address;
    private Integer quantity;
    private String orderStatus;
}
