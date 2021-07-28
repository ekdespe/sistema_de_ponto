package com.dio.live.controller;

import com.dio.live.model.Empresa;
import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaService.save(empresa);
    }
    @GetMapping
    public List<Empresa> getEmpresaList(){
        return empresaService.findAll();
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("idEmpresa") long idEmpresa){
        return ResponseEntity.ok(empresaService.getByID(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }
    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa){
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping
    public  ResponseEntity deleteByID(@PathVariable("idEmpresa") long idEmpresa){
        try {
            empresaService.deleteEmpresa(idEmpresa);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Empresa>) ResponseEntity.ok();
    }
}
