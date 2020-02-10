package br.com.tutorial.domain.custom.usuario;

import br.com.tutorial.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	private String senhaNova;
	
	private String senhaNovaConfirmacao;
	
	private Usuario usuario;

}
