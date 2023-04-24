package com.api.rega.controller;

import com.api.rega.dto.DadosCadastroInformacoes;
import com.api.rega.dto.DadosListagemInformacoes;
import com.api.rega.entity.PlantaInformacoes;
import com.api.rega.service.PlantaInformacoesService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("informacoes")
public class PlantaInformacoesController {

    @Autowired
    private PlantaInformacoesService service;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroInformacoes dados){
        var informacoes = new PlantaInformacoes(dados);
        return ResponseEntity.ok(service.cadastrar(dados));
    }


    @GetMapping
    public ResponseEntity<List<DadosListagemInformacoes>> listar(){
        return ResponseEntity.ok(service.listar());
    }
}
