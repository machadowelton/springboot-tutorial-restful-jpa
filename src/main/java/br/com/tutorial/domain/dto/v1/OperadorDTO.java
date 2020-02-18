package br.com.tutorial.domain.dto.v1;

import java.util.Date;

import br.com.tutorial.domain.entities.Operador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperadorDTO {
	
	private Date criadoEm;
	
	private Date atualizadoEm;
	
	private Long id;
	
	private String nomeCompleto;
	
	private String cpf;
	
	private String email;
	
	private Date datNascimento;
	
	private UsuarioDTO usuario;
	
	public OperadorDTO(Operador operador) {
		this.criadoEm = operador.getCriadoEm();
		this.atualizadoEm = operador.getAtualizadoEm();
		this.id = operador.getId();
		this.nomeCompleto = operador.getNomeCompleto();
		this.cpf = operador.getCpf();
		this.email = operador.getEmail();
		this.datNascimento = operador.getDataNascimento();
		this.usuario = new UsuarioDTO(operador.getUsuario());
	}
	
}
