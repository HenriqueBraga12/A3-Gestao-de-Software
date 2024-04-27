package com.imc.projetoA3.dto;

import com.imc.projetoA3.entity.Endereco;

public record UsuarioDTO(Long idUsuario,
                         String name,
                         String email,
                         String cpf,
                         Endereco endereco,
                         Double peso,
                         Double altura) {

}
