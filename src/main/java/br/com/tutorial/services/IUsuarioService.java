package br.com.tutorial.services;

import br.com.tutorial.domain.custom.usuario.UsuarioDTO;

public interface IUsuarioService {
	
	void atualizarSenha(final UsuarioDTO usuario);
	
}
