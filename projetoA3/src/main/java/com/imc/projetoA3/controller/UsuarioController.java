package com.imc.projetoA3.controller;



import com.imc.projetoA3.dto.UsuarioDTO;
import com.imc.projetoA3.entity.Usuario;
import com.imc.projetoA3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@RestController
@RequestMapping("/cadastro")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

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
