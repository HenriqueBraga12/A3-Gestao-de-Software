package com.imc.projetoA3.service;

import com.imc.projetoA3.dto.ImcValueDto;
import com.imc.projetoA3.entity.TbImc;
import com.imc.projetoA3.repository.TbImcRepository;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

class ImcCalculatorServiceTest {

    @Mock
    ImcCalculatorService imcCalculatorService;

    @Mock
    TbImc tbImc;

    @Mock
    ImcValueDto imcValueDto;

    @Mock
    TbImcRepository tbImcRepository;



    /*
     * Testes Unitários
     * */
    @Test
    void exibirTabelaImc() {
        List<TbImc> tbImcList = tbImcRepository.findAll();
        List<TbImc> tbImcListCompare = new ArrayList<>();

        // Adicione os objetos TbImc à lista
        tbImcListCompare.add(new TbImc(1L, 18.5, "Baixo peso"));
        tbImcListCompare.add(new TbImc(2L, 24.9, "Peso normal"));
        tbImcListCompare.add(new TbImc(3L, 29.9, "Excesso de peso"));
        tbImcListCompare.add(new TbImc(4L, 34.9, "Obesidade de Classe 1"));
        tbImcListCompare.add(new TbImc(5L, 39.9, "Obesidade de Classe 2"));
        tbImcListCompare.add(new TbImc(6L, 40.0, "Obesidade de Classe 3"));

        // Verifique se as listas são iguais
        assertIterableEquals(tbImcListCompare, tbImcList, "As listas não são iguais");
    }

    @Test
    void testCalcularImc() {
        // Arrange
        double peso = 68.0;
        double altura = 1.75;

        // Act
         ImcValueDto calculoImc =  imcCalculatorService.calculoImc(peso,altura);

        // Assert
        assertEquals(22.2, calculoImc.imc(), 0.1); // IMC esperado para os valores de entrada
    }


    @Test
    @DisplayName("Testando se o calculo feito está correto e retorna o  imc com a classificação adequada")
    void testcase1() throws JSONException {
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L, 18.50, "Baixo Peso"),
                new TbImc(2L, 24.90, "Peso normal"),
                new TbImc(3L, 29.90, "Excesso de peso"),
                new TbImc(4L, 34.90, "Obesidade Classe 1"),
                new TbImc(5L, 39.9, "Obesidade Classe 2"),
                new TbImc(6L, 40.0, "Obesidade Classe 3")
        );

        when(tbImcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto imcValueDto = imcCalculatorService.calculoImc(50.00, 1.70);

        assertEquals(17.39, imcValueDto.imc(), 0.1);
        assertEquals("Adequado", imcValueDto.classificacao());

    }
}