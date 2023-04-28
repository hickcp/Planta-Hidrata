package com.api.rega.repository;

import com.api.rega.entity.PlantaInformacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantaInformacoesRepository extends JpaRepository<PlantaInformacoes, Long> {

    List<PlantaInformacoes> findByPlantaId(Long plantaId);
}
