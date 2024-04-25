package com.core.imccalculator.service;


import com.core.imccalculator.dto.UsuarioDTO;
import com.core.imccalculator.entity.Usuario;
import com.core.imccalculator.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;


    public UsuarioDTO novoUsuario(Usuario usuario) {

        usuarioRepository.save(usuario);

        return new UsuarioDTO(usuario.getIdUsuario(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getEndereco(),
                usuario.getPeso(),
                usuario.getAltura());
    }

    public List<Usuario> listarUsuarios(){

        return usuarioRepository.findAll();
    }
}
