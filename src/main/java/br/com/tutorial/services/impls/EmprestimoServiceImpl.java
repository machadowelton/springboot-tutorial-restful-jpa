package br.com.tutorial.services.impls;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tutorial.domain.entities.Emprestimo;
import br.com.tutorial.domain.entities.Leitor;
import br.com.tutorial.domain.entities.Livro;
import br.com.tutorial.domain.entities.Operador;
import br.com.tutorial.domain.exceptions.RecursoNaoEncontradoException;
import br.com.tutorial.services.IEmprestimoService;
import br.com.tutorial.services.repository.EmprestimoRepository;

@Service
public class EmprestimoServiceImpl implements IEmprestimoService {

	
	private final EmprestimoRepository emprestimoRepository;
	private final LeitorServiceImpl leitorServiceImpl;
	private final OperadorServiceImpl operadorServiceImpl;
	private final LivroServiceImpl livroServiceImpl;

	public EmprestimoServiceImpl(
								final EmprestimoRepository emprestimoRepository, 
								final LeitorServiceImpl leitorServiceImpl,
								final OperadorServiceImpl operadorServiceImpl,
								final LivroServiceImpl livroServiceImpl
								) {
		this.emprestimoRepository = emprestimoRepository;
		this.leitorServiceImpl = leitorServiceImpl;
		this.operadorServiceImpl = operadorServiceImpl;
		this.livroServiceImpl = livroServiceImpl;
	}
	
	@Override
	public Emprestimo buscarPorId(Long id) {
		Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
		if(!emprestimo.isPresent())
			throw new RecursoNaoEncontradoException("Nenhum emprestimo encontrado pelo id: " + id);
		return emprestimo.get();
	}

	@Override
	public Page<Emprestimo> listar(Pageable pageable) {
		return emprestimoRepository.findAll(pageable);
	}			
	
	@Override
	public Emprestimo criar(Emprestimo emprestimo) {
		Leitor leitor = leitorServiceImpl.buscarPorId(emprestimo.getLeitor().getId());
		Operador operador = operadorServiceImpl.buscarPorId(emprestimo.getOperador().getId());
		Set<Livro> livros = livroServiceImpl.listarPorIds(emprestimo.getLivros().stream().map(m -> m.getId()).collect(Collectors.toSet()));
		return emprestimoRepository.save(new Emprestimo(emprestimo, leitor, operador, livros));	
	}

	@Override
	public Emprestimo atualizar(Long id, Emprestimo emprestimo) {
		if(!emprestimoRepository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhum emprestimo encontrado pelo id: " + id);
		return emprestimoRepository.save(new Emprestimo(id, emprestimo));
	}

	@Override
	public void removerPorId(Long id) {
		if(!emprestimoRepository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhum emprestimo encontrado pelo id: " + id);
		emprestimoRepository.deleteById(id);
	}

	@Override
	public Page<Emprestimo> listarPorLeitorId(Long idLeitor, Pageable pageable) {
		return emprestimoRepository.findByLeitorId(idLeitor, pageable);
	}

}
