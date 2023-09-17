package com.CarSaleApi.app.services.imp;

import com.CarSaleApi.app.components.Calculator;
import com.CarSaleApi.app.entity.Car;
import com.CarSaleApi.app.entity.Orders;
import com.CarSaleApi.app.entity.Revenue;
import com.CarSaleApi.app.entity.Seller;
import com.CarSaleApi.app.exceptions.CarNotFoundException;
import com.CarSaleApi.app.exceptions.OrderNotFoundException;
import com.CarSaleApi.app.exceptions.SellerNotFoundException;
import com.CarSaleApi.app.repositories.CarRepository;
import com.CarSaleApi.app.repositories.OrdersRepository;
import com.CarSaleApi.app.repositories.RevenueRepository;
import com.CarSaleApi.app.repositories.SellerRepository;
import com.CarSaleApi.app.services.CarService;
import com.CarSaleApi.app.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final SellerRepository sellerRepository;
    private final CarService carService;
    private final CarRepository carRepository;
    private final OrdersRepository ordersRepository;
    private final RevenueRepository revenueRepository;
    private final Calculator<Seller> calculator;
    @Override
    @Transactional(readOnly = true)
    public List< Orders > getAll() {
        return ordersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Orders getById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(OrderNotFoundException ::new);
    }

    @Override
    @Transactional
    public Orders carSaleByIdAndSellerId(Long carId, Long sellerId) {
        Car saleCar = carRepository.findById(carId).orElseThrow(CarNotFoundException ::new);
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(SellerNotFoundException ::new);


        carService.deleteById(saleCar.getId());
        //if we have revenue for the current date -> just added new revenue to the current one, else create new revenue to new date
        revenueRepository.findByRevenueDate(LocalDate.now())
                .ifPresentOrElse(
                        revenue -> revenue.setAmountOfRevenue(revenue.getAmountOfRevenue() + saleCar.getPrice().intValue()),

                        () -> revenueRepository.save(
                                 Revenue.builder()
                                .amountOfRevenue(saleCar.getPrice().intValue())
                                .revenueDate(LocalDate.now())
                                .build()
                        )
                );

        log.info("car " + saleCar + " sold");
        //saved the order in the db and calculating bonuses for the seller from sales
        Orders order = ordersRepository.save(seller.saleCar(saleCar));
        seller.setSalesBonusesForCurrentMonth(calculator.calculate(seller));

        return order;
    }
}
