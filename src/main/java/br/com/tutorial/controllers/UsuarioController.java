package br.com.tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tutorial.domain.dto.usuario.UsuarioDTO;
import br.com.tutorial.services.impls.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
		
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@PatchMapping(value = "/atualizar_senha")
	public void atualizarSenha(@RequestBody UsuarioDTO usuario) {
		usuarioServiceImpl.atualizarSenha(usuario);
	}
	
}
