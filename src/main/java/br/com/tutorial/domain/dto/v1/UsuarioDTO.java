package br.com.tutorial.domain.dto.v1;

import java.util.Date;

import br.com.tutorial.domain.entities.Usuario;
import br.com.tutorial.domain.enums.EPermissao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	private Date criadoEm;
	
	private Date atualizadoEm;
	
	private Long id;
	
	private String codLogin;
	
	private String senha;
	
	private EPermissao permissao;
	
	public UsuarioDTO(Usuario usuario) {
		this.criadoEm = usuario.getCriadoEm();
		this.atualizadoEm = usuario.getAtualizadoEm();
		this.id  = usuario.getId();
		this.codLogin = usuario.getCodLogin();
		this.senha = usuario.getSenha();
		this.permissao = usuario.getPermissao();
	}
	
}
