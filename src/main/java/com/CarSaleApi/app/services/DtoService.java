package com.CarSaleApi.app.services;

import java.util.List;

public interface DtoService<Dto> {
    List<Dto> getAll();
    Dto getById(Long id);
}
