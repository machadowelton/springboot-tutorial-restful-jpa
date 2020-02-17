package br.com.tutorial.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tutorial.domain.entities.Emprestimo;

public interface IEmprestimoService {
	
	
	Emprestimo buscarPorId(Long id);
	
	Page<Emprestimo> listar(Pageable pageable);
	
	Emprestimo criar(Emprestimo emprestimo);
	
	Emprestimo atualizar(Long id, Emprestimo emprestimo);
	
	void removerPorId(Long id);	
	
	Page<Emprestimo> listarPorLeitorId(Long idLeitor, Pageable pageable);
	
}
