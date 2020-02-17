package br.com.tutorial.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tutorial.domain.entities.Sessao;

public interface ISessaoService {
	
	Sessao buscarPorId(Long id);
	
	Page<Sessao> listar(Pageable pageable);
	
	Sessao criar(Sessao sessao);
	
	Sessao atualizar(Long id, Sessao sessao);
	
	void removerPorId(Long id);
	
}
