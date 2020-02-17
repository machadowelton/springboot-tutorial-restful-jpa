package br.com.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tutorial.domain.entities.Operador;
import br.com.tutorial.services.impls.OperadorServiceImpl;

@RestController
@RequestMapping(value = "/operadores")
public class OperadorController {
	
	@Autowired
	private final OperadorServiceImpl operadorServiceImpl;
	
	
	public OperadorController(final OperadorServiceImpl operadorServiceImpl) {
		this.operadorServiceImpl = operadorServiceImpl;
	}
	
	@GetMapping(value = "/{id}")
	public Operador buscarPorId(@PathVariable("id") Long id) {
		return operadorServiceImpl.buscarPorId(id);
	}
	
	@GetMapping
	public Page<Operador> listar(Pageable pageable) {
		return operadorServiceImpl.listar(pageable);
	}

	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public Operador criar(@RequestBody Operador operador) {
		return operadorServiceImpl.criar(operador);
	}
	
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PutMapping(value = "/{id}")
	public Operador atualizar(
			@PathVariable("id") Long id, @RequestBody Operador operador) {
		return operadorServiceImpl.atualizar(id, operador);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		operadorServiceImpl.removerPorId(id);
	}
	
}
