package com.example.backautentificaciones.service.impl;

import com.example.backautentificaciones.entity.UsuarioRolKey;
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
    public List<UsuarioXRol> findUsuarioXRolByIdrol(UUID idrol) {
        return usuarioxrolRepository.findAllByUsuarioRolKey_Idrol(idrol);
    }
    @Override
    public List<UsuarioXRol> findUsuarioXRolByIdusuario(UUID idusuario) {
        return usuarioxrolRepository.findAllByUsuarioRolKey_Idusuario(idusuario);
    }
    @Override
    public UsuarioXRol getUsuarioXRol(UUID idrol, UUID idusuario) {
        return usuarioxrolRepository.findById(new UsuarioRolKey(idrol, idusuario)).orElse(null);
    }

    @Override
    public UsuarioXRol getUsuarioXRol(UsuarioRolKey key) {
        return usuarioxrolRepository.findById(key).orElse(null);
    }

    @Override
    public UsuarioXRol createUsuarioXRol(UsuarioXRol usuarioxrol) {
        //Aquí irian las validaciones al crear el usuarioxrol de ser necesario
        return usuarioxrolRepository.save(usuarioxrol);
    }

    @Override
    public UsuarioXRol updateUsuarioXRol(UsuarioXRol usuarioxrol) {
        UsuarioXRol usuarioxrolDB = this.getUsuarioXRol(usuarioxrol.getUsuarioRolKey());
        if (usuarioxrolDB == null) {
            return null;
        }
        //Actualizamos los valores del usuarioxrol:
        usuarioxrolDB.getUsuarioRolKey().setIdrol(usuarioxrol.getUsuarioRolKey().getIdrol());
        return usuarioxrolRepository.save(usuarioxrolDB);
    }

    @Override
    public String deleteUsuarioXRol(UUID idrol, UUID idusuario){
        UsuarioXRol usuarioxrolDB = this.getUsuarioXRol(idrol, idusuario);
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
    @Override
    public String deleteUsuarioXRol(UsuarioRolKey key){
        UsuarioXRol usuarioxrolDB = this.getUsuarioXRol(key);
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

}
