package com.example.backautentificaciones.repository;

import com.example.backautentificaciones.entity.UsuarioRolKey;
import com.example.backautentificaciones.entity.UsuarioXRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.Repository;
@Repository
public interface UsuarioXRolRepository extends CrudRepository<UsuarioXRol, UsuarioRolKey> {
    List<UsuarioXRol> findAllByUsuarioRolKey_Idrol(UUID idrol);
    List<UsuarioXRol> findAllByUsuarioRolKey_Idusuario(UUID idusuario);
}
