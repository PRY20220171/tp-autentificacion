package com.example.backautentificaciones.service.impl;

import com.example.backautentificaciones.entity.Usuario;
import com.example.backautentificaciones.service.ProducerService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProducerServiceImpl implements ProducerService {
     @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg(Usuario object) {
        amqpTemplate.convertSendAndReceive("salud.usuarios.exchange","salud.usuarios.routingkey",object);
    }
}
