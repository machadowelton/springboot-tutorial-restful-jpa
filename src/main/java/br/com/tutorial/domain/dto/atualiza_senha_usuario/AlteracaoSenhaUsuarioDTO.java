package br.com.tutorial.domain.dto.atualiza_senha_usuario;

import br.com.tutorial.domain.dto.v1.UsuarioDTO;
import br.com.tutorial.domain.entities.Usuario;
import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlteracaoSenhaUsuarioDTO {
	
	private String senhaNova;
	
	private String senhaNovaConfirmacao;
	
	private UsuarioDTO usuario;

}
