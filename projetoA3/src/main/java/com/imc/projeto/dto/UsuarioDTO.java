package com.imc.projeto.dto;

import com.imc.projeto.entity.RegistroImc;

import java.util.List;

public record UsuarioDTO(Long idUsuario,
                         String name,
                         String email,
                         List<RegistroImc> registroImcList) {

}
