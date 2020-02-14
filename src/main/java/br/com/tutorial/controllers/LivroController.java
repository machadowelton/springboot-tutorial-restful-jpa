package br.com.tutorial.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tutorial.domain.Livro;
import br.com.tutorial.services.impls.LivroServiceImpl;

@RestController
@RequestMapping(value = "/sessoes/{idSessao}/livros")
public class LivroController {
	
	
	private final LivroServiceImpl livroServiceImpl;

	public LivroController(final LivroServiceImpl livroServiceImpl) {
		this.livroServiceImpl = livroServiceImpl;
	}
	
	@GetMapping(value = "/{id}")
	public Livro buscarPorIdESessaoId(
			@PathVariable("idSessao") Long sessaoId,
			@PathVariable("id") Long id
			) {
		return livroServiceImpl.buscarPorIdESessaoId(id, sessaoId);
	}
	
	@GetMapping
	public Page<Livro> listarPorSessaoId(@PathVariable("idSessao") Long sessaoId, Pageable pageable) {
		return livroServiceImpl.listarPorSessaoId(sessaoId, pageable);
	}
	
	@PostMapping
	public ResponseEntity<Livro> criar(
			@PathVariable("idSessao") Long sessaoId,
			@RequestBody Livro livro
			) {
		return new ResponseEntity<Livro>(livroServiceImpl.criar(sessaoId, livro), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> atualizar(
			@PathVariable("idSessao") Long sessaoId,
			@PathVariable("id") Long id,
			@RequestBody Livro livro
			) {
		return new ResponseEntity<Livro>(livroServiceImpl.atualizar(id, sessaoId, livro), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removerPorIdESessaoId(
			@PathVariable("idSessao") Long sessaoId,
			@PathVariable("id") Long id
			) {
		livroServiceImpl.removerPorIdESessaoId(id, sessaoId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
