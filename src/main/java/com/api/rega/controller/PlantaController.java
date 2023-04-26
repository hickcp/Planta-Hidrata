package com.api.rega.controller;

import com.api.rega.service.PlantaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planta")
@Transactional
public class PlantaController {

    @Autowired
    private PlantaService service;

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity buscar(@PathVariable Long id){

        return ResponseEntity.ok( service.plantaEInformacoes(id));
    }
}
