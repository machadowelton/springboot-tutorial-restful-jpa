package br.com.tutorial.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.tutorial.domain.audits.AuditModel;
import br.com.tutorial.domain.enums.EStatusLivro;
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
@Entity
@Table(name = "livros")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder(value = {
		"id",
		"titulo",
		"sinopse",
		"autor",
		"dataLancamento",
		"emprestimos",
		"status",
		"criadoEm",
		"atualizadoEm"
})
public class Livro extends AuditModel {

	private static final long serialVersionUID = -7359271269535007899L;
	
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
	
	private String titulo;
	
	@Lob
	private String sinopse;
	
	private String autor;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataLancamento;
	
	@Enumerated(EnumType.STRING)
	private EStatusLivro status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sessao_id", referencedColumnName = "id")
	@JsonIgnore
	private Sessao sessao;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
	@JoinTable(
			name = "emprestimos_livros",
			joinColumns = @JoinColumn(name = "livro_id"),
			inverseJoinColumns = @JoinColumn(name = "emprestimo_id")
			)	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Set<Emprestimo> emprestimos = new HashSet<Emprestimo>();
	
	public Livro(final Sessao sessao, final Livro livro) {
		this.titulo = livro.titulo;
		this.sinopse = livro.sinopse;
		this.autor = livro.autor;
		this.dataLancamento = livro.dataLancamento;
		this.status = livro.status;
		this.sessao = sessao;
	}
	
	public Livro(final Long id, final Sessao sessao, final Livro livro) {
		this.id = id;
		this.titulo = livro.titulo;
		this.sinopse = livro.sinopse;
		this.autor = livro.autor;
		this.dataLancamento = livro.dataLancamento;
		this.status = livro.status;
		this.sessao = sessao;
	}
	
	public Livro(final Livro livro, final Set<Emprestimo> emprestimos) {
		this.id = livro.id;
		this.titulo = livro.titulo;
		this.sinopse = livro.sinopse;
		this.autor = livro.autor;
		this.dataLancamento = livro.dataLancamento;
		this.status = livro.status;
		this.emprestimos = emprestimos;
	}

}
