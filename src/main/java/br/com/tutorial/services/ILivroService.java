package br.com.tutorial.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tutorial.domain.entities.Livro;

public interface ILivroService {
	
	
	Livro buscarPorIdESessaoId(Long id, Long sessaoId);
	
	Page<Livro> listarPorSessaoId(Long sessaoId, Pageable pageable);
	
	Livro criar(Long sessaoId, Livro livro);
	
	Livro atualizar(Long id, Long sessaoId, Livro livro);
	
	void removerPorIdESessaoId(Long id, Long sessaoId);
	
}
