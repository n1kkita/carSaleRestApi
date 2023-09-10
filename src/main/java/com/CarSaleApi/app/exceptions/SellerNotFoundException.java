package com.CarSaleApi.app.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class SellerNotFoundException extends EntityNotFoundException {
    public SellerNotFoundException() {
        super("Seller not found");
    }
}
