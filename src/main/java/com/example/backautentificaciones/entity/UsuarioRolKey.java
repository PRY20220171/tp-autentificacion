
package com.example.backautentificaciones.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;

import java.io.Serializable;
// import java.util.Date;
import java.util.UUID;

import javax.persistence.Embeddable;
//import javax.persistence.*;

@Embeddable
public class UsuarioRolKey implements Serializable {

    @Column(name = "idusuario")
    UUID idusuario;

    @Column(name = "idrol")
    UUID idrol;
}