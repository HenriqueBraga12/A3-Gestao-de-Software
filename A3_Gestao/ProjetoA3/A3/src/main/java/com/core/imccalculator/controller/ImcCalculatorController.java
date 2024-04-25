package com.core.imccalculator.controller;


import com.core.imccalculator.dto.ImcTableDto;
import com.core.imccalculator.dto.ImcValueDto;
import com.core.imccalculator.service.ImcCalculatorService;
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
    public ResponseEntity<List<ImcTableDto>> exibirTabelaImc() {

        List<ImcTableDto> imcTableDto = imcCalculatorService.exibirTabelaImc();


        return ResponseEntity.ok(imcTableDto);
    }

    @PostMapping
    public ResponseEntity<ImcValueDto> calcularImc(@RequestBody Map<String, Double> requestBody) {

        Double peso = requestBody.get("peso");
        Double altura = requestBody.get("altura");
        ImcValueDto imcValueDto = imcCalculatorService.calculoImc(peso, altura);
        return ResponseEntity.ok(imcValueDto);
    }
}

