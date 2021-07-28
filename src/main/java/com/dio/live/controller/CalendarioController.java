package com.dio.live.controller;

import com.dio.live.model.Calendario;
import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario createCalendario(@RequestBody Calendario calendario) {
        return calendarioService.save(calendario);
    }
    @GetMapping
    public List<Calendario> getcalendarioList(){
        return calendarioService.findAll();
    }

    @GetMapping("/{idcalendario}")
    public ResponseEntity<Calendario> getcalendarioByID(@PathVariable("idcalendario") long idcalendario){
        return ResponseEntity.ok(calendarioService.getByID(idcalendario).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }
    @PutMapping
    public Calendario updatecalendario(@RequestBody Calendario calendario){
        return calendarioService.updateCalendario(calendario);
    }

    @DeleteMapping
    public  ResponseEntity deleteByID(@PathVariable("idcalendario") long idcalendario){
        try {
            calendarioService.deleteCalendario(idcalendario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Calendario>) ResponseEntity.ok();
    }
}
