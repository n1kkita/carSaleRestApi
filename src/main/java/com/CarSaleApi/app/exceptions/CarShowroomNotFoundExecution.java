package com.CarSaleApi.app.exceptions;

public class CarShowroomNotFoundExecution extends RuntimeException {
    public CarShowroomNotFoundExecution() {
        super("CarShowroom not found");
    }
}
