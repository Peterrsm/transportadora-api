package com.pedromiranda.transportadoraapi.stubs;

import com.pedromiranda.transportadoraapi.entity.Caminhao;
import com.pedromiranda.transportadoraapi.request.CaminhaoRequest;

import java.util.ArrayList;
import java.util.List;

public class CaminhaoStub {

    public Caminhao initiateCaminhao() {
        return createCaminhao();
    }

    public List<Caminhao> createListOfCaminhoes() {
        List<Caminhao> lista = new ArrayList<>();
        lista.add(createCaminhao());
        lista.add(createCaminhao());
        lista.add(createCaminhao());

        return lista;
    }

    public Caminhao createCaminhao() {
        Caminhao caminhao = new Caminhao();
        caminhao.setId(42l);
        caminhao.setMarca("MarcaStub");
        caminhao.setPlaca("PlacaStub");
        caminhao.setModelo("ModeloStub");

        return caminhao;
    }

    public CaminhaoRequest createCaminhaoRequest(Caminhao caminhao) {
        CaminhaoRequest request = new CaminhaoRequest();
        request.setMarca(caminhao.getMarca());
        request.setModelo(caminhao.getModelo());
        request.setPlaca(caminhao.getPlaca());

        return request;
    }
}
