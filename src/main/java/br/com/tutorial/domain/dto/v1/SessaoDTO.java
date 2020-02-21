package br.com.tutorial.domain.dto.v1;

import java.util.Date;

import br.com.tutorial.domain.entities.Sessao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoDTO {
	
	private Date criadoEm;
	
	private Date atualizadoEm;
	
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private String localizacao;
	
	private int quantidadeLivros;
	
	@Builder
	public SessaoDTO(Sessao sessao) {
		this.criadoEm = sessao.getCriadoEm();
		this.atualizadoEm = sessao.getAtualizadoEm();
		this.id = sessao.getId();
		this.nome = sessao.getNome();
		this.descricao = sessao.getDescricao();
		this.localizacao = sessao.getLocalizacao();
		this.quantidadeLivros = sessao.getLivros() != null ?  sessao.getLivros().size() : 0;
	}
	
	public static SessaoDTO map(Sessao sessao) {
		return SessaoDTO.builder()
					.sessao(sessao)
					.build();
	}
	
	
	
}
