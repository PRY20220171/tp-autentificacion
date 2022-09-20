package com.example.backautentificaciones.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backautentificaciones.entity.UsuarioXRol;
import com.example.backautentificaciones.service.UsuarioXRolService;
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

//@RestController
//@RequestMapping("/usuariosxroles")
public class UsuarioXRolController {
    /*
    //TODO: Implementar metodos en Rol y Usuario respectivamente
    @Autowired
    private UsuarioXRolService usuarioxrolService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de una usuarioxrol por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=UsuarioXRol.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<UsuarioXRol>> listUsuarioXRol(@RequestParam(name="idusuarioxrol",required = false) String idUsuarioxrol){
        List<UsuarioXRol> usuarioxrols=new ArrayList<>();
        if(null==idUsuarioxrol){
            usuarioxrols=usuarioxrolService.findUsuarioXRolAll();
            if(usuarioxrols.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            usuarioxrols = Collections.singletonList(usuarioxrolService.getUsuarioXRol(UUID.fromString(idUsuarioxrol)));
        }
        return ResponseEntity.ok(usuarioxrols);
    }

    @PostMapping
    public ResponseEntity<UsuarioXRol> createUsuarioXRol(@Valid @RequestBody UsuarioXRol usuarioxrol, BindingResult result){
        usuarioxrol.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        UsuarioXRol usuarioxrolcreate = usuarioxrolService.createUsuarioXRol(usuarioxrol);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioxrolcreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioXRol> updateUsuarioXRol(@PathVariable("id") String id, @RequestBody UsuarioXRol usuarioxrol){
        usuarioxrol.setId(UUID.fromString(id));
        UsuarioXRol usuarioxrolDB=usuarioxrolService.updateUsuarioXRol(usuarioxrol);
        if(usuarioxrolDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioxrolDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuarioXRol(@PathVariable("id") String id){
        String usuarioxrolDelete=usuarioxrolService.deleteUsuarioXRol(UUID.fromString(id));
        if(usuarioxrolDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioxrolDelete);
    }
    @Autowired
    ProducerService rabbitMQSender;

    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new UsuarioXRol());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }



*/
}
