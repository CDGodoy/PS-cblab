package br.com.godoydev.PScblab.DTO;

import br.com.godoydev.PScblab.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private String name;
    private String email;
    private String senha;

    public Usuario transformaParaObjeto(){
        return new Usuario(name, email, senha);
    }

}
