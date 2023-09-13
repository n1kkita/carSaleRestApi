package com.CarSaleApi.app.config;

import com.CarSaleApi.app.dto.CarDto;
import com.CarSaleApi.app.dto.CarShowroomDto;
import com.CarSaleApi.app.dto.SellerDto;
import com.CarSaleApi.app.entity.Car;
import com.CarSaleApi.app.entity.CarShowroom;
import com.CarSaleApi.app.entity.Seller;
import com.CarSaleApi.app.services.CarService;
import com.CarSaleApi.app.services.CarShowroomService;
import com.CarSaleApi.app.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.CarSaleApi.app")
public class ConfigTestBean {

    @Autowired
    private CarService carService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private CarShowroomService carShowroomService;
    @Bean(value = "carShowroomTestBean")
    public CarShowroom getCarShowroomTestBean(){
        return carShowroomService.save(new CarShowroomDto(
                null,
                "Test"
        ));
    }

    @Bean
    public CarDto getCarDtoTestBean(){
        return new CarDto(
                null,
                1,
                "TestCar",
                "TestCar",
                2000,
                1200.0,
                Car.Type.PASSENGER_CAR,
                new CarShowroomDto(getCarShowroomTestBean().getId(),getCarShowroomTestBean().getName())
                );
    }
    @Bean
    public SellerDto getSellerDtoTestBean(){
        return new SellerDto(
                null,
                1,
                "TestSeller",
                "TestSeller",
                0,
                Seller.Role.SELLER,
                new CarShowroomDto(getCarShowroomTestBean().getId(),getCarShowroomTestBean().getName()),
                null
        );
    }
    @Bean(value = "carTestBean")
    public Car getCarTestBean(){
        return carService.save(getCarDtoTestBean());
    }

    @Bean(value = "sellerTestBean")
    public Seller getSellerTestBean(){
        return sellerService.save(getSellerDtoTestBean());
    }
}
