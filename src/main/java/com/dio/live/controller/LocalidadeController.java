package com.dio.live.controller;

import com.dio.live.model.Localidade;
import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade createLocalidade(@RequestBody Localidade localidade){
        return localidadeService.save(localidade);
    }
    @GetMapping
    public List<Localidade> getLocalidadeList(){
        return localidadeService.findAll();
    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeByID(@PathVariable("idLocalidade") long idLocalidade){
        return  ResponseEntity.ok(localidadeService.getByID(idLocalidade).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }
    @PutMapping
    public Localidade updateLocalidade(@RequestBody Localidade localidade){
        return localidadeService.updateLocalidade(localidade);
    }

    @DeleteMapping
    public  ResponseEntity deleteByID(@PathVariable("idLocalidade") long idLocalidade){
        try {
            localidadeService.deleteLocalidade(idLocalidade);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Localidade>) ResponseEntity.ok();
    }
}
