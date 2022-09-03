package com.example.backautentificaciones.service;

import com.example.backautentificaciones.entity.Rol;

import java.util.List;
import java.util.UUID;

public interface RolService {
    List<Rol> findRolAll();
    Rol getRol(UUID id);
    Rol createRol(Rol rol);
    Rol updateRol(Rol rol);
    String deleteRol(UUID id);
}
