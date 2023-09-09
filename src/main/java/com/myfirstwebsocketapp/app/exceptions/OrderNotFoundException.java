package com.myfirstwebsocketapp.app.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException() {
        super("Order not found");
    }
}
