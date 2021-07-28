package com.dio.live.service;

import com.dio.live.model.TipoData;
import com.dio.live.model.TipoData;
import com.dio.live.model.Usuario;
import com.dio.live.repository.TipoDataRepository;
import com.dio.live.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {
    TipoDataRepository tipoDataRepository;

    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository) {
        this.tipoDataRepository = tipoDataRepository;
    }

    public TipoData save(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }
    public List<TipoData> findAll() {
        return tipoDataRepository.findAll();
    }

    public Optional<TipoData> getByID(Long idTipoData) {
        return  tipoDataRepository.findById(idTipoData) ;
    }
    public TipoData updateTipoData(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }
    public void deleteTipoData(Long idTipoData) {
        tipoDataRepository.deleteById(idTipoData); ;
    }
}
