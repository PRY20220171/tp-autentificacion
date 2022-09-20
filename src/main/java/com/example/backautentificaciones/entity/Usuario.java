package com.example.backautentificaciones.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

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
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Usuario.class)
public class Usuario  implements Serializable {

    @ApiModelProperty(value="ID del usuario", dataType="uuid", position=1)
    @Id
    @Column("idusuario")
    @CassandraType(type = CassandraType.Name.UUID)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value="El nombre del usuario", dataType="text", position=2)
    @NotEmpty(message = "El nombre no puede ser vacio")
    @NotNull(message = "El nombre no puede ser nulo")
    @Column("nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String nombre;

    @ApiModelProperty(value="El apellido del usuario", dataType="text", position=3)
    @NotEmpty(message = "El apellido no puede ser vacio")
    @NotNull(message = "El apellido no puede ser nulo")
    @Column("apellido")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String apellido;

    @ApiModelProperty(value="Es el nombre de usuario del usuario", dataType="text", position=4)
    @NotEmpty(message = "El nombre de usuario no puede ser vacio")
    @NotNull(message = "El nombre de usuario no puede ser nulo")
    @Column( "username")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String username;

    @ApiModelProperty(value="Es la contraseña del usuario", dataType="text", position=5)
    @NotEmpty(message = "La contraseña no puede ser vacio")
    @NotNull(message = "La contraseña no puede ser nulo")
    @Column("password")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String password;


}
