package br.com.godoydev.PScblab.controller;

import br.com.godoydev.PScblab.DTO.UsuarioDTO;
import br.com.godoydev.PScblab.DTO.UsuarioResponseDTO;

import br.com.godoydev.PScblab.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping("/todos")
    ResponseEntity<List<UsuarioResponseDTO>> obterUsuarios(){
        return new ResponseEntity<>(UsuarioResponseDTO.transformaListEmDTO(usuarioServices.findAll()), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UsuarioResponseDTO> inserirUsuario(@RequestBody UsuarioDTO usuariodto){
        return new ResponseEntity<>(UsuarioResponseDTO.transformaParaDTO(usuarioServices.insertUser(usuariodto)), HttpStatus.ACCEPTED);
    }

    @GetMapping
    ResponseEntity<UsuarioResponseDTO> usuarioAtual(){
        return new ResponseEntity<>(UsuarioResponseDTO.transformaParaDTO(usuarioServices.obtemAtual()),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<UsuarioResponseDTO> obterUsuario(@PathVariable Long id){

        return new ResponseEntity<>(UsuarioResponseDTO.transformaParaDTO(usuarioServices.findOne(id)),HttpStatus.ACCEPTED);
    }

}
