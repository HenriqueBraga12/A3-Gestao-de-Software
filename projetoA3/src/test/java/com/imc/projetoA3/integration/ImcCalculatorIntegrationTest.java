package com.imc.projetoA3.integration;

import com.imc.projetoA3.dto.ImcValueDto;
import com.imc.projetoA3.service.ImcCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ImcCalculatorIntegrationTest {

    @Autowired
    private ImcCalculatorService imcCalculatorService;

    @Test
    public void testCalculateImcIntegration() {
        // Mock + valor esperado do imc
        double peso = 72.4;
        double altura = 1.83;
        double imcEsperado = peso / (altura * altura);
        String classificacaoEsperada = getExpectedClassification(imcEsperado);
        
        // Imc calculado pelo método dto + assert equals
        ImcValueDto imcCalculadoDto = imcCalculatorService.calculoImc(peso, altura);

        assertEquals(imcEsperado, imcCalculadoDto.getImcValue());
        assertEquals(classificacaoEsperada, imcCalculadoDto.getImcClass());
    }

    private String getExpectedClassification(double imc) {
        // If pra determinar o imc que *deveria* sair
        if (imc < 18.5) {
            return "Baixo peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Excesso de peso";
        } else if (imc < 34.9) {
            return "Obesidade de Classe 1";
        } else if (imc < 39.9) {
            return "Obesidade de Classe 2";
        } else {
            return "Obesidade de Classe 3";
        }
    }
}
