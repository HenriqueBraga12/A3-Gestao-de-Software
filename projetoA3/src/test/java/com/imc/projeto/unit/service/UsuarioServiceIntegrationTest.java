//package com.imc.projeto.unit.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.assertj.core.api.Assertions.*;
//
//import com.imc.projeto.dto.UsuarioDTO;
//import com.imc.projeto.entity.RegistroImcUsuario;
//import com.imc.projeto.entity.Usuario;
//import com.imc.projeto.repository.UsuarioRepository;
//import com.imc.projeto.service.ImcCalculatorService;
//import com.imc.projeto.service.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.api.Test;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@SpringBootTest
//class UsuarioServiceIntegrationTest {
//
//    @Autowired
//    UsuarioService usuarioService;
//
//    @Autowired
//    UsuarioRepository usuarioRepository;
//
//    @Autowired
//    ImcCalculatorService imcCalculatorService;
//    @Test
//    @Transactional
//     void testNovoUsuarioComRegistroImc() {
//        // Criar dados do usuário
//        Usuario usuario = new Usuario();
//        usuario.setName("Vinicius");
//        usuario.setEmail("vini@example.com");
//
//        // Criar lista de registros IMC
//        RegistroImcUsuario registroImcUsuario = new RegistroImcUsuario();
//        registroImcUsuario.setPeso(70.0);
//        registroImcUsuario.setAltura(1.75);
//
//        usuario.setRegistroImcUsuarioList(List.of(registroImcUsuario));
//
//        // Chamar método para criar novo usuário
//        UsuarioDTO result = usuarioService.novoUsuario(usuario);
//
//        // Verificar se o usuário foi salvo no banco de dados
//        assertNotNull(result);
//        assertNotNull(result.idUsuario());
//        assertThat(result.registroImcUsuarioList()).isNotEmpty();
//        assertThat(result.registroImcUsuarioList()).hasSize(1);
//
//        // Verificar o valor do IMC
//        assertThat(result.registroImcUsuarioList().get(0).getImc()).isEqualTo(22.857142857142858);
//    }
//
//
//
//}