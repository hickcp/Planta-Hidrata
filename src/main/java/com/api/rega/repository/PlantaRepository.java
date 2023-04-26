package com.api.rega.repository;

import com.api.rega.entity.Planta;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlantaRepository extends JpaRepository<Planta, Long> {

    @EntityGraph(attributePaths = "informacoes")
    @Query("""
            SELECT  p
            FROM Planta p
            INNER JOIN PlantaInformacoes pi
            ON (p.id = pi.idPlanta)
            WHERE p.id = :idPlanta
            AND pi.id = (SELECT MAX(id) FROM PlantaInformacoes WHERE idPlanta = :idPlanta ORDER BY pi.idPlanta ASC)
            """)
    Planta buscarPlantaeInformacoes(Long idPlanta);
}
