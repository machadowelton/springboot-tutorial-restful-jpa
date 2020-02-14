package br.com.tutorial.services.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tutorial.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	
	boolean existsByIdAndSessaoId(Long id, Long sessaoId);
	
	Optional<Livro> findByIdAndSessaoId(Long id, Long sessaoId);
	
	Page<Livro> findBySessaoId(Long sessaoId, Pageable pageable);
	
	void deleteByIdAndSessaoId(Long id, Long sessaoId);

	
}
