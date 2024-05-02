package com.imc.projeto.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import com.imc.projeto.dto.ImcValueDto;
import com.imc.projeto.dto.UsuarioDTO;
import com.imc.projeto.entity.RegistroImc;
import com.imc.projeto.entity.Usuario;
import com.imc.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UsuarioServiceIntegrationTest {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ImcCalculatorService imcCalculatorService;
    @Test
    @Transactional
     void testNovoUsuarioComRegistroImc() {
        // Criar dados do usuário
        Usuario usuario = new Usuario();
        usuario.setName("Vinicius");
        usuario.setEmail("vini@example.com");

        // Criar lista de registros IMC
        RegistroImc registroImc = new RegistroImc();
        registroImc.setPeso(70.0);
        registroImc.setAltura(1.75);

        usuario.setRegistroImcList(List.of(registroImc));

        // Chamar método para criar novo usuário
        UsuarioDTO result = usuarioService.novoUsuario(usuario);

        // Verificar se o usuário foi salvo no banco de dados
        assertNotNull(result);
        assertNotNull(result.idUsuario());
        assertThat(result.registroImcList()).isNotEmpty();
        assertThat(result.registroImcList()).hasSize(1);

        // Verificar o valor do IMC
        assertThat(result.registroImcList().get(0).getImc()).isEqualTo(22.857142857142858);
    }



}