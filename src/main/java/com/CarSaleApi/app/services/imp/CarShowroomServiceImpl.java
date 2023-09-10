package com.CarSaleApi.app.services.imp;

import com.CarSaleApi.app.dto.CarShowroomDto;
import com.CarSaleApi.app.entity.CarShowroom;
import com.CarSaleApi.app.exceptions.CarShowroomNotFoundExecution;
import com.CarSaleApi.app.repositories.CarShowroomRepository;
import com.CarSaleApi.app.services.CarShowroomService;
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
