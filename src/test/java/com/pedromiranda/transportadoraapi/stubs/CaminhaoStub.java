package com.pedromiranda.transportadoraapi.stubs;

import com.pedromiranda.transportadoraapi.entity.Caminhao;

import java.util.ArrayList;
import java.util.List;

public class CaminhaoStub {

    public Caminhao initiateCaminhao(){
        return createCaminhao();
    }

    public List<Caminhao> createListOfCaminhoes(){
        List<Caminhao> lista= new ArrayList<>();
        lista.add(createCaminhao());
        lista.add(createCaminhao());
        lista.add(createCaminhao());

        return lista;
    }

    private Caminhao createCaminhao(){
        Caminhao caminhao = new Caminhao();
        caminhao.setId(42l);
        caminhao.setMarca("MarcaStub");
        caminhao.setPlaca("PlacaStub");
        caminhao.setModelo("ModeloStub");

        return caminhao;
    }
}
