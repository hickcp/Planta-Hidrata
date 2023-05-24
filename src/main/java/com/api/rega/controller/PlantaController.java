package com.api.rega.controller;

import com.api.rega.dto.planta.DadosPlantaNome;
import com.api.rega.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planta")
public class PlantaController {

    @Autowired
    private PlantaService service;

    @GetMapping
    public ResponseEntity<List<DadosPlantaNome>> getNomes(){
       var response = service.getNomes();

       return ResponseEntity.ok(response);
    }
}
