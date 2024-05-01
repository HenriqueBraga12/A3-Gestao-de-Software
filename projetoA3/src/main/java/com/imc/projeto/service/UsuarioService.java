package com.imc.projeto.service;



import com.imc.projeto.dto.ImcValueDto;
import com.imc.projeto.dto.UsuarioDTO;
import com.imc.projeto.entity.RegistroImc;
import com.imc.projeto.entity.Usuario;
import com.imc.projeto.repository.RegistroRepository;
import com.imc.projeto.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ImcCalculatorService imcCalculatorService;

    @Autowired
    RegistroRepository registroRepository;


    public UsuarioDTO novoUsuario(Usuario usuario) {

        usuarioRepository.save(usuario);

        for(RegistroImc registroImc: usuario.getRegistroImcList()) {
            ImcValueDto imcValueDto = imcCalculatorService.calculoImc(registroImc.getPeso(), registroImc.getAltura());

            registroImc.setImc(imcValueDto.imc());
            registroImc.setClassificacao(imcValueDto.classificacao());
            registroRepository.save(registroImc);
        }
        return new UsuarioDTO(usuario.getIdUsuario(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getRegistroImcList());
    }

    public void novoRegistroImc(RegistroImc registroImc){

        ImcValueDto imcValueDto = imcCalculatorService.calculoImc(registroImc.getPeso(),registroImc.getAltura());


        Optional<Usuario> optionalUsuario = usuarioRepository.findById( registroImc.getUsuario().getIdUsuario());


        optionalUsuario.ifPresent(usuario -> {
            registroImc.setImc(imcValueDto.imc());
            registroImc.setClassificacao(imcValueDto.classificacao());
            usuario.getRegistroImcList().add(registroImc);
            usuarioRepository.save(usuario);
        });
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
}
