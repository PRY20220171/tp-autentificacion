package com.example.backautentificaciones.service;

import com.example.backautentificaciones.entity.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    List<Usuario> findUsuarioAll();
    Usuario getUsuario(UUID id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    String deleteUsuario(UUID id);
}
