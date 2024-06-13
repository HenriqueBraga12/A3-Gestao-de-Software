package com.imc.projeto.controller;



import com.imc.projeto.dto.UsuarioDTO;
import com.imc.projeto.entity.Usuario;
import com.imc.projeto.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@RestController
@RequestMapping("/cadastro")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> novoUsuario(@RequestBody Usuario usuario,
                                                  UriComponentsBuilder uriComponentsBuilder){

        UsuarioDTO usuarioDTO = usuarioService.novoUsuario(usuario);
        var uri = uriComponentsBuilder.path("/cadastro").buildAndExpand(usuarioDTO).toUri();
        return ResponseEntity.created(uri).body(usuarioDTO);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios (){

        List<Usuario> usuarioList = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarioList);
    }
}
