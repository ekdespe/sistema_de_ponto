package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriaUsuario ")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.save(categoriaUsuario);
    }
    @GetMapping
    public List<CategoriaUsuario> getCategoriaUsuarioList(){
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioByID(@PathVariable("idCategoriaUsuario") long idCategoriaUsuario){
        return ResponseEntity.ok(categoriaUsuarioService.getByID(idCategoriaUsuario).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }
    @PutMapping
    public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.updateCategoriaUsuario(categoriaUsuario);
    }

    @DeleteMapping
    public  ResponseEntity deleteByID(@PathVariable("idCategoriaUsuario") long idCategoriaUsuario){
        try {
            categoriaUsuarioService.deleteCategoriaUsuario(idCategoriaUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();
    }
}
