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

import br.com.tutorial.domain.dto.v1.SessaoDTO;
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
	public SessaoDTO buscarPorId(@PathVariable("id") Long id) {
		//return new SessaoDTO(sessaoServiceImpl.buscarPorId(id));
		return SessaoDTO.map(sessaoServiceImpl.buscarPorId(id));
	}

	@GetMapping
	public Page<SessaoDTO> listar(Pageable pageable) {
		return sessaoServiceImpl.listar(pageable).map(SessaoDTO::map);
	}

	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public SessaoDTO criar(@RequestBody SessaoDTO sessao) {
		//return new SessaoDTO(sessaoServiceImpl.criar(new Sessao(sessao)));
		//return SessaoDTO.map(sessaoServiceImpl.criar(new Sessao(sessao)));
		return SessaoDTO.map(sessaoServiceImpl.criar(Sessao.map(sessao)));
	}

	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PutMapping(value = "/{id}")
	public SessaoDTO atualizar(@PathVariable("id") Long id, @RequestBody SessaoDTO sessao) {
		//return new SessaoDTO(sessaoServiceImpl.atualizar(id, new Sessao(sessao)));
		return SessaoDTO.map(sessaoServiceImpl.atualizar(id, Sessao.map(sessao)));
	}
	
}
