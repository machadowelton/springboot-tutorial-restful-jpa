package br.com.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.tutorial.domain.Emprestimo;
import br.com.tutorial.services.impls.EmprestimoServiceImpl;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	
	@Autowired
	private EmprestimoServiceImpl emprestimoServiceImpl;
	
	@GetMapping(value = "/{id}")
	public Emprestimo buscarPorId(@PathVariable("id") Long id) {
		return emprestimoServiceImpl.buscarPorId(id);
	}
	
	@GetMapping
	public Page<Emprestimo> listar(Pageable pageable) {
		return emprestimoServiceImpl.listar(pageable);
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> criar(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<Emprestimo>(emprestimoServiceImpl.criar(emprestimo), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Emprestimo> atualizar(
			@PathVariable("id") Long id,
			@RequestBody Emprestimo emprestimo
			) {
		return new ResponseEntity<Emprestimo>(emprestimoServiceImpl.atualizar(id, emprestimo), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removerPorId(@PathVariable("id") Long id) {
		emprestimoServiceImpl.removerPorId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "leitor/{idLeitor}")
	public Page<Emprestimo> listarPorLeitorId(@PathVariable("id") Long idLeitor, Pageable pageable) {
		return emprestimoServiceImpl.listarPorLeitorId(idLeitor, pageable);
	}
	
}