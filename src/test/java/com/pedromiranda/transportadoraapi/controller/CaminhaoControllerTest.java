package com.pedromiranda.transportadoraapi.controller;

import com.pedromiranda.transportadoraapi.entity.Caminhao;
import com.pedromiranda.transportadoraapi.entity.Motorista;
import com.pedromiranda.transportadoraapi.request.CaminhaoRequest;
import com.pedromiranda.transportadoraapi.service.CaminhaoService;
import com.pedromiranda.transportadoraapi.service.MotoristaService;
import com.pedromiranda.transportadoraapi.stubs.CaminhaoStub;
import com.pedromiranda.transportadoraapi.stubs.MotoristaStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CaminhaoControllerTest {

    @Mock
    private CaminhaoService service; // Verifique o nome correto da classe de serviço

    @InjectMocks
    private CaminhaoController controller;

    @Mock
    private MotoristaService moto_service;

    CaminhaoStub stub = new CaminhaoStub();

    MotoristaStub moto_stub = new MotoristaStub();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void shouldGetAllCaminhoes() {
        Caminhao caminhao1 = new Caminhao(1L, "Ford", "SEDAN", null, null);
        Caminhao caminhao2 = new Caminhao(2L, "Tesla", "HAT", null, null);
        List<Caminhao> caminhoes = Arrays.asList(caminhao1, caminhao2);

        when(service.getAllCaminhoes()).thenReturn(caminhoes);

        List<Caminhao> result = controller.getAllCaminhoes();

        assertEquals(2, result.size()); // Verifica se o tamanho da lista é 2
        assertEquals(caminhao1, result.get(0)); // Verifica se o primeiro caminhão é o mesmo
        assertEquals(caminhao2, result.get(1)); // Verifica se o segundo caminhão é o mesmo
        verify(service, atLeast(1)).getAllCaminhoes();
    }

    @Test
    void shouldGetSpecificCaminhao() {
        Caminhao caminhao = new Caminhao(2L, "Tesla", "HAT", null, null);

        when(service.getCaminhao(2L)).thenReturn(Optional.of(caminhao));

        Optional<Caminhao> result = controller.getCaminhaoById(2L);

        assertEquals(result.get().getId(), 2L);
        assertEquals(result.get().getMarca(), "Tesla");
        assertEquals(result.get().getModelo(), "HAT");
        verify(service, atLeast(1)).getCaminhao(Mockito.anyLong());
    }


    @Test
    void shouldAddCaminhao() {
        Caminhao caminhao = stub.createCaminhao();
        CaminhaoRequest request = stub.createCaminhaoRequest(caminhao);

        List<Caminhao> caminhoes = new ArrayList<>();
        caminhoes.add(caminhao);

        when(service.addCaminhao(caminhao))
                .thenReturn(caminhoes);

        assertEquals(caminhoes, controller.addCaminhao(request));

    }

    @Test
    void shouldReturnAllCaminhoes() {
        Caminhao caminhao = stub.createCaminhao();

        List<Caminhao> caminhoes = new ArrayList<>();
        caminhoes.add(caminhao);
        caminhoes.add(caminhao);
        caminhoes.add(caminhao);

        when(service.getAllCaminhoes())
                .thenReturn(caminhoes);

        assertEquals(controller.getAllCaminhoes(), caminhoes);
    }

    @Test
    void shouldReturnCaminhaoById() {
        Caminhao caminhao = stub.createCaminhao();

        when(service.getCaminhao(10L))
                .thenReturn(Optional.ofNullable(caminhao));

        assertEquals(controller.getCaminhaoById(10L), Optional.ofNullable(caminhao));
    }

    @Test
    void shouldAssociateMotoAndCaminhao() {
        Caminhao caminhao = stub.createCaminhao();
        Motorista moto = moto_stub.createMotorista();

        when(moto_service.getMotoristaById(moto.getId()))
                .thenReturn(Optional.of(moto));

        when(service.getCaminhao((caminhao.getId())))
                .thenReturn(Optional.of(caminhao));

        controller.associateMotoAndCaminhao(caminhao.getId(), moto.getId());

        assertEquals(caminhao.getMotoristas().size(), 1);
    }
}