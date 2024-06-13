package com.imc.projeto.unit.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.imc.projeto.dto.ImcValueDto;
import com.imc.projeto.dto.UsuarioDTO;
import com.imc.projeto.entity.RegistroImc;
import com.imc.projeto.entity.Usuario;
import com.imc.projeto.repository.RegistroRepository;
import com.imc.projeto.repository.UsuarioRepository;
import com.imc.projeto.service.ImcCalculatorService;
import com.imc.projeto.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioServiceTest {

    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    ImcCalculatorService imcCalculatorService;

    @Mock
    RegistroRepository registroRepository;

    @InjectMocks
    UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    public void testNovoUsuario() {
        // Instaciando um usuário e colocando atributos nele
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setName("Henrique");
        usuario.setEmail("Henrique@gmail.com");

        // Listar de registros IMC
        RegistroImc registro1 = new RegistroImc();
        registro1.setPeso(70.0);
        registro1.setAltura(1.75);

        List<RegistroImc> registroImcList = new ArrayList<>();
        registroImcList.add(registro1);

        usuario.setRegistroImcList(registroImcList);

        // Simula o cálculo do IMC
        ImcValueDto imcValueDto = new ImcValueDto(22.86, "Normal");
        when(imcCalculatorService.calculoImc(70.0, 1.75)).thenReturn(imcValueDto);

        // Simula a ação de salvar um usuário
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Testa o método
        UsuarioDTO result = usuarioService.novoUsuario(usuario);

        assertNotNull(result);
        assertEquals("Henrique", result.name());
        assertEquals("Henrique@gmail.com", result.email());
        assertNotNull(result.registroImcList());
        assertEquals(1, result.registroImcList().size());

        // Verifica se os métodos de repositórios foram chamados
        verify(usuarioRepository).save(any(Usuario.class));
        verify(registroRepository).save(any(RegistroImc.class));
    }

    @Test
    @Transactional
    public void testNovoUsuarioSemRegistroImc() {
        // Dados do usuário sem registros de IMC
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2L);
        usuario.setName("Jane Doe");
        usuario.setEmail("jane@example.com");
        usuario.setRegistroImcList(new ArrayList<>());

        // Simula a ação de salvar um usuário
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Testa o método
        UsuarioDTO result = usuarioService.novoUsuario(usuario);

        assertNotNull(result);
        assertEquals("Jane Doe", result.name());
        assertEquals("jane@example.com", result.email());
        assertTrue(result.registroImcList().isEmpty()); // Sem registros de IMC

        // Verifica se o repositório de usuários foi chamado
        verify(usuarioRepository).save(any(Usuario.class));
        verify(registroRepository, never()).save(any(RegistroImc.class));
    }

    @Test
    public void testNovoRegistroImcComUsuarioExistente() {

        // Instaciando e atribuindo um usuário e criando um registro IMC para adicionar ao usuário
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setName("Marcos Cruz");
        usuario.setEmail("Guiguizinho@uol.com");
        usuario.setRegistroImcList(new ArrayList<>());
        RegistroImc registroImc = new RegistroImc();
        registroImc.setPeso(70.0);
        registroImc.setAltura(1.75);
        registroImc.setUsuario(usuario);

        // Simulando o cálculo do IMC
        ImcValueDto imcValueDto = new ImcValueDto(22.86, "Peso normal");
        when(imcCalculatorService.calculoImc(70.0, 1.75)).thenReturn(imcValueDto);

        // Simulando se encontra o usuário no repositório
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        // Chamando o método a ser testado
        usuarioService.novoRegistroImc(registroImc);

        // Verificando se o IMC foi calculado e a classificação foi atribuída
        assertEquals(22.86, registroImc.getImc());
        assertEquals("Peso normal", registroImc.getClassificacao());

        // Verificar se o registro IMC foi adicionado ao usuário
        assertEquals(1, usuario.getRegistroImcList().size());
        assertSame(registroImc, usuario.getRegistroImcList().get(0));

        // Verificar se o repositório de usuários foi chamado para salvar
        verify(usuarioRepository).save(usuario);
    }

    @Test
    public void testNovoRegistroImcComUsuarioInexistente() {

        // Criando um registro IMC para um usuário inexistente
        Usuario usuarioInexistente = new Usuario();
        usuarioInexistente.setIdUsuario(99L);
        RegistroImc registroImc = new RegistroImc();
        registroImc.setPeso(70.0);
        registroImc.setAltura(1.75);
        registroImc.setUsuario(usuarioInexistente);

        // Simular o cálculo do IMC
        ImcValueDto imcValueDto = new ImcValueDto(22.86, "Peso normal");
        when(imcCalculatorService.calculoImc(70.0, 1.75)).thenReturn(imcValueDto);

        // Simular não encontrar o usuário no repositório
        when(usuarioRepository.findById(99L)).thenReturn(Optional.empty());

        // Chamar o método a ser testado
        usuarioService.novoRegistroImc(registroImc);

        // Verificar se o repositório de usuários não foi chamado para salvar
        verify(usuarioRepository, never()).save(any(Usuario.class));
    }

}

