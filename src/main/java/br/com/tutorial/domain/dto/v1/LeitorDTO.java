package br.com.tutorial.domain.dto.v1;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.tutorial.domain.entities.Leitor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonPropertyOrder(value = {
		"criadoEm","atualizadoEm","id","nomeCompleto","cpf","dataNascimento","email","telefone","usuario"
})
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeitorDTO {

	private Date criadoEm;
	
	private Date atualizadoEm;
	
	private Long id;
	
	@NotEmpty(message = "O nomeCompleto não pode ser nulo ou vazio ")
	private String nomeCompleto;
	
	@NotEmpty(message = "O Cpf não pode ser nulo ou vazio")
	private String cpf;
	
	private Date dataNascimento;
	
	private String email;
	
	private TelefoneDTO telefone;
	
	private UsuarioDTO usuario;
	
	@Builder
	public LeitorDTO(Leitor leitor) {
		this.criadoEm = leitor.getCriadoEm();
		this.atualizadoEm = leitor.getAtualizadoEm();
		this.id = leitor.getId();
		this.nomeCompleto = leitor.getNomeCompleto();
		this.cpf = leitor.getCpf();
		this.dataNascimento = leitor.getDataNascimento();
		this.email = leitor.getEmail();
		//this.telefone = new TelefoneDTO(leitor.getTelefone());
		this.telefone = TelefoneDTO.map(leitor.getTelefone());
		//this.usuario = new UsuarioDTO(leitor.getUsuario());
		this.usuario = UsuarioDTO.map(leitor.getUsuario());
	}
	
	public static LeitorDTO map(Leitor leitor) {
		return LeitorDTO.builder().leitor(leitor).build();
	}
	
}
