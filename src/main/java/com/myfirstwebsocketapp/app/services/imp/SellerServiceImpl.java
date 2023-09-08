package com.myfirstwebsocketapp.app.services.imp;

import com.myfirstwebsocketapp.app.dto.SellerDto;
import com.myfirstwebsocketapp.app.entity.Seller;
import com.myfirstwebsocketapp.app.exceptions.SellerNotFoundException;
import com.myfirstwebsocketapp.app.repositories.SellerRepository;
import com.myfirstwebsocketapp.app.services.CarShowroomService;
import com.myfirstwebsocketapp.app.services.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final CarShowroomService carShowroomService;

    @Override
    @Transactional
    public Seller save(SellerDto sellerDto) {
        return sellerRepository.save(
                 Seller
                .builder()
                .carShowroom(carShowroomService.getById(sellerDto.carShowroomId()))
                .firstName(sellerDto.firstName())
                .lastName(sellerDto.lastName())
                .age(sellerDto.age())
                .role(sellerDto.role())
                .build());
    }

    @Override
    @Transactional(readOnly = true)
    public List< Seller > getAll() {
        return sellerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Seller getById(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(SellerNotFoundException :: new);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Seller updateById(Long id, String role, Integer age) {
        Seller seller = getById(id);

        seller.setAge(age);
        seller.setRole(Seller.Role.valueOf(role));

        return seller;
    }
}
