package com.pedromiranda.transportadoraapi.controller;

import com.pedromiranda.transportadoraapi.entity.Motorista;
import com.pedromiranda.transportadoraapi.request.MotoristaRequest;
import com.pedromiranda.transportadoraapi.service.MotoristaService;
import com.pedromiranda.transportadoraapi.stubs.MotoristaStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MotoristaControllerTest {

    @Mock
    MotoristaService service;

    @InjectMocks
    MotoristaController controller;

    MotoristaStub stub = new MotoristaStub();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void getAllMotoristas() {
        when(service.getAllMotoristas())
                .thenReturn(stub.createListOfCaminhoes());

        assertEquals(controller.getAllMotoristas(), stub.createListOfCaminhoes());
    }

    @Test
    void getMotoristaById() {

        Motorista moto = stub.createMotorista();

        when(service.getMotoristaById(42l))
                .thenReturn(Optional.of(stub.createMotorista()));

        assertEquals(controller.getMotoristaById(42l), Optional.of(moto));
    }

    @Test
    void addMotorista() {
        Motorista moto = stub.createMotorista();
        MotoristaRequest request = stub.createMotoristaRequest(moto);

        List<Motorista> lista = new ArrayList<>();
        lista.add(moto);

        when(service.addMotorista(moto))
                .thenReturn(lista);

        assertEquals(controller.addMotorista(request), lista);
    }

    @Test
    void deleteMotorista() {
    }
}