package br.com.tutorial.services.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tutorial.domain.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
	Page<Emprestimo> findByLeitorId(Long leitorId, Pageable pageable);
	
}
