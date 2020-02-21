package br.com.tutorial.controllers;


import javax.validation.Valid;

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

import br.com.tutorial.domain.dto.v1.LeitorDTO;
import br.com.tutorial.services.impls.LeitorServiceImpl;

@RestController
@RequestMapping(value = "/leitores")
public class LeitorController {
	
	@Autowired
	private LeitorServiceImpl leitorServiceImpl;
	
	@GetMapping(value = "/{id}")
	public LeitorDTO buscarPorId(@PathVariable("id") Long idLeitor) {		
		return leitorServiceImpl.buscarPorIdDTO(idLeitor);
	}
	
	@GetMapping
	public Page<LeitorDTO> listar(Pageable pageable) {
		return leitorServiceImpl.listarDTO(pageable);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public LeitorDTO criar(@Valid @RequestBody LeitorDTO leitor) {
		return leitorServiceImpl.criarDTO(leitor);
	}
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PutMapping(value = "/{id}")
	public LeitorDTO atualizar(
			@PathVariable("id") Long idLeitor, 
			@RequestBody LeitorDTO leitor) {
		return leitorServiceImpl.atualizarDTO(idLeitor, leitor);
	}
	
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	public void removerPorId(@PathVariable("id") Long idLeitor) {
		leitorServiceImpl.removerPorId(idLeitor);
	}
}
