package com.core.imccalculator.service;

import com.core.imccalculator.dto.ImcTableDto;
import com.core.imccalculator.dto.ImcValueDto;
import com.core.imccalculator.entity.TbImc;
import com.core.imccalculator.repository.ImcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class ImcCalculatorServiceTest {

    @Mock
    private TbImc tbImc;

    @Mock
    private ImcRepository imcRepository;

    @InjectMocks
    private ImcCalculatorService imcCalculatorService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Caso a tabela seja exibida corretamente")
    void exibirTabelaImccase1() {

        TbImc tbImc1 = new TbImc();
        tbImc1.setId(1L);
        tbImc1.setImc(18.5);
        tbImc1.setClassificacao("Baixo Peso");

        TbImc tbImc2 = new TbImc();
        tbImc2.setId(2L);
        tbImc2.setImc(24.9);
        tbImc2.setClassificacao("Peso Normal");

        when(imcRepository.findAll()).thenReturn(Arrays.asList(tbImc1, tbImc2));
        List<ImcTableDto> result = imcCalculatorService.exibirTabelaImc();

        // Verificar se o resultado é o esperado
        assertEquals(2, result.size()); // Deve haver 2 registros
        assertEquals("Baixo Peso", result.get(1).getClassificacao());
        assertEquals(24.9, result.get(2).getImc());
    }

    @Test
    @DisplayName("Caso a tabela não seja exibida sem informaçoes")
    void exibirTabelaImccase2() {
        when(imcRepository.findAll()).thenReturn(new ArrayList<>());
        List<ImcTableDto> result = imcCalculatorService.exibirTabelaImc();
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Testando se o calculo feito está correto e retorna o  imc com a classificação adequada")
    void testcase1(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")


        );
        when(imcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(50.00, 1.70);
        assertEquals(17.30, result.getImc(), 0.01);
        assertEquals("Baixo Peso", result.getClassificacao());

    }
    @Test
    @DisplayName("Testando se o calculo feito está correto e retorna o  imc com a classificação adequada")
    void testcase2(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")


        );
        when(imcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(60.00, 1.70);
        assertEquals(20.76, result.getImc(), 0.01);
        assertEquals("Peso normal", result.getClassificacao());

    }
    @Test
    @DisplayName("Testando se o calculo feito está correto e retorna o  imc com a classificação adequada")
    void testcase3(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")


        );
        when(imcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(100.00, 1.70);
        assertEquals(34.60, result.getImc(), 0.01);
        assertEquals("Obesidade Grau I", result.getClassificacao());

    }
    @Test
    @DisplayName("Testando se o calculo feito está correto e retorna o  imc com a classificação adequada")
    void testcase4(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")


        );
        when(imcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(110.00, 1.70);
        assertEquals(38.06, result.getImc(), 0.01);
        assertEquals("Obesidade classe 2", result.getClassificacao());

    }
    @Test
    @DisplayName("Testando se o calculo feito está correto e retorna o  imc com a classificação adequada")
    void testcase5(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")


        );
        when(imcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(117.00, 1.70);
        assertEquals(40.48, result.getImc(), 0.01);
        assertEquals("Obesidade classe 3", result.getClassificacao());

    }
}