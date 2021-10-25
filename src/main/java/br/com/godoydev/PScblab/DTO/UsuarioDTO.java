package br.com.godoydev.PScblab.DTO;

import br.com.godoydev.PScblab.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;

    public Usuario transformaParaObjeto(){
        return new Usuario(nome, email, senha);
    }

}
