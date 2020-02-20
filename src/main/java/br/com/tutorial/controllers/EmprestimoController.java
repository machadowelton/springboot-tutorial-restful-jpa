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

import br.com.tutorial.domain.dto.v1.EmprestimoDTO;
import br.com.tutorial.domain.entities.Emprestimo;
import br.com.tutorial.services.impls.EmprestimoServiceImpl;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	
	@Autowired
	private EmprestimoServiceImpl emprestimoServiceImpl;
	
	@GetMapping(value = "/{id}")
	public EmprestimoDTO buscarPorId(@PathVariable("id") Long id) {
		return new EmprestimoDTO(emprestimoServiceImpl.buscarPorId(id));
	}
	
	@GetMapping
	public Page<EmprestimoDTO> listar(Pageable pageable) {
		return emprestimoServiceImpl.listar(pageable).map(EmprestimoDTO::new);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public EmprestimoDTO criar(@RequestBody EmprestimoDTO emprestimo) {
		return new EmprestimoDTO(emprestimoServiceImpl.criar(new Emprestimo(emprestimo)));
	}
	
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PutMapping(value = "/{id}")
	public EmprestimoDTO atualizar(
			@PathVariable("id") Long id,
			@RequestBody EmprestimoDTO emprestimo
			) {
		return new EmprestimoDTO(emprestimoServiceImpl.atualizar(id, new Emprestimo(emprestimo)));
	}
	
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		emprestimoServiceImpl.removerPorId(id);
	}
	
	@GetMapping(value = "leitor/{idLeitor}")
	public Page<EmprestimoDTO> listarPorLeitorId(@PathVariable("id") Long idLeitor, Pageable pageable) {
		return emprestimoServiceImpl.listarPorLeitorId(idLeitor, pageable).map(EmprestimoDTO::new);
	}
	
}
