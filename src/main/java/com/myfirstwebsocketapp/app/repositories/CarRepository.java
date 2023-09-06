package com.myfirstwebsocketapp.app.repositories;

import com.myfirstwebsocketapp.app.dto.CarDto;
import com.myfirstwebsocketapp.app.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository< Car,Long> {
        @Query("SELECT c FROM Car c " +
                "WHERE c.mark = ?1 " +
                "and c.model = ?2 " +
                "and c.type = ?3 " +
                "and c.price = ?4 " +
                "and c.year = ?5")
        Optional<Car> findCarByCarDto( String mark,
                                       String model,
                                       Car.Type type,
                                       Double price,
                                       Integer year
        );

        @Query("select new com.myfirstwebsocketapp.app.dto.CarDto(c.id,c.mark,c.model,c.year,c.price,c.type) from Car c where c.id=?1"
        )
        Optional< CarDto > findCarById(Long id);

        @Query("select new com.myfirstwebsocketapp.app.dto.CarDto(c.id,c.mark,c.model,c.year,c.price,c.type) from Car c ")
        List<CarDto> findAllCar();
}