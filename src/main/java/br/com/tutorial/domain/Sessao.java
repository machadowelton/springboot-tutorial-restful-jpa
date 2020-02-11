package br.com.tutorial.domain;

import br.com.tutorial.domain.audits.AuditModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessoes")
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Sessao extends AuditModel {

	private static final long serialVersionUID = 2349900725868829355L;
	

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
	private String nome;
	
	private String descricao;
	
	private String localizacao;

}
