package com.myfirstwebsocketapp.app.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class CarNotFoundException extends EntityNotFoundException {
    public CarNotFoundException(String message) {
        super(message);
    }
}
