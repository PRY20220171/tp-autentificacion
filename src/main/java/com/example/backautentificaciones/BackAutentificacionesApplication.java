package com.example.backautentificaciones;

import com.example.backautentificaciones.config.CassandraConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class BackAutentificacionesApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackAutentificacionesApplication.class, args);
    }

}
