package com.myfirstwebsocketapp.app.services.imp;

import com.myfirstwebsocketapp.app.dto.CarShowroomDto;
import com.myfirstwebsocketapp.app.entity.CarShowroom;
import com.myfirstwebsocketapp.app.exceptions.CarShowroomNotFoundExecution;
import com.myfirstwebsocketapp.app.repositories.CarShowroomRepository;
import com.myfirstwebsocketapp.app.services.CarShowroomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarShowroomServiceImpl implements CarShowroomService {

    private final CarShowroomRepository carShowroomRepository;

    @Override
    public CarShowroom getById(Long id) {
        return carShowroomRepository
                .findCarShowroomFetchCarsAndSellersById(id)
                .orElseThrow(CarShowroomNotFoundExecution :: new);
    }


    @Override
    public CarShowroom save(CarShowroomDto carShowroomDto) {

        return carShowroomRepository.save(
                 CarShowroom.builder()
                .name(carShowroomDto.name())
                .build()
        );
    }
}
