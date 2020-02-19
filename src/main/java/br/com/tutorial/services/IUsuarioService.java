package br.com.tutorial.services;

import br.com.tutorial.domain.dto.atualiza_senha_usuario.AlteracaoSenhaUsuarioDTO;
import br.com.tutorial.domain.entities.Usuario;
import br.com.tutorial.domain.enums.EPermissao;

public interface IUsuarioService {

	Usuario criar(final EPermissao permissao, final Usuario usuario);

	void atualizarSenha(final AlteracaoSenhaUsuarioDTO usuario);
	
}
