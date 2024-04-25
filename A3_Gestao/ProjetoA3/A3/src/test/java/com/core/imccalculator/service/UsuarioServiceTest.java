package com.core.imccalculator.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.core.imccalculator.dto.UsuarioDTO;
import com.core.imccalculator.entity.Endereco;
import com.core.imccalculator.entity.Usuario;
import com.core.imccalculator.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

 class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    public UsuarioServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testNovoUsuario_ComDadosValidos() {
        // Cria um objeto Usuario com dados válidos
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setName("João Silva");
        usuario.setEmail("joao.silva@example.com");
        usuario.setCpf("123.456.789-00");
        usuario.setEndereco(new Endereco());
        usuario.setPeso(70.0);
        usuario.setAltura(1.75);

        // Mock do método save do repositório
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Chama o método a ser testado
        UsuarioDTO usuarioDTO = usuarioService.novoUsuario(usuario);

        // Verifica se o retorno é o esperado
        assertNotNull(usuarioDTO);
        assertEquals(usuario.getIdUsuario(), usuarioDTO.getIdUsuario());
        assertEquals(usuario.getName(), usuarioDTO.getName());
        assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
        assertEquals(usuario.getCpf(), usuarioDTO.getCpf());
        assertEquals(usuario.getEndereco(), usuarioDTO.getEndereco());
        assertEquals(usuario.getPeso(), usuarioDTO.getPeso());
        assertEquals(usuario.getAltura(), usuarioDTO.getAltura());

        // Verifica se o método save foi chamado uma vez com o objeto correto
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void testNovoUsuario_ComExcecaoAoSalvar() {
        // Cria um objeto Usuario com dados válidos
        Usuario usuario = new Usuario();
        usuario.setName("João Silva");

        // Simula uma exceção ao salvar no repositório
        when(usuarioRepository.save(any(Usuario.class))).thenThrow(new RuntimeException("Erro ao salvar"));

        // Testa se a exceção é lançada pelo método
        Exception exception = assertThrows(RuntimeException.class, () -> {
            usuarioService.novoUsuario(usuario);
        });

        assertEquals("Erro ao salvar", exception.getMessage());

        // Verifica se o método save foi chamado uma vez com o objeto correto
        verify(usuarioRepository, times(1)).save(usuario);
    }
}
