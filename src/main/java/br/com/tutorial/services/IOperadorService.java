package br.com.tutorial.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tutorial.domain.Operador;

public interface IOperadorService {
	
	Operador buscarPorId(Long id);
	
	Page<Operador> listar(Pageable pageable);
	
	Operador criar(Operador operador);
	
	Operador atualizar(Long id, Operador operador);
	
	void removerPorId(Long id);
	
	
}
