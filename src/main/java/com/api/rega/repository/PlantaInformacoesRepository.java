package com.api.rega.repository;

import com.api.rega.entity.PlantaInformacoes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantaInformacoesRepository extends JpaRepository<PlantaInformacoes, Long> {

    @Query("SELECT pi FROM " +
            "PlantaInformacoes pi " +
            "WHERE pi.planta.id = ?1 " +
            "ORDER BY pi.id DESC ")
    List<PlantaInformacoes> getInfoByPlantaId(Long plantaId, Pageable limit);

    @Query("""
            SELECT pi FROM PlantaInformacoes pi
            WHERE pi.planta.id = :plantaId
            AND pi.id = (SELECT MAX(pi2.id) FROM PlantaInformacoes pi2 WHERE pi2.planta.id = :plantaId)      
            """)
    PlantaInformacoes getLastInfoId(Long plantaId);
}
