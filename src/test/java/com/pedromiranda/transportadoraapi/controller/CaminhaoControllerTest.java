package com.pedromiranda.transportadoraapi.controller;

import com.pedromiranda.transportadoraapi.entity.Caminhao;
import com.pedromiranda.transportadoraapi.service.CaminhaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CaminhaoControllerTest {

    @Mock
    private CaminhaoService service;

    @InjectMocks
    private CaminhaoController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_return_all_Caminhoes() {
        Caminhao caminhao1 = new Caminhao(1L, "Ford", "SEDAN", null, null);
        Caminhao caminhao2 = new Caminhao(2L, "Tesla", "HAT", null, null);
        List<Caminhao> caminhoes = Arrays.asList(caminhao1, caminhao2);

        when(service.getAllCaminhoes()).thenReturn(caminhoes);

        List<Caminhao> result = controller.getAllCaminhoes();

        assertEquals(2, result.size());
        assertEquals(caminhao1, result.get(0));
        assertEquals(caminhao2, result.get(1));

        verify(service, atLeast(1)).getAllCaminhoes();
    }

    @Test
    public void should_return_only_one_Caminhao_by_id() {
        Caminhao caminhao = new Caminhao(2L, "Tesla", "HAT", null, null);

        when(service.getCaminhao(Mockito.anyLong())).thenReturn(Optional.of(caminhao));

        Optional<Caminhao> result = controller.getCaminhaoById(Mockito.anyLong());

        assertEquals(result.get().getId(), 2L); // Verifica se o tamanho da lista é 2
        assertEquals(result.get().getMarca(), "Tesla"); // Verifica se o primeiro caminhão é o mesmo
        assertEquals(result.get().getModelo(), "HAT"); // Verifica se o segundo caminhão é o mesmo

        verify(service, atLeast(1)).getCaminhao(Mockito.anyLong());
    }


}