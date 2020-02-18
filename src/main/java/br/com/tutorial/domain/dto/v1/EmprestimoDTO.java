package br.com.tutorial.domain.dto.v1;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.tutorial.domain.entities.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {
	
	private Date criadoEm;
	
	private Date atualizadoEm;
	
	private Long id;
	
	private Date dataRetirada;
	
	private Date dataDevolucacaoCalculada;
	
	private Date dataDevolucacaoReal;
	
	private OperadorDTO operador;
	
	private LeitorDTO leitor;
	
	private Set<LivroDTO> livros;
	
	public EmprestimoDTO(Emprestimo emprestimo) {
		this.criadoEm = emprestimo.getCriadoEm();
		this.atualizadoEm = emprestimo.getAtualizadoEm();
		this.id = emprestimo.getId();
		this.dataRetirada = emprestimo.getDataRetirada();
		this.dataDevolucacaoCalculada = emprestimo.getDataDevolucaoCalculada();
		this.dataDevolucacaoReal = emprestimo.getDataRealDevolucao();
		this.operador = new OperadorDTO(emprestimo.getOperador());
		this.leitor = new LeitorDTO(emprestimo.getLeitor());
		this.livros = emprestimo.getLivros().stream().map(m -> new LivroDTO(m)).collect(Collectors.toSet());
	}
	
}
