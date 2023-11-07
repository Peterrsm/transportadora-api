package com.pedromiranda.transportadoraapi.service.exceptions;

public class CaminhaoNotFoundException extends RuntimeException {

    public CaminhaoNotFoundException() {
        super("Caminhão não encontrado");
    }

    public CaminhaoNotFoundException(Long id) {
        super("Caminhão não encontrado - id:" + id);
    }
}
