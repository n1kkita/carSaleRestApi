package com.CarSaleApi.app.config;

import com.CarSaleApi.app.dto.CarDto;
import com.CarSaleApi.app.dto.CarShowroomDto;
import com.CarSaleApi.app.dto.SellerDto;
import com.CarSaleApi.app.entity.Car;
import com.CarSaleApi.app.entity.CarShowroom;
import com.CarSaleApi.app.entity.Revenue;
import com.CarSaleApi.app.entity.Seller;
import com.CarSaleApi.app.repositories.RevenueRepository;
import com.CarSaleApi.app.services.CarService;
import com.CarSaleApi.app.services.CarShowroomService;
import com.CarSaleApi.app.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@ComponentScan("com.CarSaleApi.app")
public class ConfigTestBean {

    @Autowired
    private CarService carService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private CarShowroomService carShowroomService;
    @Autowired
    private RevenueRepository revenueRepository;

    @Bean(value = "carShowroomTestBean")
    public CarShowroom getCarShowroomTestBean(){
        return carShowroomService.save(new CarShowroomDto(
                null,
                "Test"
        ));
    }
    @Bean
    public List< Revenue > getTestRevenuesBeans(){
        return revenueRepository.saveAll(List.of(
                new Revenue(null,15000, LocalDate.of(2023,11,25)),
                new Revenue(null,10000,LocalDate.of(2023,11,26)),
                new Revenue(null,10000,LocalDate.of(2023,11,27)),
                new Revenue(null,10000,LocalDate.of(2023,11,28)),
                new Revenue(null,10000,LocalDate.of(2023,11,29)),
                new Revenue(null,23000,LocalDate.of(2023,11,30)),
                new Revenue(null,10000,LocalDate.of(2023,12,31)),
                new Revenue(null,70000,LocalDate.of(2024,1,1)),
                new Revenue(null,100000,LocalDate.of(2024,1,2)),
                new Revenue(null,12000,LocalDate.of(2024,1,3))
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
