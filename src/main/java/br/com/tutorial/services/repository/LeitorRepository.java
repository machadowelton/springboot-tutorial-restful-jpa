package br.com.tutorial.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tutorial.domain.entities.Leitor;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {	
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);
}
