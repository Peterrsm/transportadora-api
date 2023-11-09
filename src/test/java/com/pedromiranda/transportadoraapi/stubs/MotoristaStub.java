package com.pedromiranda.transportadoraapi.stubs;

import com.pedromiranda.transportadoraapi.entity.Motorista;
import com.pedromiranda.transportadoraapi.request.MotoristaRequest;

import java.util.ArrayList;
import java.util.List;

public class MotoristaStub {

    public List<Motorista> createListOfCaminhoes() {
        List<Motorista> lista = new ArrayList<>();
        lista.add(createMotorista());
        lista.add(createMotorista());
        lista.add(createMotorista());

        return lista;
    }

    public Motorista createMotorista() {
        Motorista motorista = new Motorista();
        motorista.setId(42l);
        motorista.setPrimeiro("Marcelinho");
        motorista.setSobrenome("Stronda");
        motorista.setEndereco("Vila do Chaves");

        return motorista;
    }

    public MotoristaRequest createMotoristaRequest(Motorista caminhao) {
        MotoristaRequest request = new MotoristaRequest();
        request.setEndereco(caminhao.getEndereco());
        request.setPrimeiro(caminhao.getPrimeiro());
        request.setSobrenome(caminhao.getSobrenome());

        return request;
    }
}
