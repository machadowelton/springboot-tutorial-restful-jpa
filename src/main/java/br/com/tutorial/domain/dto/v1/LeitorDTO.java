package br.com.tutorial.domain.dto.v1;

import java.util.Date;

import br.com.tutorial.domain.dto.v1.embs.TelefoneDTO;
import br.com.tutorial.domain.entities.Leitor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeitorDTO {

	private Date criadoEm;
	
	private Date atualizadoEm;
	
	private Long id;
	
	private String nomeCompleto;
	
	private String cpf;
	
	private Date dataNascimento;
	
	private String email;
	
	private TelefoneDTO telefone;
	
	private UsuarioDTO usuario;
	
	public LeitorDTO(Leitor leitor) {
		this.criadoEm = leitor.getCriadoEm();
		this.atualizadoEm = leitor.getAtualizadoEm();
		this.id = leitor.getId();
		this.nomeCompleto = leitor.getNomeCompleto();
		this.cpf = leitor.getCpf();
		this.dataNascimento = leitor.getDataNascimento();
		this.email = leitor.getEmail();
		this.telefone = new TelefoneDTO(leitor.getTelefone());
		this.usuario = new UsuarioDTO(leitor.getUsuario());
	}
	
}
