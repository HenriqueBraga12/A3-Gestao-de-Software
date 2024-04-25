package com.core.imccalculator.dto;




public record ImcTableDto(Long id,
                          Double imc,
                          String classificacao) {
    public double getImc() {
        return imc;
    }
    public String getClassificacao() {
        return classificacao;
    }

}
