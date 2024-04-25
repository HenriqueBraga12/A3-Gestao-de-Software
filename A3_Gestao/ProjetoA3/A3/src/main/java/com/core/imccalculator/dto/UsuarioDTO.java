package com.core.imccalculator.dto;

import com.core.imccalculator.entity.Endereco;

public record UsuarioDTO(Long idUsuario,
                         String name,
                         String email,
                         String cpf,
                         Endereco endereco,
                         Double peso,
                         Double altura) {

}
