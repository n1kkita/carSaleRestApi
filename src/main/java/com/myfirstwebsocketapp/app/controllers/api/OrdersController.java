package com.myfirstwebsocketapp.app.controllers.api;

import com.myfirstwebsocketapp.app.entity.Orders;
import com.myfirstwebsocketapp.app.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;
    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id){
        return orderService.getById(id);
    }
    @PostMapping("/saleCar/{carId}/{sellerId}")
    public Orders saleCar(@PathVariable Long carId, @PathVariable Long sellerId){
        return orderService.carSaleByIdAndSellerId(carId,sellerId);
    }


}
