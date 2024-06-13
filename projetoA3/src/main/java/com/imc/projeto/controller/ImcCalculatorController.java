package com.imc.projeto.controller;


import com.imc.projeto.entity.TabelaImc;
import com.imc.projeto.service.ImcCalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imcCalculator")
public class ImcCalculatorController {

    private final ImcCalculatorService imcCalculatorService;

    public ImcCalculatorController(ImcCalculatorService imcCalculatorService) {
        this.imcCalculatorService = imcCalculatorService;
    }

    @GetMapping()
    public ResponseEntity<List<TabelaImc>> exibirTabelaImc() {

        List<TabelaImc> TabelaImc = imcCalculatorService.exibirTabelaImc();


        return ResponseEntity.ok(TabelaImc);
    }

//    @PostMapping
//    public ResponseEntity<ImcValueDto> calcularImc(@RequestBody Map<String, Double> requestBody) {
//
//        Double peso = requestBody.get("peso");
//        Double altura = requestBody.get("altura");
//        ImcValueDto imcValueDto = imcCalculatorService.calculoImc(peso, altura);
//        return ResponseEntity.ok(imcValueDto);
//    }
}

