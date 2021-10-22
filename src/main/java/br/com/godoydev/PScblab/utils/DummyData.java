package br.com.godoydev.PScblab.utils;

import br.com.godoydev.PScblab.model.Usuario;
import br.com.godoydev.PScblab.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    UsuarioRepository usuarioRepository;

    //@PostConstruct
    public void saveUsers(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 =  new Usuario();
        usuario1.setNome("testeADM");
        usuario1.setEmail("teste2@admin.com");
        usuario1.setSenha(new BCryptPasswordEncoder().encode("admin"));
        usuario1.setSuperUser(true);

        Usuario usuario2 =  new Usuario();
        usuario2.setNome("testeUSER");
        usuario2.setEmail("user2@usuario.com");
        usuario2.setSenha(new BCryptPasswordEncoder().encode("usuario"));
        usuario2.setSuperUser(false);

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        for (Usuario usuario : usuarios){
            Usuario usuarioSalvo = usuarioRepository.save(usuario);
            System.out.println(usuarioSalvo.getId());
        }

    }

}
