package com.imc.projetoA3.dto;


import com.imc.projetoA3.entity.Usuario;

public record EnderecoDTO (Long idEndereco,
                           Usuario dataUser,
                           String cep,
                           String logradouro,
                           String complemento) {
}
