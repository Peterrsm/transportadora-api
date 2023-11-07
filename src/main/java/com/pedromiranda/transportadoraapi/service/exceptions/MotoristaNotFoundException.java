package com.pedromiranda.transportadoraapi.service.exceptions;

public class MotoristaNotFoundException extends RuntimeException {

    public MotoristaNotFoundException() {
        super("Motorista não encontrado");
    }
}
