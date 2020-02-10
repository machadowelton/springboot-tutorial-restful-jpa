package br.com.tutorial.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tutorial.domain.Leitor;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {	
	
}
