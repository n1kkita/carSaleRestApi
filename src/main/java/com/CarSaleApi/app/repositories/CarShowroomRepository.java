package com.CarSaleApi.app.repositories;

import com.CarSaleApi.app.entity.CarShowroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarShowroomRepository extends JpaRepository< CarShowroom,Long >, CustomRepository {
}
