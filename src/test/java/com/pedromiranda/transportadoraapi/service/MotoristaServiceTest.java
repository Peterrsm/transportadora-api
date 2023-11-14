package com.pedromiranda.transportadoraapi.service;

import com.pedromiranda.transportadoraapi.entity.Motorista;
import com.pedromiranda.transportadoraapi.repository.MotoristaRepository;
import com.pedromiranda.transportadoraapi.service.exceptions.MotoristaNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

class MotoristaServiceTest {

    @Mock
    MotoristaRepository repository;

    @InjectMocks
    MotoristaService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void addMotorista() {
        Motorista moto = new Motorista();
        moto.setId(100L);
        moto.setEndereco("Rua dos Alfeneiros");
        moto.setSobrenome("Potter");
        moto.setPrimeiro("Harry");
        List<Motorista> motoristas = Arrays.asList(moto);

        when(repository.saveAll(anyList()))
                .thenReturn(motoristas);

        assertEquals(motoristas, service.addMotorista(moto));

    }

    @Test
    void getAllMotoristas() {
        Motorista moto = new Motorista();
        moto.setId(100L);
        moto.setEndereco("Rua dos Alfeneiros");
        moto.setSobrenome("Potter");
        moto.setPrimeiro("Harry");
        List<Motorista> motoristas = Arrays.asList(moto);

        when(repository.findAll())
                .thenReturn(motoristas);

        assertEquals(motoristas, service.getAllMotoristas());
    }

    @Test
    void getMotoristaById() {
        Motorista moto = new Motorista();
        moto.setId(100L);
        moto.setEndereco("Rua dos Alfeneiros");
        moto.setSobrenome("Potter");
        moto.setPrimeiro("Harry");

        when(repository.findById(100L))
                .thenReturn(Optional.of(moto));

        assertEquals(Optional.of(moto), service.getMotoristaById(100L));
    }

    @Test
    void shouldThrowsMotoristaNotFoundException() {
        when(repository.findById(10L))
                .thenThrow(MotoristaNotFoundException.class);

        assertThrows(MotoristaNotFoundException.class, () -> service.getMotoristaById(10L));
    }
}