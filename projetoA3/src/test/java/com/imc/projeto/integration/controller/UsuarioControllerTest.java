//package com.imc.projeto.integration.controller;
//
//import com.imc.projeto.dto.UsuarioDTO;
//import com.imc.projeto.entity.RegistroImcUsuario;
//import com.imc.projeto.entity.Usuario;
//import com.imc.projeto.service.UsuarioService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.*;
//
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureTestDatabase
//class UsuarioControllerTest {
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @LocalServerPort
//    private int port;
//
//
//    @MockBean
//    private UsuarioService usuarioService;
//
//
//    @Test
//    @DisplayName("Cria um novo usuário")
//    void novoUsuario() {
//        // Obtenha a data atual
//        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
//
//        // Crie um novo usuário
//        Usuario usuario = new Usuario();
//        usuario.setName("Lucas Souza");
//        usuario.setEmail("usuario@example.com");
//
//        // Crie um novo registro IMC
//        RegistroImcUsuario registroImcUsuario = new RegistroImcUsuario();
//        registroImcUsuario.setImc(null);
//        registroImcUsuario.setClassificacao(null);
//        registroImcUsuario.setDataRegistro(timestamp);
//        registroImcUsuario.setPeso(60.0);
//        registroImcUsuario.setAltura(1.80);
//
//        // Adicione o registro IMC à lista de registros do usuário
//        usuario.setRegistroImcUsuarioList(Collections.singletonList(registroImcUsuario));
//
//        // Enviar a requisição POST
//        ResponseEntity<UsuarioDTO> responseEntity = testRestTemplate.postForEntity("/cadastro", usuario, UsuarioDTO.class);
//
//        // Verificar o código de status da resposta
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//    }
//
//}
