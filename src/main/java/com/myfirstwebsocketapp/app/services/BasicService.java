package com.myfirstwebsocketapp.app.services;

public interface BasicService<T, R> {
     T save(R t);
     void deleteById(Long id);

}
