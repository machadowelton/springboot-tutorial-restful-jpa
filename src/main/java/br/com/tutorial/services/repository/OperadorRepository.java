package br.com.tutorial.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tutorial.domain.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Long> {

}
