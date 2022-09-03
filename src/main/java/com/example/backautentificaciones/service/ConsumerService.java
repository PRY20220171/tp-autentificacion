package com.example.backautentificaciones.service;

import com.example.backautentificaciones.entity.Usuario;

import java.util.UUID;

public interface ConsumerService {
    Object consumerMessage(UUID proId) throws Exception;
}
