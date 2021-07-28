package com.dio.live.controller;

import com.dio.live.model.Movimentacao;
import com.dio.live.model.Usuario;
import com.dio.live.service.MovimentacaoService;
import com.dio.live.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao createUsuario(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.save(movimentacao);
    }
    @GetMapping
    public List<Movimentacao> getMovimentacaoList(){
        return movimentacaoService.findAll();
    }

    @GetMapping("/{idMovimentacao}")
    public ResponseEntity<Movimentacao> getMovimentacaoByID(@PathVariable("idMovimentacao") long idMovimentacao){
        return ResponseEntity.ok(movimentacaoService.getByID(idMovimentacao).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }
    @PutMapping
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.updateMovimentacao(movimentacao);
    }

    @DeleteMapping
    public  ResponseEntity deleteByID(@PathVariable("idMovimentacao") long idMovimentacao){
        try {
            movimentacaoService.deleteMovimentacao(idMovimentacao);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Movimentacao>) ResponseEntity.ok();
    }
}
