package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {
    @Autowired
    JornadaTrabalhoRepository jornadaTrabalhoRepository;


    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAll() {
        return jornadaTrabalhoRepository.findAll();
    }

    public Optional<JornadaTrabalho> getByID(Long idJornada) {
      return  jornadaTrabalhoRepository.findById(idJornada) ;
    }
    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }
    public void deleteJornada(Long idJornada) {
          jornadaTrabalhoRepository.deleteById(idJornada); ;
    }

}
