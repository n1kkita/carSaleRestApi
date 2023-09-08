package com.myfirstwebsocketapp.app.dto;

import com.myfirstwebsocketapp.app.entity.Seller;

public record SellerDto
        (
                Long id,
                Integer age,
                String firstName,
                String lastName,
                Seller.Role role,
                Long carShowroomId

        )
{
}
