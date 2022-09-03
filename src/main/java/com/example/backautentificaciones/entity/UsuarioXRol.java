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
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

//import javax.persistence.*;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = UsuarioXRol.class)
public class UsuarioXRol  implements Serializable {

    @EmbeddedId
    DiagnosticoPruebaKey idusuarioxrol;
/*
    @ManyToOne
    @MapsId("idusuario")
    @JoinColumn(name = "idusuario")
    
    @ManyToOne
    @MapsId("idrol")
    @JoinColumn(name = "idrol")
*/  
    @ApiModelProperty(value="El ID del usuario", dataType="uuid", position=1)
    @NotEmpty(message = "El idusuario no puede ser vacio")
    @NotNull(message = "El idusuario no puede ser nulo")
    //@Column("idusuario")
    @MapsId("idusuario")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID idusuario;

    @ApiModelProperty(value="El ID del rol", dataType="uuid", position=2)
    @NotEmpty(message = "La idrol no puede ser vacio")
    @NotNull(message = "La idrol no puede ser nulo")
    //@Column("idrol")
    @MapsId("idrol")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID idrol;

}
