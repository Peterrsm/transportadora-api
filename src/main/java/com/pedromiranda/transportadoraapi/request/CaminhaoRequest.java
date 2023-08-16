package com.pedromiranda.transportadoraapi.request;

import lombok.Data;

@Data
public class CaminhaoRequest {

    private String marca;
    private String modelo;
    private String placa;

}
