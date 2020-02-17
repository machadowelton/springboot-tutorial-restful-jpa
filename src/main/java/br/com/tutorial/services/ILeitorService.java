package br.com.tutorial.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tutorial.domain.entities.Leitor;

public interface ILeitorService {
	
	Leitor buscarPorId(final Long id);
	
	Page<Leitor> listar(final Pageable pageable);
	
	Leitor criar(final Leitor leitor);
	
	Leitor atualizar(final Long id, Leitor leitor);
	
	void removerPorId(final Long id);
	
}
