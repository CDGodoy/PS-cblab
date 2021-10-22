package br.com.godoydev.PScblab.DTO;

import br.com.godoydev.PScblab.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String name;
    private String email;
    private boolean superUser;

    public static UsuarioResponseDTO transformaParaDTO(Usuario usuario){
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.isSuperUser());
    }
    public static List<UsuarioResponseDTO> transformaListEmDTO(List<Usuario> usuarios){
        List<UsuarioResponseDTO> dtos = new ArrayList<>();

        for (Usuario usuario:
            usuarios){
            dtos.add(transformaParaDTO(usuario));
        }
        return dtos;
    }

}
