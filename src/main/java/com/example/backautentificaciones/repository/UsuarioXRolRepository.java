package com.example.backautentificaciones.repository;

import com.example.backautentificaciones.entity.UsuarioXRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.Repository;
@Repository
public interface UsuarioXRolRepository extends CrudRepository<UsuarioXRol, UUID> {
    //UsuarioXRol findOneById(String id);
    List<UsuarioXRol> findAllByIdusuarioAndIdrol(UUID idusuario, UUID idrol);
    //@Query("SELECT * from pizza_orders WHERE orderdate = ?0 and zoneid = ?1 ALLOW FILTERING")
    //Order findOrderByOrderDateAndZoneId(LocalDate orderDate, ZoneId zoneId);
}
