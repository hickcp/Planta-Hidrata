package com.api.rega.service;


import com.api.rega.dto.plantainfo.DadosCadastroRegar;
import com.api.rega.dto.plantainfo.DadosListagemInformacoes;
import com.api.rega.entity.Planta;
import com.api.rega.entity.PlantaInformacoes;
import com.api.rega.repository.PlantaInformacoesRepository;
import com.api.rega.repository.PlantaRepository;
import org.h2.table.Plan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;

import java.util.*;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class PlantaInformacoesServiceTest {

    @InjectMocks
    private PlantaInformacoesService plantaInformacoesSvc;

    @Mock
    private PlantaInformacoesRepository plantaInformacoesRepo;

    @Mock
    private PlantaRepository plantaRepo;

    @Test
    public void testListarInformacoes(){

        var planta = new Planta(1l);
        var dado1 = new PlantaInformacoes(1l, planta, 30, 100, 14, false);
        var dado2 = new PlantaInformacoes(2l, planta, 150, 39, 32, false);
        var dado3 = new PlantaInformacoes(3l, planta, 100, 80, 27, false);

        List<PlantaInformacoes> infos = Stream.of(dado1, dado2, dado3).toList();
        Mockito.when(plantaInformacoesRepo.findAll()).thenReturn(infos);

        var response = plantaInformacoesSvc.listar();
        for (int i = 0; i < response.size(); i++) {
            DadosListagemInformacoes responseInfo = response.get(i);
            PlantaInformacoes info = infos.get(i);

            Assertions.assertEquals(info.getId(), responseInfo.id());
            Assertions.assertEquals(info.getPlanta().getId(), responseInfo.idPlanta());
            Assertions.assertEquals(info.getLuzSolar(), responseInfo.luzSolar());
            Assertions.assertEquals(info.getUmidade(), responseInfo.umidade());
            Assertions.assertEquals(info.getTemperatura(), responseInfo.temperatura());
        }
    }

    @Test
    public void testGetInfoByPlantaId(){

        Planta planta1 = new Planta(1L,"Rosa","Rosa", null);
        var dado1 = new PlantaInformacoes(1L,planta1,30,100,14,false);
        var dado2 = new PlantaInformacoes(2L,planta1,150,39,32,false);
        var dado3 = new PlantaInformacoes(3L,planta1,100,80,27,false);

        List<PlantaInformacoes> infos = Stream.of(dado1,dado2,dado3).toList();

        Optional<Planta> plantaOptional = Optional.of(new Planta(1L,"Rosa","Rosa", null));
        Mockito.when(plantaRepo.findById(Mockito.anyLong())).thenReturn(plantaOptional);

        PageRequest page = PageRequest.of(0, 1);
        Mockito.when(plantaInformacoesRepo.getInfoByPlantaId(1L,page)).thenReturn(infos);

        var response = plantaInformacoesSvc.getInfoByPlantaId(1L, 1);

        int i = 0;

        for (PlantaInformacoes info : infos) {
            Assertions.assertEquals(info.getId(), response.getInformacoes().get(i).getId_planta_info());
            Assertions.assertEquals(info.getLuzSolar(), response.getInformacoes().get(i).getLuz_solar());
            Assertions.assertEquals(info.getUmidade(), response.getInformacoes().get(i).getUmidade());
            Assertions.assertEquals(info.getTemperatura(), response.getInformacoes().get(i).getTemperatura());
            i++;
        }
    }

    @Test
    public void testRegar(){
        var dadosRegar = new DadosCadastroRegar(true);
        var plantaInfo = new PlantaInformacoes(1l, null, 30, 100, 14, false);
        var planta = new Planta(1L,"Rosa","Rosa", null);

        Mockito.when(plantaInformacoesRepo.getLastInfoId(Mockito.anyLong())).thenReturn(plantaInfo);
        Mockito.when(plantaRepo.getReferenceById(Mockito.anyLong())).thenReturn(planta);

        var response = plantaInformacoesSvc.regar(Mockito.anyLong(), dadosRegar);

        Assertions.assertEquals(response.id(), planta.getId());
        Assertions.assertEquals(response.nome(), planta.getNome());
        Assertions.assertEquals(response.nomeCientifico(), planta.getNomeCientifico());
        Assertions.assertEquals(response.luzSolar(), plantaInfo.getLuzSolar());
        Assertions.assertEquals(response.temperatura(), plantaInfo.getTemperatura());
        Assertions.assertEquals(response.umidade(), plantaInfo.getUmidade());
        Assertions.assertEquals(response.regar(), dadosRegar.regar());
    }

}
