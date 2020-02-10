package br.com.tutorial.services.impls;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tutorial.domain.Leitor;
import br.com.tutorial.domain.Usuario;
import br.com.tutorial.domain.exceptions.RecursoNaoEncontradoException;
import br.com.tutorial.services.ILeitorService;
import br.com.tutorial.services.repository.LeitorRepository;

@Service
public class LeitorServiceImpl implements ILeitorService {
	
	private final LeitorRepository leitorRepository;
	private final UsuarioServiceImpl usuairoServiceImpl;
	
	
	public LeitorServiceImpl(final LeitorRepository leitorRepository, final UsuarioServiceImpl usuairoServiceImpl) {
		this.leitorRepository = leitorRepository;
		this.usuairoServiceImpl = usuairoServiceImpl;
	}

	@Override
	public Leitor buscarPorId(final Long id) {
		final Optional<Leitor> leitor = leitorRepository.findById(id);
		if(!leitor.isPresent())
			throw new RecursoNaoEncontradoException("Nenhum leitor encontrado pelo id:" + id);
		return leitor.get();
	}

	@Override
	public Page<Leitor> listar(final Pageable pageable) {		
		return leitorRepository.findAll(pageable);
	}

	@Override
	public Leitor criar(final Leitor leitor) {
		final Usuario usuario = usuairoServiceImpl.criar(leitor.getUsuario());	
		return leitorRepository.save(new Leitor(leitor, usuario));
	}

	@Override
	public Leitor atualizar(final Long id, final Leitor leitor) {
		if(!leitorRepository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhum leitor encontrado pelo id: " + id);
		return leitorRepository.save(new Leitor(id, leitor));
	}

	@Override
	public void removerPorId(final Long id) {
		if(!leitorRepository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhum leitor encontrado pelo id: " + id);
		leitorRepository.deleteById(id);
	}

}
