package com.myfirstwebsocketapp.app.repositories;

import com.myfirstwebsocketapp.app.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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


}
