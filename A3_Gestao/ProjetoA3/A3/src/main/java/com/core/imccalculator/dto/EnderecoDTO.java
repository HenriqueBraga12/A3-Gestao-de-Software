package com.core.imccalculator.dto;


import com.core.imccalculator.entity.Usuario;

public record EnderecoDTO (Long idEndereco,
                           Usuario dataUser,
                           String cep,
                           String logradouro,
                           String complemento) {
}
