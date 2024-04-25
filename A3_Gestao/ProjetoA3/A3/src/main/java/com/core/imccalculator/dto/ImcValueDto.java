package com.core.imccalculator.dto;

public record ImcValueDto (Double imc,
                           String classificacao) {

    public String getClassificacao() {
        return classificacao;
    }


    public Double getImc() {
        return imc;
    }
}
