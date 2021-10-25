package br.com.godoydev.PScblab.controller;

import br.com.godoydev.PScblab.DTO.UsuarioDTO;
import br.com.godoydev.PScblab.DTO.UsuarioResponseDTO;
import br.com.godoydev.PScblab.model.Usuario;
import br.com.godoydev.PScblab.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class UsuarioController {

    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping("/acessoNegado")
    public ModelAndView acessoNegado(){
        ModelAndView mv = new ModelAndView("acessoNegado");
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView acadastraUsuario() {
        ModelAndView mv = new ModelAndView("cadastro");
        return mv;
    }
    /*
    @GetMapping("/todos")
    ResponseEntity<List<UsuarioResponseDTO>> obterUsuarios(){
        return new ResponseEntity<>(UsuarioResponseDTO.transformaListEmDTO(usuarioServices.findAll()), HttpStatus.OK);
    }*/

    @GetMapping("/todos")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("listar");
        mv.addObject(new Usuario());
        mv.addObject("usuarios", usuarioServices.findAll());

        return mv;
    }

    @GetMapping()
    public ModelAndView user(){
        ModelAndView mv = new ModelAndView("usuario");
        mv.addObject(new UsuarioDTO());
        mv.addObject("usuarios",usuarioServices.obtemAtual());
        return mv;
    }


    @PostMapping("/cadastrar")
    public RedirectView cadastraUsuario(@Valid UsuarioDTO dto, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return new RedirectView("/cadastrar");
        }
        usuarioServices.save(dto);
        return new RedirectView("/todos");
    }
/*
    @GetMapping
    ResponseEntity<UsuarioResponseDTO> usuarioAtual(){
        return new ResponseEntity<>(UsuarioResponseDTO.transformaParaDTO(usuarioServices.obtemAtual()),HttpStatus.OK);
    }
*/
    @GetMapping("/{id}")
    ResponseEntity<UsuarioResponseDTO> obterUsuario(@PathVariable Long id){

        return new ResponseEntity<>(UsuarioResponseDTO.transformaParaDTO(usuarioServices.findOne(id)),HttpStatus.ACCEPTED);
    }

}
