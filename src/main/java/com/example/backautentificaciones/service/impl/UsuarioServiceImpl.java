package com.example.backautentificaciones.service.impl;

import com.example.backautentificaciones.entity.Usuario;
import com.example.backautentificaciones.repository.UsuarioRepository;
import com.example.backautentificaciones.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findUsuarioAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(UUID id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        //Aquí irian las validaciones al crear el usuario de ser necesario
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario usuarioDB = this.getUsuario(usuario.getId());
        if (usuarioDB == null) {
            return null;
        }
        //Actualizamos los valores del usuario:
        usuarioDB.setNombre(usuario.getNombre());
        usuarioDB.setApellido(usuario.getApellido());
        usuarioDB.setUsername(usuario.getUsername());
        usuarioDB.setPassword(usuario.getPassword());
        return usuarioRepository.save(usuario);
    }

    @Override
    public String deleteUsuario(UUID id) {
        Usuario usuarioDB = this.getUsuario(id);
        if (usuarioDB == null) {
            return null;
        }
        try{
            usuarioRepository.delete(usuarioDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public Usuario getByDni(Long dni) {
        return usuarioRepository.findAllByPasswordAndUsername("DNI", dni.toString());
    }

    @Override
    public Usuario getByDocExtranjeria(Long username) {
        return usuarioRepository.findAllByPasswordAndUsername("DOCUMENTO EXTRANJERIA", username.toString());
    }
 */
}
