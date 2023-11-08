package com.pedromiranda.transportadoraapi.service;

import com.pedromiranda.transportadoraapi.entity.Caminhao;
import com.pedromiranda.transportadoraapi.repository.CaminhaoRepository;
import com.pedromiranda.transportadoraapi.service.exceptions.CaminhaoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class CaminhaoService {

    @Autowired
    CaminhaoRepository repository;

    public List<Caminhao> getAllCaminhoes() {
        return repository.findAll();
    }

    public java.util.Optional<Caminhao> getCaminhao(Long id) {
        if (repository.findById(id).isEmpty())
            throw new CaminhaoNotFoundException(id);

        return repository.findById(id);
    }

    public List<Caminhao> addCaminhao(Caminhao car) {
        return repository.saveAll(Arrays.asList(car));
    }

    public void deleteCaminhao(Long id) {
        if (repository.findById(id).isEmpty())
            throw new CaminhaoNotFoundException(id);

        repository.deleteById(id);
    }
}
