package com.api.rega.repository;

import com.api.rega.entity.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlantaRepository extends JpaRepository<Planta, Long> {

    @Query("SELECT MAX(planta.id) FROM Planta planta")
    Long ultimaPlantaCadastrada();
}
