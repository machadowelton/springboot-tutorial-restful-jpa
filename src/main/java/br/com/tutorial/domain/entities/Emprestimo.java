package br.com.tutorial.domain.entities;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.tutorial.domain.audits.AuditModel;
import br.com.tutorial.domain.dto.v1.EmprestimoDTO;
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
@Table(name = "emprestimos")
public class Emprestimo extends AuditModel {

	private static final long serialVersionUID = 5082225834165207009L;
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date dataRetirada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date dataDevolucaoCalculada;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRealDevolucao;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	private Set<Livro> livros = new HashSet<Livro>();
	
	@ManyToOne
	@JoinColumn(name = "leitor_id", referencedColumnName = "id")
	private Leitor leitor;
	
	@ManyToOne
	@JoinColumn(name = "operador_id", referencedColumnName = "id")
	private Operador operador;
	
	public Emprestimo(final Emprestimo emprestimo, final Leitor leitor, final Operador operador, final Set<Livro> livros) {
		this.id = emprestimo.id;
		this.dataRetirada = emprestimo.dataRetirada;
		this.dataDevolucaoCalculada = emprestimo.dataDevolucaoCalculada;
		this.dataRealDevolucao	= emprestimo.dataRealDevolucao;
		this.livros = livros;
		this.leitor = leitor;
		this.operador = operador;
	}
	
	public Emprestimo(final Long id, final Emprestimo emprestimo) {
		this.id = emprestimo.id;
		this.dataRetirada = emprestimo.dataRetirada;
		this.dataDevolucaoCalculada = emprestimo.dataDevolucaoCalculada;
		this.dataRealDevolucao = emprestimo.dataRealDevolucao;
		this.leitor = emprestimo.leitor;
		this.operador = emprestimo.operador;
		this.livros = emprestimo.livros;
	}
	
	public Emprestimo(final EmprestimoDTO emprestimo) {
		this.setCriadoEm(emprestimo.getCriadoEm());
		this.setAtualizadoEm(emprestimo.getAtualizadoEm());
		this.id = emprestimo.getId();
		this.dataRetirada = emprestimo.getDataRetirada();
		this.dataDevolucaoCalculada = emprestimo.getDataDevolucaoCalculada();
		this.dataRealDevolucao = emprestimo.getDataRealDevolucao();
		this.leitor = new Leitor(emprestimo.getLeitor());
		this.operador = new Operador(emprestimo.getOperador());
		this.livros = emprestimo.getLivros().stream().map(Livro::new).collect(Collectors.toSet());		
	}

}
