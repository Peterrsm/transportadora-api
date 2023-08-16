package com.pedromiranda.transportadoraapi.controller;

import com.pedromiranda.transportadoraapi.entity.Caminhao;
import com.pedromiranda.transportadoraapi.entity.Motorista;
import com.pedromiranda.transportadoraapi.request.CaminhaoRequest;
import com.pedromiranda.transportadoraapi.service.CaminhaoService;
import com.pedromiranda.transportadoraapi.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {
    @Autowired
    CaminhaoService service;

    @Autowired
    MotoristaService motoService;

    @GetMapping("/")
    public List<Caminhao> getAllCaminhoes() {
        return service.getAllCaminhoes();
    }

    @GetMapping("/{id}")
    public java.util.Optional<Caminhao> getCaminhaoById(@PathVariable("id") Long id) {
        return service.getCaminhao(id);
    }

    @PostMapping("/")
    public java.util.List<Caminhao> addCaminhao(@RequestBody CaminhaoRequest caminhao) {
        Caminhao car = new Caminhao();
        car.setPlaca(caminhao.getPlaca());
        car.setModelo(caminhao.getModelo());
        car.setMarca(caminhao.getMarca());

        return service.addCaminhao(car);
    }

    @PostMapping("/{caminhao_id}/{moto_id}")
    public void associateMotoAndCaminhao(@PathVariable("caminhao_id") Long caminhao_id, @PathVariable("moto_id") Long moto_id){
        Optional<Caminhao> car = service.getCaminhao(caminhao_id);
        Optional<Motorista> moto = motoService.getMotoristaById(moto_id);
        if(car.isPresent() && moto.isPresent()){
            car.get().vinculaMotorista(moto.get());
            service.addCaminhao(car.get());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCaminhaoById(@PathVariable("id") Long id) {
        service.deleteCaminhao(id);
    }
}

