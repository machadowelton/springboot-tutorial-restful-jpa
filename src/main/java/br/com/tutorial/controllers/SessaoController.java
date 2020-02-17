package br.com.tutorial.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tutorial.domain.entities.Sessao;
import br.com.tutorial.services.impls.SessaoServiceImpl;

@RestController
@RequestMapping(value = "/sessoes")
public class SessaoController {

	private final SessaoServiceImpl sessaoServiceImpl;

	public SessaoController(final SessaoServiceImpl sessaoServiceImpl) {
		this.sessaoServiceImpl = sessaoServiceImpl;
	}

	@GetMapping(value = "/{id}")
	public Sessao buscarPorId(@PathVariable("id") Long id) {
		return sessaoServiceImpl.buscarPorId(id);
	}

	@GetMapping
	public Page<Sessao> listar(Pageable pageable) {
		return sessaoServiceImpl.listar(pageable);
	}

	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public Sessao criar(@RequestBody Sessao sessao) {
		return sessaoServiceImpl.criar(sessao);
	}

	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PutMapping(value = "/{id}")
	public Sessao atualizar(@PathVariable("id") Long id, @RequestBody Sessao sessao) {
		return sessaoServiceImpl.atualizar(id, sessao);
	}
	
}
