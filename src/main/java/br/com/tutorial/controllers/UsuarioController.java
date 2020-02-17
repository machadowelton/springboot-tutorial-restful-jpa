package br.com.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tutorial.domain.custom.usuario.UsuarioDTO;
import br.com.tutorial.services.impls.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
		
	@PatchMapping(value = "/atualizar_senha")
	public ResponseEntity<?> atualizarSenha(@RequestBody UsuarioDTO usuario) {
		usuarioServiceImpl.atualizarSenha(usuario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
