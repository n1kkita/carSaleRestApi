package com.myfirstwebsocketapp.app.services;

import java.util.List;

public interface DtoService<Dto> {
    List<Dto> getAll();
    Dto getById(Long id);
}
