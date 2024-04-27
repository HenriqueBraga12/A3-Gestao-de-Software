package com.imc.projetoA3.service;

import com.imc.projetoA3.dto.ImcTableDto;
import com.imc.projetoA3.dto.ImcValueDto;
import com.imc.projetoA3.entity.TbImc;
import com.imc.projetoA3.repository.TbImcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class ImcCalculatorServiceTest {

    @Mock
    private TbImc tbImc;

    @Mock
    private TbImcRepository tbImcRepository;

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

        when(tbImcRepository.findAll()).thenReturn(Arrays.asList(tbImc1, tbImc2));
        ImcValueDto result = imcCalculatorService.calculoImc(50.00, 1.70);
        assertEquals(17.30, result.imc(), 0.01);
        assertEquals("Baixo Peso", result.classificacao());
    }



    @Test
    @DisplayName("Caso a tabela não seja exibida sem informaçoes")
    void exibirTabelaImccase2() {
        when(tbImcRepository.findAll()).thenReturn(new ArrayList<>());
        List<ImcTableDto> result = imcCalculatorService.exibirTabelaImc();
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Testando se o cálculo feito está correto e retorna o IMC com a classificação adequada")
    void testcase1(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")
        );

        when(tbImcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(50.00, 1.70);
        assertEquals(17.30, result.imc(), 0.01); // O valor esperado foi ajustado para 17.30
        assertEquals("Baixo Peso", result.classificacao());
    }

    @Test
    @DisplayName("Testando se o cálculo feito está correto e retorna o IMC com a classificação adequada")
    void testcase2(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")
        );

        when(tbImcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(60.00, 1.70);
        assertEquals(20.76, result.imc(), 0.01); // O valor esperado foi ajustado para 20.76
        assertEquals("Peso normal", result.classificacao());
    }

    @Test
    @DisplayName("Testando se o cálculo feito está correto e retorna o IMC com a classificação adequada")
    void testcase3(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")
        );

        when(tbImcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(100.00, 1.70);
        assertEquals(34.60, result.imc(), 0.01); // O valor esperado foi ajustado para 34.60
        assertEquals("Obesidade Classe 1", result.classificacao()); // A classificação esperada foi ajustada para "Obesidade Classe 1"
    }

    @Test
    @DisplayName("Testando se o cálculo feito está correto e retorna o IMC com a classificação adequada")
    void testcase4(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")
        );

        when(tbImcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(110.00, 1.70);
        assertEquals(38.06, result.imc(), 0.01);
        assertEquals("Obesidade Classe 2", result.classificacao()); // A classificação esperada foi ajustada para "Obesidade Classe 2"
    }

    @Test
    @DisplayName("Testando se o cálculo feito está correto e retorna o IMC com a classificação adequada")
    void testcase5(){
        List<TbImc> tbImcList = Arrays.asList(
                new TbImc(1L,18.50, "Baixo Peso"),
                new TbImc(2L, 24.90,"Peso normal"),
                new TbImc(3L, 29.90,"Excesso de peso"),
                new TbImc(4L, 34.90,"Obesidade Classe 1"),
                new TbImc(5L, 39.9,"Obesidade Classe 2"),
                new TbImc(6L, 40.0,"Obesidade Classe 3")
        );

        when(tbImcRepository.findAll()).thenReturn(tbImcList);
        ImcValueDto result = imcCalculatorService.calculoImc(117.00, 1.70);
        assertEquals(40.48, result.imc(), 0.01);
        assertEquals("Obesidade Classe 3", result.classificacao()); // A classificação esperada foi ajustada para "Obesidade Classe 3"
    }

}