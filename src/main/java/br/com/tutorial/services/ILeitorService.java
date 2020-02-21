package br.com.tutorial.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tutorial.domain.dto.v1.LeitorDTO;
import br.com.tutorial.domain.entities.Leitor;

public interface ILeitorService {
	
	Leitor buscarPorId(final Long id);
	
	default LeitorDTO buscarPorIdDTO(final Long id) {
		return LeitorDTO.map(buscarPorId(id));
	}
	
	Page<Leitor> listar(final Pageable pageable);
	
	default Page<LeitorDTO> listarDTO(final Pageable pageable) {
		return listar(pageable).map(LeitorDTO::map);
	}
	
	Leitor criar(final Leitor leitor);
	
	default LeitorDTO criarDTO(final LeitorDTO leitor) {
		return LeitorDTO.map(criar(Leitor.map(leitor)));
	}
	
	Leitor atualizar(final Long id, Leitor leitor);
	
	default LeitorDTO atualizarDTO(final Long id, final LeitorDTO leitor) {
		return LeitorDTO.map(atualizar(id, Leitor.map(leitor)));
	}
	
	void removerPorId(final Long id);
	
}
