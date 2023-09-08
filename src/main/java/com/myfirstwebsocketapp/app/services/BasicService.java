package com.myfirstwebsocketapp.app.services;

public interface BasicService<Obj, Dto> extends DtoService<Dto> {
     Obj save(Dto t);
     void deleteById(Long id);

}
