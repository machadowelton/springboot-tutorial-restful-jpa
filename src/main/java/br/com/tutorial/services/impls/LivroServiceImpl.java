package br.com.tutorial.services.impls;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tutorial.domain.entities.Livro;
import br.com.tutorial.domain.entities.Sessao;
import br.com.tutorial.domain.exceptions.RecursoNaoEncontradoException;
import br.com.tutorial.services.ILivroService;
import br.com.tutorial.services.repository.LivroRepository;

@Service
public class LivroServiceImpl implements ILivroService {

	
	private final LivroRepository livroRepository;
	
	private final SessaoServiceImpl sessaoServiceImpl;
	
	

	public LivroServiceImpl(final LivroRepository livroRepository, final SessaoServiceImpl sessaoServiceImpl) {
		this.livroRepository = livroRepository;
		this.sessaoServiceImpl = sessaoServiceImpl;
	}
	
	@Override
	public Livro buscarPorIdESessaoId(Long id, Long sessaoId) {
		Optional<Livro> livro = livroRepository.findByIdAndSessaoId(id, sessaoId);
		if(!livro.isPresent())
			throw new RecursoNaoEncontradoException("Nenhum livro encontrado pelo id: " + id + " e sessaoId: " + sessaoId);
		return livro.get();
	}

	@Override
	public Page<Livro> listarPorSessaoId(Long sessaoId, Pageable pageable) {
		return livroRepository.findBySessaoId(sessaoId, pageable);
	}

	@Override
	public Livro criar(Long sessaoId, Livro livro) {
		Sessao sessao = sessaoServiceImpl.buscarPorId(sessaoId);
		return livroRepository.save(new Livro(sessao, livro));
	}

	@Override
	public Livro atualizar(Long id, Long sessaoId, Livro livro) {
		if(!livroRepository.existsByIdAndSessaoId(id, sessaoId))
			throw new RecursoNaoEncontradoException("Nenhum livro encontrado pelo id: " + id + " e sessaoId: " + sessaoId);
		Sessao sessao = sessaoServiceImpl.buscarPorId(sessaoId);
		return livroRepository.save(new Livro(id, sessao, livro));
	}

	@Override
	public void removerPorIdESessaoId(Long id, Long sessaoId) {
		if(!livroRepository.existsByIdAndSessaoId(id, sessaoId))
			throw new RecursoNaoEncontradoException("Nenhum livro encontrado pelo id: " + id + " e sessaoId: " + sessaoId);
		livroRepository.deleteByIdAndSessaoId(id, sessaoId);
	}
	
	protected Set<Livro> listarPorIds(Set<Long> ids) {
		return livroRepository.findAllById(ids).stream().collect(Collectors.toSet());
	}

}
