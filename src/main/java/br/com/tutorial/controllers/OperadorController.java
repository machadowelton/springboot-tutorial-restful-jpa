package br.com.tutorial.controllers;

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

import br.com.tutorial.domain.dto.v1.OperadorDTO;
import br.com.tutorial.domain.entities.Operador;
import br.com.tutorial.services.impls.OperadorServiceImpl;

@RestController
@RequestMapping(value = "/operadores")
public class OperadorController {
	
	private final OperadorServiceImpl operadorServiceImpl;
	
	
	public OperadorController(final OperadorServiceImpl operadorServiceImpl) {
		this.operadorServiceImpl = operadorServiceImpl;
	}
	
	@GetMapping(value = "/{id}")
	public OperadorDTO buscarPorId(@PathVariable("id") Long id) {
		return new OperadorDTO(operadorServiceImpl.buscarPorId(id));
	}
	
	@GetMapping
	public Page<OperadorDTO> listar(Pageable pageable) {
		return operadorServiceImpl.listar(pageable).map(OperadorDTO::new);
	}

	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public OperadorDTO criar(@RequestBody OperadorDTO operador) {
		return new OperadorDTO(operadorServiceImpl.criar(new Operador(operador)));
	}
	
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PutMapping(value = "/{id}")
	public OperadorDTO atualizar(
			@PathVariable("id") Long id, @RequestBody OperadorDTO operador) {
		return new OperadorDTO(operadorServiceImpl.atualizar(id, new Operador(operador)));
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		operadorServiceImpl.removerPorId(id);
	}
	
}
