package com.example.backautentificaciones.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backautentificaciones.entity.Rol;
import com.example.backautentificaciones.service.RolService;
import com.example.backautentificaciones.service.ProducerService;
import com.example.backautentificaciones.util.ErrorMessage;
import com.example.backautentificaciones.util.Message;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos del rol por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=Rol.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<Rol>> listRol(@RequestParam(name="idrol",required = false) String idRol){
        List<Rol> rols=new ArrayList<>();
        if(null==idRol){
            rols=rolService.findRolAll();
            if(rols.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            rols = Collections.singletonList(rolService.getRol(UUID.fromString(idRol)));
        }
        return ResponseEntity.ok(rols);
    }

    @PostMapping
    public ResponseEntity<Rol> createRol(@Valid @RequestBody Rol rol, BindingResult result){
        rol.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Rol rolcreate = rolService.createRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(rolcreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable("id") String id, @RequestBody Rol rol){
        rol.setId(UUID.fromString(id));
        Rol rolDB=rolService.updateRol(rol);
        if(rolDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rolDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable("id") String id){
        String rolDelete=rolService.deleteRol(UUID.fromString(id));
        if(rolDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rolDelete);
    }

    @Autowired
    ProducerService rabbitMQSender;

    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new Rol());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }



}
