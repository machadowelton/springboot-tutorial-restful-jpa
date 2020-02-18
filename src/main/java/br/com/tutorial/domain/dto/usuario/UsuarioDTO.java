package br.com.tutorial.domain.dto.usuario;

import br.com.tutorial.domain.entities.Usuario;
import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	private String senhaNova;
	
	private String senhaNovaConfirmacao;
	
	private Usuario usuario;

}
