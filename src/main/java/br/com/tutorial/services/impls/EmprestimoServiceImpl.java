package br.com.tutorial.services.impls;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tutorial.domain.Emprestimo;
import br.com.tutorial.domain.exceptions.RecursoNaoEncontradoException;
import br.com.tutorial.services.IEmprestimoService;
import br.com.tutorial.services.repository.EmprestimoRepository;

@Service
public class EmprestimoServiceImpl implements IEmprestimoService {

	
	private final EmprestimoRepository emprestimoRepository;
//	private final LeitorServiceImpl leitorServiceImpl;
//	private final OperadorServiceImpl operadorServiceImpl;
//	private final LivroServiceImpl livroServiceImpl;

	public EmprestimoServiceImpl(
								final EmprestimoRepository emprestimoRepository//, 
//								final LeitorServiceImpl leitorServiceImpl,
//								final OperadorServiceImpl operadorServiceImpl,
//								final LivroServiceImpl livroServiceImpl
								) {
		this.emprestimoRepository = emprestimoRepository;
//		this.leitorServiceImpl = leitorServiceImpl;
//		this.operadorServiceImpl = operadorServiceImpl;
//		this.livroServiceImpl = livroServiceImpl;
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
	
		return null;	
	}

	@Override
	public Emprestimo atualizar(Long id, Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerPorId(Long id) {
		// TODO Auto-generated method stub

	}

}
