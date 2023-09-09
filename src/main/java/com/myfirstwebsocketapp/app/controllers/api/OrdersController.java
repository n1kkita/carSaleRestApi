package com.myfirstwebsocketapp.app.controllers.api;

import com.myfirstwebsocketapp.app.entity.Orders;
import com.myfirstwebsocketapp.app.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;
    @GetMapping
    public List<Orders> getAllOrders(){
        return orderService.getAll();
    }
    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id){
        return orderService.getById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/saleCar/{carId}/{sellerId}")
    public Orders saleCar(@PathVariable Long carId, @PathVariable Long sellerId){
        return orderService.carSaleByIdAndSellerId(carId,sellerId);
    }
}
