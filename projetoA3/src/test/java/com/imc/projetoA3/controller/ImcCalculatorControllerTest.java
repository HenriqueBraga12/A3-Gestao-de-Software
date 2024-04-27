package com.imc.projetoA3.controller;

import com.imc.projetoA3.dto.ImcTableDto;
import com.imc.projetoA3.entity.TbImc;
import com.imc.projetoA3.repository.TbImcRepository;
import com.imc.projetoA3.service.ImcCalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;
import java.util.List;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ImcCalculatorController.class)
class ImcCalculatorControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ImcCalculatorService imcCalculatorService;

    @MockBean
    private TbImcRepository tbImcRepository;

    @Mock
    TbImc tbImc;

    @Test
    @DisplayName("Teste de integração ")
    void exibirTabelaImc() throws Exception {
        List<ImcTableDto> imcTableDtoList = Arrays.asList(
                new ImcTableDto(1L, 18.5, "Abaixo do peso")
        );
        when(imcCalculatorService.exibirTabelaImc()).thenReturn(imcTableDtoList);

        MvcResult result = mvc.perform((RequestBuilder) get("/imcCalculator"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        assertTrue(responseBody.contains("\"imcMinimo\":18.5"));
        assertTrue(responseBody.contains("\"imcMaximo\":24.9"));
    }
}