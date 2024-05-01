package com.imc.projeto.controller;


import com.imc.projeto.dto.ImcValueDto;
import com.imc.projeto.entity.TabelaImc;
import com.imc.projeto.service.ImcCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/imcCalculator")
public class ImcCalculatorController {

    @Autowired
    ImcCalculatorService imcCalculatorService;

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

