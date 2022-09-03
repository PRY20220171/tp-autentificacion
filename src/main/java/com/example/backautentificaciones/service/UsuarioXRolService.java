package com.example.backautentificaciones.service;

import com.example.backautentificaciones.entity.UsuarioXRol;

import java.util.List;
import java.util.UUID;

public interface UsuarioXRolService {
    List<UsuarioXRol> findUsuarioXRolAll();
    //UsuarioXRol getUsuarioXRol(UUID idusuario,UUID idrol);
    UsuarioXRol getUsuarioXRol(UUID id);
    UsuarioXRol createUsuarioXRol(UsuarioXRol usuarioxrol);
    UsuarioXRol updateUsuarioXRol(UsuarioXRol usuarioxrol);
    String deleteUsuarioXRol(UUID id);
    List<UsuarioXRol> findAllByIdusuarioAndIdrol(UUID idusuario, UUID idrol);
}
