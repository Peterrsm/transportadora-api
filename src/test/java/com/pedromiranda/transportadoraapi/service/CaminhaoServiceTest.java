package com.pedromiranda.transportadoraapi.service;

import com.pedromiranda.transportadoraapi.entity.Caminhao;
import com.pedromiranda.transportadoraapi.repository.CaminhaoRepository;
import com.pedromiranda.transportadoraapi.service.exceptions.CaminhaoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CaminhaoServiceTest {

    @Mock
    CaminhaoRepository repository;

    @InjectMocks
    CaminhaoService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void getAllCaminhoes() {
        Caminhao caminhao1 = new Caminhao(1L, "Ford", "SEDAN", null, null);
        Caminhao caminhao2 = new Caminhao(2L, "Tesla", "HAT", null, null);
        List<Caminhao> caminhoes = Arrays.asList(caminhao1, caminhao2);

        when(repository.findAll())
                .thenReturn(caminhoes);

        assertEquals(service.getAllCaminhoes(), caminhoes);
    }

    @Test
    void getCaminhao() {
        Caminhao caminhao = new Caminhao(1L, "Ford", "SEDAN", null, null);

        when(repository.findById(10L))
                .thenReturn(java.util.Optional.of(caminhao));

        assertEquals(service.getCaminhao(10L), Optional.of(caminhao));
    }

    @Test
    void addCaminhao() {
        Caminhao caminhao1 = new Caminhao(1L, "Ford", "SEDAN", null, null);
        List<Caminhao> caminhoes = Arrays.asList(caminhao1);

        when(repository.saveAll(anyList()))
                .thenReturn(caminhoes);

        assertEquals(service.addCaminhao(caminhao1), caminhoes);
    }

    @Test
    void shouldThrowsCaminhaoNotFoundException() {
        when(repository.findById(10L))
                .thenThrow(CaminhaoNotFoundException.class);

        assertThrows(CaminhaoNotFoundException.class, () -> service.getCaminhao(10L));
    }
}