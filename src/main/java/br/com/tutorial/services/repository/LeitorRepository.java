package br.com.tutorial.services.repository;

import br.com.tutorial.domain.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {	
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);
}
