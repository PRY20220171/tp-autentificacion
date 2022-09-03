package com.example.backautentificaciones.service;

import com.example.backautentificaciones.entity.Usuario;

public interface ProducerService {
    //Object sendMsg(Long proId) throws Exception;

    void sendMsg(Usuario object);
}
