package com.example.backautentificaciones.service;

import com.example.backautentificaciones.entity.UsuarioRolKey;
import com.example.backautentificaciones.entity.UsuarioXRol;

import java.util.List;
import java.util.UUID;

public interface UsuarioXRolService {
    List<UsuarioXRol> findUsuarioXRolAll();
    List<UsuarioXRol> findUsuarioXRolByIdrol(UUID idrol);
    List<UsuarioXRol> findUsuarioXRolByIdusuario(UUID idusuario);
    UsuarioXRol getUsuarioXRol(UUID idrol, UUID idusuario);
    UsuarioXRol getUsuarioXRol(UsuarioRolKey usuarioRolKey);
    UsuarioXRol createUsuarioXRol(UsuarioXRol usuarioxrol);
    UsuarioXRol updateUsuarioXRol(UsuarioXRol usuarioxrol);
    String deleteUsuarioXRol(UUID idrol, UUID idusuario);
    String deleteUsuarioXRol(UsuarioRolKey usuarioRolKey);
    //List<UsuarioXRol> findAllByIdusuarioAndIdrol(UUID idusuario, UUID idrol);
}
