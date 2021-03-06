package br.com.tutorial.domain.dto.v1;

import java.util.Date;

import br.com.tutorial.domain.entities.Livro;
import br.com.tutorial.domain.enums.EStatusLivro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
	
	private Date criadoEm;
	
	private Date atualizadoEm;
	
	private Long id;
	
	private String titulo;
	
	private String sinopse;
	
	private String autor;
	
	private Date dataLancamento;
	
	private EStatusLivro status;
	
	private SessaoDTO sessao;
	
	@Builder
	public LivroDTO(Livro livro) {
		this.criadoEm = livro.getCriadoEm();
		this.atualizadoEm = livro.getAtualizadoEm();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.dataLancamento = livro.getDataLancamento();
		this.status = livro.getStatus();
		this.sessao = new SessaoDTO(livro.getSessao());
	}
	
	public static LivroDTO map(final Livro livro) {
		return LivroDTO.builder().livro(livro).build();
	}
	
}
