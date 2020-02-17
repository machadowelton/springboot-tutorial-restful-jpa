package br.com.tutorial.services.impls;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tutorial.domain.entities.Sessao;
import br.com.tutorial.domain.exceptions.RecursoNaoEncontradoException;
import br.com.tutorial.services.ISessaoService;
import br.com.tutorial.services.repository.SessaoRepository;

@Service
public class SessaoServiceImpl implements ISessaoService {

	private final SessaoRepository sessaoRepository;

	public SessaoServiceImpl(final SessaoRepository sessaoRepository) {
		this.sessaoRepository = sessaoRepository;
	}
	
	@Override
	public Sessao buscarPorId(Long id) {
		Optional<Sessao> sessao = sessaoRepository.findById(id);
		if(!sessao.isPresent())
			throw new RecursoNaoEncontradoException("Nenhuma sessao encontrada pelo id: " + id);
		return sessao.get();
	}

	@Override
	public Page<Sessao> listar(Pageable pageable) {
		return sessaoRepository.findAll(pageable);
	}

	@Override
	public Sessao criar(Sessao sessao) {
		return sessaoRepository.save(sessao);
	}

	@Override
	public Sessao atualizar(Long id, Sessao sessao) {
		if(!sessaoRepository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhuma sessao encontrada pelo id: " + id);
		return sessaoRepository.save(new Sessao(id, sessao));
	}

	@Override
	public void removerPorId(Long id) {
		if(!sessaoRepository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhuma sessao encontrada pelo id: " + id);
		sessaoRepository.deleteById(id);
	}
	
	protected Boolean existePorId(Long id) {
		if(sessaoRepository.existsById(id))
			return Boolean.TRUE;
		throw new RecursoNaoEncontradoException("Nenhuma sessao encontrada pelo id: " + id);
	}

}
