package com.imc.projetoA3.service;


import com.imc.projetoA3.dto.ImcTableDto;
import com.imc.projetoA3.dto.ImcValueDto;
import com.imc.projetoA3.entity.TbImc;
import com.imc.projetoA3.repository.ImcRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ImcCalculatorService {

    @Autowired
    ImcRepository imcRepository;

    public List<ImcTableDto> exibirTabelaImc() {

        List<TbImc> tbImcList = imcRepository.findAll();
        List<ImcTableDto> imcTableDtos = new ArrayList<>();
        log.info("Total de registros encontrados na tabela tb_imc: {}", tbImcList.size());
        for (TbImc tbImc : tbImcList) {
            tbImc.getId();
            imcTableDtos.add(new ImcTableDto(tbImc.getId(),
                    tbImc.getImc(),
                    tbImc.getClassificacao()));
        }
        log.info("Total de registros convertidos para ImcTableDto: {}", imcTableDtos.size());
        return imcTableDtos;
    }

    public ImcValueDto calculoImc(Double peso, Double altura) {

        double imc = peso / Math.pow(altura, 2);
        String classificacao = null;
        List<TbImc> tbImcList = imcRepository.findAll();

        if (imc > 0 && altura > 0){
            for (int c = 0; c < tbImcList.size(); c++) {
                if (imc <= tbImcList.get(c).getImc()) {
                    classificacao = tbImcList.get(c).getClassificacao();
                    break; // Sai do loop assim que encontrar a classificação
                }
            }
            if (imc > tbImcList.get(tbImcList.size() - 1).getImc()) {
                classificacao = tbImcList.get(tbImcList.size() - 1).getClassificacao();
            }
            return new ImcValueDto(imc, classificacao);
        }
        return null;
    }
}