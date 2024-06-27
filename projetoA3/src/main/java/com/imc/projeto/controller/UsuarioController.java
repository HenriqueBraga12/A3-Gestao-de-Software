package com.imc.projeto.controller;



import com.imc.projeto.dto.UsuarioDTO;
import com.imc.projeto.entity.RegistroImcUsuario;
import com.imc.projeto.entity.Usuario;
import com.imc.projeto.service.ImcCalculatorService;
import com.imc.projeto.service.UsuarioService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/cadastro")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final ImcCalculatorService imcCalculatorService;

    public UsuarioController(UsuarioService usuarioService, ImcCalculatorService imcCalculatorService) {
        this.usuarioService = usuarioService;
        this.imcCalculatorService = imcCalculatorService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> novoUsuario(@RequestBody Usuario usuario,
                                                  UriComponentsBuilder uriComponentsBuilder){

        UsuarioDTO usuarioDTO = usuarioService.novoUsuario(usuario);
        var uri = uriComponentsBuilder.path("/cadastro").buildAndExpand(usuarioDTO).toUri();
        return ResponseEntity.created(uri).body(usuarioDTO);
    }

    @PostMapping("{id}")
    public ResponseEntity<UsuarioDTO> novoRegistroImc (@RequestBody RegistroImcUsuario registroImcUsuario,
                                                       @PathVariable Long id,
                                                       UriComponentsBuilder uriComponentsBuilder) throws ChangeSetPersister.NotFoundException {

        UsuarioDTO usuarioDTO = usuarioService.novoRegistroImc(registroImcUsuario, id);


        var uri = uriComponentsBuilder.path("/usuario").buildAndExpand(usuarioDTO).toUri();
        return  ResponseEntity.created(uri).body(usuarioDTO);
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> listarUsuarios (){
        List<Usuario> usuarioList = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarioList);
    }



}
