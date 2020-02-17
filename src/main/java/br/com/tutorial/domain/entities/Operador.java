package br.com.tutorial.domain.entities;

import br.com.tutorial.domain.audits.AuditModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operadores")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder(value = {
		"id",
		"nomeCompleto",
		"cpf",
		"dataNascimento",
		"email",
		"usuario",
		"criadoEm",
		"atualizadoEm"
})
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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

}
