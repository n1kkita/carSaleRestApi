package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.CarShowroomDto;
import com.CarSaleApi.app.entity.CarShowroom;

public interface CarShowroomService {
    CarShowroom getById(Long id);
    CarShowroom save(CarShowroomDto carShowroomDto);
}
