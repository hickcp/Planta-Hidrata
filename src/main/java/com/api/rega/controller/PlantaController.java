package com.api.rega.controller;

import com.api.rega.service.PlantaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planta")
@Transactional
public class PlantaController {

    @Autowired
    private PlantaService service;


}
