package com.core.imccalculator.dto;

import com.core.imccalculator.entity.Endereco;
import lombok.Getter;

@Getter
public record UsuarioDTO(Long idUsuario,
                         String name,
                         String email,
                         String cpf,
                         Endereco endereco,
                         Double peso,
                         Double altura) {

   public Endereco getEndereco() {
        return endereco;
    }
    public String getName() {
        return name;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public Long getIdUsuario() {
        return idUsuario;
    } public double getPeso() {
        return peso;
    }
    public double getAltura() {
        return altura;
    }
}
