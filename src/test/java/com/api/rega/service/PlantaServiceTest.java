package com.api.rega.service;

import com.api.rega.dto.planta.DadosPlantaNome;
import com.api.rega.entity.Planta;
import com.api.rega.repository.PlantaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class PlantaServiceTest {

    @InjectMocks
    private PlantaService svc;

    @Mock
    private PlantaRepository repo;

    @Test
    public void testNomes(){
        Planta dado1 = new Planta(1L,"Rosa","Rosa",null);
        Planta dado2 = new Planta(1L,"Girassol","Girassol",null);
        Planta dado3 = new Planta(1L,"Cravo","Cravo",null);
        Planta dado4 = new Planta(1L,"Samambaia","Samambaia",null);

        List<Planta> plantas = Stream.of(dado1, dado2, dado3, dado4).toList();
        Mockito.when(repo.findAll()).thenReturn(plantas);

        List<DadosPlantaNome> response = svc.getNomes();

        for(int i = 0; i < response.size(); i++){
            DadosPlantaNome nome = response.get(i);
            Planta planta = plantas.get(i);

            Assertions.assertEquals(planta.getId(), nome.id());
            Assertions.assertEquals(planta.getNome(), nome.nome());
        }
    }

    @Test
    public void testNomesException(){

        List<Planta> vazio = new ArrayList<Planta>();
        Mockito.when(repo.findAll()).thenReturn(vazio);

        Assertions.assertThrows(EntityNotFoundException.class, () -> svc.getNomes() );
    }

}