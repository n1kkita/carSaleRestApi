package com.myfirstwebsocketapp.app.exceptions;

public class MachinesOutOfStockException extends RuntimeException {
    public MachinesOutOfStockException() {
        super("Machines Out Of Stock");
    }
}


