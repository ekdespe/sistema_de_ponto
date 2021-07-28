package com.dio.live.controller;

import com.dio.live.model.NivelAcesso;
import com.dio.live.model.NivelAcesso;
import com.dio.live.model.Usuario;
import com.dio.live.service.NivelAcessoService;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivelAcesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.save(nivelAcesso);
    }
    @GetMapping
    public List<NivelAcesso> getNivelAcessoList(){
        return nivelAcessoService.findAll();
    }

    @GetMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoByID(@PathVariable("idNivelAcesso") long idNivelAcesso){
        return ResponseEntity.ok(nivelAcessoService.getByID(idNivelAcesso).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }
    @PutMapping
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.updateNivelAcesso(nivelAcesso);
    }

    @DeleteMapping
    public  ResponseEntity deleteByID(@PathVariable("idNivelAcesso") long idNivelAcesso){
        try {
            nivelAcessoService.deleteNivelAcesso(idNivelAcesso);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<NivelAcesso>) ResponseEntity.ok();
    }
}
