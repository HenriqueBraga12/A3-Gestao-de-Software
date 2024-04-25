package com.core.imccalculator.dto;

import com.core.imccalculator.entity.Endereco;

public record ListarUsuariosDTO(Long idUsuario,
                                String name,
                                String email,
                                Endereco endereco) {
}
