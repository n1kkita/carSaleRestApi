package com.CarSaleApi.app.dto;

import com.CarSaleApi.app.entity.CarShowroom;
import com.CarSaleApi.app.entity.Seller;

import java.util.List;

public record SellerDto
        (
                Long id,
                Integer age,
                String firstName,
                String lastName,
                Integer numberOfCarsSold,
                Seller.Role role,
                CarShowroomDto carShowroomDto,
                List<OrderDto> sales

        )
{
        public static SellerDto replaceToDtoBySeller(Seller seller) {
                return new SellerDto(
                        seller.getId(),
                        seller.getAge(),
                        seller.getFirstName(),
                        seller.getLastName(),
                        seller.getNumberOfCarsSold(),
                        seller.getRole(),
                        new CarShowroomDto(seller.getCarShowroom().getId(), seller.getCarShowroom().getName()),
                        seller.getSales()
                                .stream()
                                .map(order -> new OrderDto(
                                        order.getId(),
                                        order.getDateOfSale(),
                                        CarDto.replaceToDtoByCar(order.getCar()))
                                ).toList()
                );
        }

        public static Seller replaceToSellerBySellerDto(SellerDto sellerDto, CarShowroom carShowroom){
           return Seller
                   .builder()
                   .carShowroom(carShowroom)
                   .firstName(sellerDto.firstName())
                   .lastName(sellerDto.lastName())
                   .age(sellerDto.age())
                   .role(sellerDto.role())
                   .build();
        }
}


