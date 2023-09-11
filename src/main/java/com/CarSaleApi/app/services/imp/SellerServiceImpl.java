package com.CarSaleApi.app.services.imp;

import com.CarSaleApi.app.dto.SellerDto;
import com.CarSaleApi.app.entity.Seller;
import com.CarSaleApi.app.exceptions.SellerNotFoundException;
import com.CarSaleApi.app.repositories.SellerRepository;
import com.CarSaleApi.app.services.CarShowroomService;
import com.CarSaleApi.app.services.SellerService;
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
        return sellerRepository.save(SellerDto.replaceToSellerBySellerDto(
                sellerDto,
                carShowroomService.getById(sellerDto.carShowroomDto().id()))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List< SellerDto > getAll() {
        return sellerRepository.findAll()
                .stream()
                .map(SellerDto :: replaceToDtoBySeller)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SellerDto getById(Long id) {
        return sellerRepository.findById(id)
                .map(SellerDto::replaceToDtoBySeller)
                .orElseThrow(SellerNotFoundException :: new);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public SellerDto updateById(Long id, String role, Integer age) {

         Seller updateSeller = sellerRepository.findById(id)
                .map(seller -> {
                    seller.setAge(age);
                    seller.setRole(Seller.Role.valueOf(role));
                    return seller;

                }).orElseThrow(SellerNotFoundException::new);

         return SellerDto.replaceToDtoBySeller(updateSeller);
    }
}
