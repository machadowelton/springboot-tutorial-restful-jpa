package br.com.tutorial.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tutorial.domain.Emprestimo;
import br.com.tutorial.domain.Leitor;
import br.com.tutorial.domain.Livro;
import br.com.tutorial.domain.Operador;
import br.com.tutorial.domain.custom.usuario.UsuarioDTO;
import br.com.tutorial.services.impls.EmprestimoServiceImpl;
import br.com.tutorial.services.impls.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	private EmprestimoServiceImpl emprestimoServiceImpl;
		
	@PatchMapping(value = "/atualizar_senha")
	public ResponseEntity<?> atualizarSenha(@RequestBody UsuarioDTO usuario) {
		usuarioServiceImpl.atualizarSenha(usuario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public void a() {
		Emprestimo emprestimo = Emprestimo.builder()
									.dataRetirada(new Date())
									.dataDevolucaoCalculada(new Date())
									.dataRealDevolucao(new Date())
									.leitor(Leitor.builder().id(1L).build())
									.operador(Operador.builder().id(1L).build())
									.livros(new HashSet<Livro>(Arrays.asList(Livro.builder().id(1L).build())))
									.build();
		;
		Emprestimo e = emprestimoServiceImpl.criar(emprestimo);
		System.out.println("aa");
	}
	
	
}
