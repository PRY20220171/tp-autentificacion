package com.example.backautentificaciones.service.impl;

import com.example.backautentificaciones.entity.UsuarioXRol;
import com.example.backautentificaciones.repository.UsuarioXRolRepository;
import com.example.backautentificaciones.service.UsuarioXRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioXRolServiceImpl implements UsuarioXRolService {
    @Autowired
    private UsuarioXRolRepository usuarioxrolRepository;

    @Override
    public List<UsuarioXRol> findUsuarioXRolAll() {
        return (List<UsuarioXRol>) usuarioxrolRepository.findAll();
    }

    @Override
    public UsuarioXRol getUsuarioXRol(UUID id) {
        return usuarioxrolRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioXRol createUsuarioXRol(UsuarioXRol usuarioxrol) {
        //Aquí irian las validaciones al crear el usuarioxrol de ser necesario
        return usuarioxrolRepository.save(usuarioxrol);
    }

    @Override
    public UsuarioXRol updateUsuarioXRol(UsuarioXRol usuarioxrol) {
        UsuarioXRol usuarioxrolDB = this.getUsuarioXRol(usuarioxrol.getId());
        if (usuarioxrolDB == null) {
            return null;
        }
        //Actualizamos los valores del usuarioxrol:
        usuarioxrolDB.setIdusuario(usuarioxrol.getIdusuario());
        usuarioxrolDB.setIdrol(usuarioxrol.getIdrol());
        usuarioxrolDB.setMotivo(usuarioxrol.getMotivo());
        return usuarioxrolRepository.save(usuarioxrol);
    }

    @Override
    public String deleteUsuarioXRol(UUID id) {
        UsuarioXRol usuarioxrolDB = this.getUsuarioXRol(id);
        if (usuarioxrolDB == null) {
            return null;
        }
        try{
            usuarioxrolRepository.delete(usuarioxrolDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public List<UsuarioXRol> findAllByIdusuarioAndIdrol(UUID idusuario, UUID idrol){
        return usuarioxrolRepository.findAllByIdusuarioAndIdrol("DNI", dni.toString());
    }

 */
}
