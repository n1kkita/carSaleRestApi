package com.CarSaleApi.app.exceptions;

public class SellerDoesNotHaveAccessForCarshowroom extends RuntimeException{
    public SellerDoesNotHaveAccessForCarshowroom() {
        super("This user does not have access to this store");
    }
}
