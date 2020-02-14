package br.com.tutorial.services.impls;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.tutorial.domain.Usuario;
import br.com.tutorial.domain.custom.usuario.UsuarioDTO;
import br.com.tutorial.domain.enums.EPermissao;
import br.com.tutorial.domain.exceptions.AplicacaoException;
import br.com.tutorial.domain.exceptions.ValidacaoException;
import br.com.tutorial.services.IUsuarioService;
import br.com.tutorial.services.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder encoder;

	public UsuarioServiceImpl(final UsuarioRepository usuarioRepository, final PasswordEncoder enconder) {
		this.usuarioRepository = usuarioRepository;
		this.encoder = enconder;
	}

	@Override
	public Usuario criar(final EPermissao permissao, final Usuario usuario) {
		final Usuario usuarioComPermissao = new Usuario(permissao, usuario);
		if (usuarioRepository.existsByCodLogin(usuarioComPermissao.getCodLogin()))
			throw new ValidacaoException("O codLogin " + usuarioComPermissao.getCodLogin() + " não pode ser utilizado!");
		final String senha = encoder.encode(usuarioComPermissao.getSenha());
		return usuarioRepository.save(new Usuario(senha, usuarioComPermissao));
	}

	@Override
	public void atualizarSenha(final UsuarioDTO usuario) {		
		if (!usuario.getSenhaNova().equals(usuario.getSenhaNovaConfirmacao()))
			throw new ValidacaoException("A senha nova e a confirmação não coincidem");
		final Optional<Usuario> usuarioOp = usuarioRepository.findByCodLogin(usuario.getUsuario().getCodLogin());
		if (!usuarioOp.isPresent())
			throw new ValidacaoException("Combinação de usuário e senha inválida");
		if (!encoder.matches(usuario.getUsuario().getSenha(), usuarioOp.get().getSenha()))
			throw new ValidacaoException("Combinação de usuário e senha inválida");
		final String senha = encoder.encode(usuario.getSenhaNova());
		final String codLogin = usuario.getUsuario().getCodLogin();
		final int efeito = usuarioRepository.atualizarSenha(senha, codLogin);
		if(efeito ==  0)
			throw new AplicacaoException("Ocorreu um erro ao processar a requisição");
	}
	
	

}
