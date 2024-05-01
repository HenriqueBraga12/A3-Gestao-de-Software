package com.imc.projeto.dto;


import com.imc.projeto.entity.Usuario;

public record EnderecoDTO (Long idEndereco,
                           Usuario dataUser,
                           String cep,
                           String logradouro,
                           String complemento) {
}
