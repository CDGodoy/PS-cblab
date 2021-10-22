package br.com.godoydev.PScblab;

import br.com.godoydev.PScblab.model.Usuario;
import br.com.godoydev.PScblab.repository.UsuarioRepository;
import br.com.godoydev.PScblab.services.UsuarioServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

    @TestConfiguration
    static class UsuarioServiceTestConfiguration{

        @Bean
        public UsuarioServices usuarioServices(){
            return new UsuarioServices();
        }
    }

    @Autowired
    UsuarioServices usuarioServices;

    @MockBean
    UsuarioRepository usuarioRepository;

    @Before
    public void setup(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 =  new Usuario();
        usuario1.setId(1L);
        usuario1.setNome("Admin");
        usuario1.setEmail("admin@admin.com");
        usuario1.setSenha("admin");
        usuario1.setSuperUser(true);

        Usuario usuario2 =  new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("usuario");
        usuario2.setEmail("usuario@usuario.com");
        usuario2.setSenha("usuario");
        usuario2.setSuperUser(false);

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Mockito.when(usuarioRepository.findAll())
                .thenReturn(usuarios);

    }

    @Test
    public void usuarioServiceGET(){
        List<Usuario> usuariosExpected = new ArrayList<>();
        Usuario usuario1 =  new Usuario();
        usuario1.setId(1L);
        usuario1.setNome("Admin");
        usuario1.setEmail("admin@admin.com");
        usuario1.setSuperUser(true);

        Usuario usuario2 =  new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("usuario");
        usuario2.setEmail("usuario@usuario.com");
        usuario2.setSuperUser(false);

        usuariosExpected.add(usuario1);
        usuariosExpected.add(usuario2);

        List<Usuario> usuariosObtidos = usuarioServices.findAll();


        Assertions.assertEquals(usuariosObtidos, usuariosExpected);
    }


}
