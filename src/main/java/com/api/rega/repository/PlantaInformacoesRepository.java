package com.api.rega.repository;

import com.api.rega.entity.PlantaInformacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlantaInformacoesRepository extends JpaRepository<PlantaInformacoes, Long> {

    @Query("SELECT plantaInfo FROM " +
            "PlantaInformacoes plantaInfo " +
            "INNER JOIN plantaInfo.planta planta " +
            "WHERE planta.id = :idPlanta")
    Optional<PlantaInformacoes> getByIdPlanta(@Param("idPlanta") Long idPlanta);
}
