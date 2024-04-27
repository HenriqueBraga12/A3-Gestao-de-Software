package com.imc.projetoA3.dto;

import com.imc.projetoA3.entity.Endereco;

public record ListarUsuariosDTO(Long idUsuario,
                                String name,
                                String email,
                                Endereco endereco) {
}
