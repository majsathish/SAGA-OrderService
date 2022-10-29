package com.sathish.OrderService.command.api.saga;

import com.sathish.OrderService.command.api.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

@Saga
@Slf4j
public class OrderProcessingSaga {

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId" )
    private  void  handle (OrderCreatedEvent orderCreatedEvent)
    {
        log.info("Order Created Event for OrderID: "+orderCreatedEvent.getOrderId());



    }
}
