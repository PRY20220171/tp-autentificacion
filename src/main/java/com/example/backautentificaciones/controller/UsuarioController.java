package com.example.backautentificaciones.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backautentificaciones.entity.Usuario;
import com.example.backautentificaciones.service.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos del usuario por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=Usuario.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<Usuario>> listUsuario(@RequestParam(name="idusuario",required = false) String idUsuario){
        List<Usuario> usuarios=new ArrayList<>();
        if(null==idUsuario){
            usuarios=usuarioService.findUsuarioAll();
            if(usuarios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            usuarios = Collections.singletonList(usuarioService.getUsuario(UUID.fromString(idUsuario)));
        }
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario, BindingResult result){
        usuario.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Usuario usuariocreate = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariocreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") String id, @RequestBody Usuario usuario){
        usuario.setId(UUID.fromString(id));
        Usuario usuarioDB=usuarioService.updateUsuario(usuario);
        if(usuarioDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") String id){
        String usuarioDelete=usuarioService.deleteUsuario(UUID.fromString(id));
        if(usuarioDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDelete);
    }

    @Autowired
    ProducerService rabbitMQSender;

    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new Usuario());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }



}
