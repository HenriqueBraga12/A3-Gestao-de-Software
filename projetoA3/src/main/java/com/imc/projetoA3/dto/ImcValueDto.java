package com.imc.projetoA3.dto;

public record ImcValueDto (Double imc, String classificacao) {

    public double getImcValue() {
        // TODO Auto-generated method stub
        return imc;
    }

    public String getImcClass() {
        return classificacao;
    }
}
