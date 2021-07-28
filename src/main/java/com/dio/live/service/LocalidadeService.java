package com.dio.live.service;

import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;
import com.dio.live.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {
    LocalidadeRepository localidadeRepository;

    @Autowired
    public LocalidadeService(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    public Localidade save(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public Localidade updateLocalidade(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public Optional<Localidade> getByID(long idLocalidade) {
        return localidadeRepository.findById(idLocalidade);
    }

    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    public void deleteLocalidade(long idLocalidade) {
    }
}
