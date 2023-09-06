package com.myfirstwebsocketapp.app.services;

import java.util.List;

public interface BasicService<T, R> {
     T save(R t);
     List<R> getAll();
     R getById(Long id);
     void deleteById(Long id);

}
