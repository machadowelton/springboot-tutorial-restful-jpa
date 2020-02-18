package br.com.tutorial.services;

import br.com.tutorial.domain.dto.usuario.UsuarioDTO;
import br.com.tutorial.domain.entities.Usuario;
import br.com.tutorial.domain.enums.EPermissao;

public interface IUsuarioService {

	Usuario criar(EPermissao permissao, Usuario usuario);

	void atualizarSenha(final UsuarioDTO usuario);
	
}
