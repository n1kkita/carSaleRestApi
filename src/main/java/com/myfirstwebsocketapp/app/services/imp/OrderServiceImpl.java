package com.myfirstwebsocketapp.app.services.imp;

import com.myfirstwebsocketapp.app.entity.Car;
import com.myfirstwebsocketapp.app.entity.Orders;
import com.myfirstwebsocketapp.app.entity.Seller;
import com.myfirstwebsocketapp.app.repositories.CarRepository;
import com.myfirstwebsocketapp.app.repositories.OrdersRepository;
import com.myfirstwebsocketapp.app.services.CarService;
import com.myfirstwebsocketapp.app.services.OrderService;
import com.myfirstwebsocketapp.app.services.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final SellerService sellerService;
    private final CarService carService;
    private final CarRepository carRepository;
    private final OrdersRepository ordersRepository;

    @Override
    @Transactional(readOnly = true)
    public Orders getById(Long id) {
        return ordersRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Orders carSaleByIdAndSellerId(Long carId, Long sellerId) {
        Car saleCar = carRepository.findById(carId).orElseThrow();
        Seller seller = sellerService.getById(sellerId);

        carService.deleteById(saleCar.getId());

        return ordersRepository.save(seller.saleCar(saleCar));
    }
}
