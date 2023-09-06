package com.myfirstwebsocketapp.app.services;

import java.util.List;

public interface CrudService<T, R> {
     T save(R t);
     List<R> getAll();
     R getById(Long id);
     T updateById(Long id);
     void deleteById(Long id);

}
