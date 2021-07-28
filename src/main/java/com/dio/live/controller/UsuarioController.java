package com.dio.live.controller;

import com.dio.live.model.Usuario;
import com.dio.live.model.Usuario;
import com.dio.live.service.UsuarioService;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }
    @GetMapping
    public List<Usuario> getUsuarioList(){
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioByID(@PathVariable("idUsuario") long idUsuario){
        return ResponseEntity.ok(usuarioService.getByID(idUsuario).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }
    @PutMapping
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping
    public  ResponseEntity deleteByID(@PathVariable("idUsuario") long idUsuario){
        try {
            usuarioService.deleteUsuario(idUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Usuario>) ResponseEntity.ok();
    }
}
