package br.com.tutorial.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import br.com.tutorial.domain.dto.v1.OperadorDTO;
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
@Table(name = "operadores")
public class Operador extends AuditModel {

	private static final long serialVersionUID = -2512081201290581538L;
		
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	public Operador(final Usuario usuario, final Operador operador) {
		this.nomeCompleto = operador.nomeCompleto;
		this.email = operador.email;
		this.cpf = operador.cpf;
		this.dataNascimento = operador.dataNascimento;
		this.usuario = usuario;
	}
	
	public Operador(final Long id, final Operador operador) {
		this.id = id;
		this.nomeCompleto = operador.nomeCompleto;
		this.email = operador.email;
		this.cpf = operador.cpf;
		this.dataNascimento = operador.dataNascimento;
		this.usuario = operador.getUsuario();
	}
	
	@Builder
	public Operador(final OperadorDTO operador) {
		this.setCriadoEm(operador.getCriadoEm());
		this.setAtualizadoEm(operador.getAtualizadoEm());
		this.id = operador.getId();
		this.nomeCompleto = operador.getNomeCompleto();
		this.cpf = operador.getCpf();
		this.dataNascimento = operador.getDatNascimento();
		this.email = operador.getEmail();
		this.usuario = new Usuario(operador.getUsuario());
	}
	
	public static Operador map(final OperadorDTO operador) {
		return Operador.builder().operador(operador).build();
	}

}
