package com.imc.projeto.service;


import com.imc.projeto.dto.ImcValueDto;
import com.imc.projeto.entity.TabelaImc;
import com.imc.projeto.repository.TbImcRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ImcCalculatorService {

    @Autowired
    TbImcRepository tbImcRepository;

    public List<TabelaImc> exibirTabelaImc() {

        return tbImcRepository.findAll();
    }

    public ImcValueDto calculoImc(Double peso, Double altura) {

        double imc = peso / Math.pow(altura, 2);
        String classificacao = null;
        List<TabelaImc> tbImcList = tbImcRepository.findAll();

        if (imc > 0 && altura > 0){
            for (TabelaImc tabelaImc: tbImcList) {
                if (imc <= tabelaImc.getImc()) {
                    classificacao = tabelaImc.getClassificacao();
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