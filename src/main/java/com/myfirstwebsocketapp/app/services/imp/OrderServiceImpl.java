package com.myfirstwebsocketapp.app.services.imp;

import com.myfirstwebsocketapp.app.entity.Car;
import com.myfirstwebsocketapp.app.entity.Orders;
import com.myfirstwebsocketapp.app.entity.Seller;
import com.myfirstwebsocketapp.app.exceptions.CarNotFoundException;
import com.myfirstwebsocketapp.app.exceptions.SellerNotFoundException;
import com.myfirstwebsocketapp.app.repositories.CarRepository;
import com.myfirstwebsocketapp.app.repositories.OrdersRepository;
import com.myfirstwebsocketapp.app.repositories.SellerRepository;
import com.myfirstwebsocketapp.app.services.CarService;
import com.myfirstwebsocketapp.app.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final SellerRepository sellerRepository;
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
        Car saleCar = carRepository.findById(carId).orElseThrow(CarNotFoundException ::new);
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(SellerNotFoundException ::new);

        carService.deleteById(saleCar.getId());
        log.info("car " + saleCar + " sold");
        return ordersRepository.save(seller.saleCar(saleCar));
    }
}
