//package com.imc.projetoA3.controller;
//
//import com.imc.projetoA3.dto.ImcValueDto;
//import com.imc.projetoA3.entity.TbImc;
//import com.imc.projetoA3.repository.TbImcRepository;
//import com.imc.projetoA3.service.ImcCalculatorService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//class ImcCalculatorControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private ImcCalculatorService imcCalculatorService;
//
//    @Autowired
//    private TbImcRepository tbImcRepository;
//
//    /*
//     * Testes Unitários
//     */
//    @Test
//    void exibirTabelaImc() throws Exception {
//        // Mock dos dados de TbImc
//        List<TbImc> tbImcList = Arrays.asList(
//                new TbImc(1L, 18.5, "Baixo peso"),
//                new TbImc(2L, 24.9, "Peso normal"),
//                new TbImc(3L, 29.9, "Excesso de peso"),
//                new TbImc(4L, 34.9, "Obesidade de Classe 1"),
//                new TbImc(5L, 39.9, "Obesidade de Classe 2"),
//                new TbImc(6L, 40.0, "Obesidade de Classe 3")
//        );
//
//        // Mock do comportamento do repository
//        when(tbImcRepository.findAll()).thenReturn(tbImcList);
//
//        // Execução do teste
//        MvcResult result = mvc.perform(get("/imcCalculator"))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        // Verificação do resultado
//        String responseBody = result.getResponse().getContentAsString();
//    }
//
//    @Test
//    void testCalcularImc() {
//        // Arrange
//        double peso = 68.0;
//        double altura = 1.75;
//        // Mock do comportamento do serviço
//        when(imcCalculatorService.calculoImc(peso, altura)).thenReturn(new ImcValueDto(22.2, "classificacao"));
//
//        // Act
//        ImcValueDto calculoImc = imcCalculatorService.calculoImc(peso, altura);
//
//        // Assert
//        assertEquals(22.2, calculoImc.imc(), 0.1); // IMC esperado para os valores de entrada
//    }
//
//    @Test
//    @DisplayName("Testando se o cálculo feito está correto e retorna o IMC com a classificação adequada")
//    void testcase1() throws Exception {
//        // Mock dos dados de TbImc
//        List<TbImc> tbImcList = Arrays.asList(
//                new TbImc(1L, 18.50, "Baixo Peso"),
//                new TbImc(2L, 24.90, "Peso normal"),
//                new TbImc(3L, 29.90, "Excesso de peso"),
//                new TbImc(4L, 34.90, "Obesidade Classe 1"),
//                new TbImc(5L, 39.9, "Obesidade Classe 2"),
//                new TbImc(6L, 40.0, "Obesidade Classe 3")
//        );
//
//        // Mock do comportamento do repository
//        when(tbImcRepository.findAll()).thenReturn(tbImcList);
//
//        // Mock do comportamento do serviço
//        when(imcCalculatorService.calculoImc(50.00, 1.70)).thenReturn(new ImcValueDto(17.39, "Adequado"));
//
//        // Execução do teste
//        ImcValueDto imcValueDto = imcCalculatorService.calculoImc(50.00, 1.70);
//
//        // Assert
//        assertEquals(17.39, imcValueDto.imc(), 0.1);
//        assertEquals("Adequado", imcValueDto.classificacao());
//    }
//}