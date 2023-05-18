package com.api.rega.service;

import com.api.rega.entity.Planta;
import com.api.rega.entity.PlantaInformacoes;
import com.api.rega.repository.PlantaInformacoesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
@ExtendWith(MockitoExtension.class)
public class PlantaInformacoesServiceTest {

    @InjectMocks
    private PlantaInformacoesService plantaInformacoesSvc;

    @Mock
    private PlantaInformacoesRepository plantaInformacoesRepo;

    @Test
    public void testListarInformacoes(){

        var planta = new Planta();
        var dado1 = new PlantaInformacoes(1l,planta,30,100,14,false);
        var dado2 = new PlantaInformacoes(2l,planta,150,39,32,false);
        var dado3 = new PlantaInformacoes(3l,planta,100,80,27,false);

        List<PlantaInformacoes> infos = new ArrayList<>();
        infos.add(dado1);
        infos.add(dado2);
        infos.add(dado3);
        Mockito.when(plantaInformacoesRepo.findAll()).thenReturn(infos);

        var response = plantaInformacoesSvc.listar();

        int i = 0;

        for (PlantaInformacoes info : infos) {
            Assertions.assertEquals(info.getId(), response.get(i).id());
            Assertions.assertEquals(null, response.get(i).idPlanta());
            Assertions.assertEquals(info.getLuzSolar(), response.get(i).luzSolar());
            Assertions.assertEquals(info.getUmidade(), response.get(i).umidade());
            Assertions.assertEquals(info.getTemperatura(), response.get(i).temperatura());
            i++;
        }
    }

}
