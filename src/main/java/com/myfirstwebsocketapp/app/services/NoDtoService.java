package com.myfirstwebsocketapp.app.services;

import java.util.List;

public interface NoDtoService<Obj> {
    List<Obj> getAll();
    Obj getById(Long id);
}
