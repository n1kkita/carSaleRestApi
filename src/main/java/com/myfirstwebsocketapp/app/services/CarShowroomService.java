package com.myfirstwebsocketapp.app.services;

import com.myfirstwebsocketapp.app.dto.CarShowroomDto;
import com.myfirstwebsocketapp.app.entity.CarShowroom;

public interface CarShowroomService {
    CarShowroom getById(Long id);
    CarShowroom save(CarShowroomDto carShowroomDto);
}
