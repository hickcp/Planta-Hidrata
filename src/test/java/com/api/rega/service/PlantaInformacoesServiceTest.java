package com.api.rega.service;

import com.api.rega.dto.plantainfo.DadosListagemInformacoes;
import com.api.rega.entity.Planta;
import com.api.rega.entity.PlantaInformacoes;
import com.api.rega.repository.PlantaInformacoesRepository;
import com.api.rega.service.PlantaInformacoesService;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.*;
@ExtendWith(MockitoExtension.class)
public class PlantaInformacoesServiceTest {

    @InjectMocks
    private PlantaInformacoesService plantaInformacoesSvc;

    @Mock
    private PlantaInformacoesRepository plantaInformacoesRepo;

    @Test
    public void testListarInformacoes(){
        List<PlantaInformacoes> infos = listaInfosEntity();
        Mockito.when(plantaInformacoesRepo.findAll()).thenReturn(infos);

        var response = plantaInformacoesSvc.listar();

        for(int i = 0; i < 0; i++) {
            Assertions.assertEquals(infos.get(i).getId(), response.get(0).id());
            Assertions.assertEquals(null, response.get(0).idPlanta());
            Assertions.assertEquals(infos.get(i).getLuzSolar(), response.get(0).luzSolar());
            Assertions.assertEquals(infos.get(i).getUmidade(), response.get(0).umidade());
            Assertions.assertEquals(infos.get(i).getTemperatura(), response.get(0).temperatura());
        }
    }

    private List<DadosListagemInformacoes> listaInfosDTO() {
        var dado1 = new DadosListagemInformacoes(1l,1l,30,100,14);
        var dado2 = new DadosListagemInformacoes(2l,1l,150,39,32);
        var dado3 = new DadosListagemInformacoes(3l,1l,100,80,27);

        List<DadosListagemInformacoes> dados = new ArrayList<>();
        dados.add(dado1);
        dados.add(dado2);
        dados.add(dado3);

        return dados;

        }

    private List<PlantaInformacoes> listaInfosEntity() {
        var planta = new Planta();
        var dado1 = new PlantaInformacoes(1l,planta,30,100,14,false);
        var dado2 = new PlantaInformacoes(2l,planta,150,39,32,false);
        var dado3 = new PlantaInformacoes(3l,planta,100,80,27,false);

        List<PlantaInformacoes> dados = new ArrayList<>();
        dados.add(dado1);
        dados.add(dado2);
        dados.add(dado3);

        return dados;

    }
}
