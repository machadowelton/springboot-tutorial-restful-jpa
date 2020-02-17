package br.com.tutorial.services.impls;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tutorial.domain.entities.Operador;
import br.com.tutorial.domain.entities.Usuario;
import br.com.tutorial.domain.enums.EPermissao;
import br.com.tutorial.domain.exceptions.RecursoNaoEncontradoException;
import br.com.tutorial.services.IOperadorService;
import br.com.tutorial.services.repository.OperadorRepository;

@Service
public class OperadorServiceImpl implements IOperadorService {

	private final OperadorRepository operadorRepository;
	private final UsuarioServiceImpl usuarioServiceImpl;

	public OperadorServiceImpl(final OperadorRepository operadorRepository, final UsuarioServiceImpl usuarioServiceImpl) {		
		this.operadorRepository = operadorRepository;
		this.usuarioServiceImpl = usuarioServiceImpl;		
	}
	
	@Override
	public Operador buscarPorId(final Long id) {
		Optional<Operador> operador = operadorRepository.findById(id);
		if(!operador.isPresent())
			throw new RecursoNaoEncontradoException("Nenhum operador encontrado pelo id: " + id);
		return operador.get();
	}

	@Override
	public Page<Operador> listar(final Pageable pageable) {
		return operadorRepository.findAll(pageable);
	}

	@Override
	public Operador criar(final Operador operador) {
		final Usuario usuario = usuarioServiceImpl.criar(EPermissao.OPERADOR, operador.getUsuario());
		return operadorRepository.save(new Operador(usuario, operador));
	}

	@Override
	public Operador atualizar(final Long id, final Operador operador) {
		if(!operadorRepository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhum operador encontrado pelo id: " + id);		
		return operadorRepository.save(new Operador(id, operador));
	}

	@Override
	public void removerPorId(final Long id) {
		if(!operadorRepository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhum operador encontrado pelo id: " + id);
		operadorRepository.deleteById(id);
	}

}
