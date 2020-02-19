package br.com.tutorial.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.tutorial.domain.audits.AuditModel;
import br.com.tutorial.domain.dto.v1.LeitorDTO;
import br.com.tutorial.domain.embs.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "leitores")
public class Leitor extends AuditModel {

	private static final long serialVersionUID = 2936654437260510401L;
	
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private Long id;
	
	@NotNull
	private String nomeCompleto;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	@Column(unique = true)
	private String cpf;
	
	@Temporal(TemporalType.TIMESTAMP)	
	private Date dataNascimento;
	
	@Embedded
	private Telefone telefone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	public Leitor(Long id, Leitor leitor) {
		this.id = id;
		this.nomeCompleto = leitor.nomeCompleto;
		this.cpf = leitor.cpf;
		this.email = leitor.email;
		this.dataNascimento = leitor.dataNascimento;
		this.telefone = leitor.telefone;
		if(leitor.usuario != null) this.usuario = leitor.usuario;
	}
	
	public Leitor(final Leitor leitor, final Usuario usuario) {
		this.nomeCompleto = leitor.nomeCompleto;
		this.cpf = leitor.cpf;
		this.email = leitor.email;
		this.dataNascimento = leitor.dataNascimento;
		this.telefone = leitor.telefone;
		this.usuario = usuario;
	}
	
	public Leitor(final LeitorDTO leitor) {
		this.setCriadoEm(leitor.getCriadoEm());
		this.setAtualizadoEm(leitor.getAtualizadoEm());
		this.nomeCompleto = leitor.getNomeCompleto();
		this.cpf = leitor.getCpf();
		this.email = leitor.getEmail();
		this.dataNascimento = leitor.getDataNascimento();
		this.telefone = new Telefone(leitor.getTelefone());
		this.usuario = new Usuario(leitor.getUsuario());
	}
	
}
