package com.pedromiranda.transportadoraapi.controller;

import com.pedromiranda.transportadoraapi.entity.Motorista;
import com.pedromiranda.transportadoraapi.request.MotoristaRequest;
import com.pedromiranda.transportadoraapi.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    MotoristaService service;

    @GetMapping("/")
    public java.util.List<Motorista> getAllMotoristas(){
        return service.getAllMotoristas();
    }

    @GetMapping("/{id}")
    public java.util.Optional<Motorista> getMotoristaById(@PathVariable ("id") Long id){
        return service.getMotoristaById(id);
    }

    @PostMapping("/")
    public java.util.List<Motorista> addMotorista(@RequestBody MotoristaRequest motorista) {
        Motorista driver = new Motorista();
        driver.setEndereco(motorista.getEndereco());
        driver.setPrimeiro(motorista.getPrimeiro());
        driver.setSobrenome(motorista.getSobrenome());

        return service.addMotorista(driver);
    }

    @DeleteMapping("/{id}")
    public void deleteMotorista(@PathVariable ("id") Long id){
        service.deleteMotorista(id);
    }
}
