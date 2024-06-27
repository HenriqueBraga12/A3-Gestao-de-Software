package com.imc.projeto.dto;

import com.imc.projeto.entity.RegistroImcUsuario;

import java.util.List;

public record UsuarioDTO(Long idUsuario,
                         String name,
                         String email,
                         List<RegistroImcUsuario> registroImcUsuarioList) {

}
