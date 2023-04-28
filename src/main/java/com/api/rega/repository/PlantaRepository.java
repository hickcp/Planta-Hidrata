package com.api.rega.repository;

import com.api.rega.entity.Planta;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlantaRepository extends JpaRepository<Planta, Long> {


    @EntityGraph(attributePaths = "informacoes")
    @Query("""
            SELECT  p
            FROM Planta p
            INNER JOIN PlantaInformacoes pi
            ON (p.id = pi.planta.id)
            WHERE p.id = :idPlanta
            AND pi.id = (SELECT MAX(id) FROM PlantaInformacoes WHERE planta.id = :idPlanta ORDER BY pi.planta.id ASC)
            """)
    Planta buscarPlantaeInformacoes(Long idPlanta);

    @Query("SELECT MAX(planta.id) FROM Planta planta")
    Long ultimaPlantaCadastrada();
}
