package com.dio.live.service;

import com.dio.live.model.Ocorrencia;
import com.dio.live.model.Ocorrencia;
import com.dio.live.model.TipoData;
import com.dio.live.repository.OcorrenciaRepository;
import com.dio.live.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {
    OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Ocorrencia save(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }
    public List<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    public Optional<Ocorrencia> getByID(Long idOcorrencia) {
        return  ocorrenciaRepository.findById(idOcorrencia) ;
    }
    public Ocorrencia updateOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }
    public void deleteOcorrencia(Long idOcorrencia) {
        ocorrenciaRepository.deleteById(idOcorrencia); ;
    }
}