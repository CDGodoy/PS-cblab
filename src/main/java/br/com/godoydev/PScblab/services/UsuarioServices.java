package br.com.godoydev.PScblab.services;

import br.com.godoydev.PScblab.DTO.UsuarioDTO;
import br.com.godoydev.PScblab.model.Usuario;
import br.com.godoydev.PScblab.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {

    @Autowired
    UsuarioRepository usuarioRepository;


    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario insertUser(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioDTO.transformaParaObjeto();
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario findOne(Long id){
        return usuarioRepository.findById(id).get();

    }
}
