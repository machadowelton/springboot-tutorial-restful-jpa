package br.com.tutorial.domain.entities;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.tutorial.domain.audits.AuditModel;
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
@Table(name = "sessoes")
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder(value = {
		"id",
		"nome",
		"descricao",
		"localizacao",
		"livros",
		"criadoEm",
		"atualizadoEm"
})
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
	
	@OneToMany(mappedBy = "sessao")
	@JsonIgnore
	private List<Livro> livros;
	
	public Sessao(final Long id, final Sessao sessao) {
		this.id = id;
		this.nome = sessao.nome;
		this.descricao = sessao.descricao;
		this.localizacao = sessao.localizacao;
		if(sessao.livros != null) this.livros = sessao.livros;
	}

}
