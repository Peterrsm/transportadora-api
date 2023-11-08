package com.pedromiranda.transportadoraapi.service;

import com.pedromiranda.transportadoraapi.entity.Motorista;
import com.pedromiranda.transportadoraapi.repository.MotoristaRepository;
import com.pedromiranda.transportadoraapi.service.exceptions.MotoristaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class MotoristaService {

    @Autowired
    MotoristaRepository repository;

    public List<Motorista> addMotorista(Motorista driver) {
        return repository.saveAll(Arrays.asList(driver));
    }

    public List<Motorista> getAllMotoristas() {
        return repository.findAll();
    }

    public java.util.Optional<Motorista> getMotoristaById(Long id) {
        if (repository.findById(id).isEmpty())
            throw new MotoristaNotFoundException();
        return repository.findById(id);
    }

    public void deleteMotorista(Long id) {
        if (repository.findById(id).isEmpty())
            throw new MotoristaNotFoundException();

        repository.deleteById(id);
    }
}
