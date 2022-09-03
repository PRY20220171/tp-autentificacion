package com.example.backautentificaciones.service.impl;

import com.example.backautentificaciones.entity.Rol;
import com.example.backautentificaciones.repository.RolRepository;
import com.example.backautentificaciones.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> findRolAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public Rol getRol(UUID id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public Rol createRol(Rol rol) {
        //Aquí irian las validaciones al crear el rol de ser necesario
        return rolRepository.save(rol);
    }

    @Override
    public Rol updateRol(Rol rol) {
        Rol rolDB = this.getRol(rol.getId());
        if (rolDB == null) {
            return null;
        }
        //Actualizamos los valores del rol:
        rolDB.setDescripcion(rol.getDescripcion());
        return rolRepository.save(rol);
    }

    @Override
    public String deleteRol(UUID id) {
        Rol rolDB = this.getRol(id);
        if (rolDB == null) {
            return null;
        }
        try{
            rolRepository.delete(rolDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public Rol getByDni(Long dni) {
        return rolRepository.findAllByTipoAndEstado("DNI", dni.toString());
    }

    @Override
    public Rol getByDocExtranjeria(Long estado) {
        return rolRepository.findAllByTipoAndEstado("DOCUMENTO EXTRANJERIA", estado.toString());
    }
 */
}
