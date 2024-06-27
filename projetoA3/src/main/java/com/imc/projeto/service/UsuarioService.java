package com.imc.projeto.service;


import com.imc.projeto.dto.ImcValueDto;
import com.imc.projeto.dto.UsuarioDTO;
import com.imc.projeto.entity.RegistroImcUsuario;
import com.imc.projeto.entity.Usuario;
import com.imc.projeto.repository.RegistroRepository;
import com.imc.projeto.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ImcCalculatorService imcCalculatorService;
    private final RegistroRepository registroRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, ImcCalculatorService imcCalculatorService, RegistroRepository registroRepository) {
        this.usuarioRepository = usuarioRepository;
        this.imcCalculatorService = imcCalculatorService;
        this.registroRepository = registroRepository;
    }

    @Transactional
    public UsuarioDTO novoUsuario(Usuario usuario) {


            try {
                if(usuario != null){
                    RegistroImcUsuario registroImcUsuario = usuario.getRegistroImcUsuarioList().get(0);
                    ImcValueDto imcValueDto = imcCalculatorService.calculoImc(registroImcUsuario.getPeso(), registroImcUsuario.getAltura());
                    registroImcUsuario.setImc(imcValueDto.imc());
                    registroImcUsuario.setClassificacao(imcValueDto.classificacao());
                    registroImcUsuario.setUsuario(usuario);
                    usuarioRepository.save(usuario);

                    return new UsuarioDTO(usuario.getIdUsuario(),
                            usuario.getName(),
                            usuario.getEmail(),
                            usuario.getRegistroImcUsuarioList());
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return null;
    }

    @Transactional
    public UsuarioDTO novoRegistroImc(RegistroImcUsuario registroImcUsuario, Long id) throws ChangeSetPersister.NotFoundException {
        log.info(registroImcUsuario.toString());
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        try {
            if (usuario != null) {
                ImcValueDto imcValueDto = imcCalculatorService.calculoImc(registroImcUsuario.getPeso(), registroImcUsuario.getAltura());
                registroImcUsuario.setDataRegistro(timestamp);
                registroImcUsuario.setImc(imcValueDto.imc());
                registroImcUsuario.setClassificacao(imcValueDto.classificacao());
                registroImcUsuario.setUsuario(usuario);

                usuario.getRegistroImcUsuarioList().add(registroImcUsuario);
                usuarioRepository.save(usuario);

                return new UsuarioDTO(usuario.getIdUsuario(),
                        usuario.getName(),
                        usuario.getEmail(),
                        usuario.getRegistroImcUsuarioList());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar usuários ", e);
        }
    }
}
