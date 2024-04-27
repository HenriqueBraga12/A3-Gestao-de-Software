package com.imc.projetoA3.dto;

import com.core.imcCalculator.entity.Endereco;

public record ListarUsuariosDTO(Long idUsuario,
                                String name,
                                String email,
                                Endereco endereco) {
}
