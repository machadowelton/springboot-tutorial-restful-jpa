package br.com.tutorial.controllers;


import br.com.tutorial.domain.Leitor;
import br.com.tutorial.services.impls.LeitorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/leitores")
public class LeitorController {
	
	@Autowired
	private LeitorServiceImpl leitorServiceImpl;
	
	@GetMapping(value = "/{id}")
	public Leitor buscarPorId(@PathVariable("id") Long idLeitor) {
		return leitorServiceImpl.buscarPorId(idLeitor);
	}
	
	@GetMapping
	public Page<Leitor> listar(Pageable pageable) {
		return leitorServiceImpl.listar(pageable);
	}
	
	@PostMapping
	public Leitor criar(@RequestBody Leitor leitor) {
		return leitorServiceImpl.criar(leitor);
	}
	
	@PutMapping(value = "/{id}")
	public Leitor atualizar(@PathVariable("id") Long idLeitor, @RequestBody Leitor leitor) {
		return leitorServiceImpl.atualizar(idLeitor, leitor);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removerPorId(@PathVariable("id") Long idLeitor) {
		leitorServiceImpl.removerPorId(idLeitor);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
