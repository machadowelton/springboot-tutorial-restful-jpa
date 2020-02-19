package br.com.tutorial.domain.embs;

import br.com.tutorial.domain.dto.v1.TelefoneDTO;
import br.com.tutorial.domain.enums.ETipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder(toBuilder = true)
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {
	
	@Enumerated(EnumType.STRING)
	private ETipoTelefone tipoTelefone;
	
	private Integer ddi;
	
	private Integer ddd;
	
	private Long numero;
	
	public Telefone(final TelefoneDTO telefone) {
		this.tipoTelefone = telefone.getTipoTelefone();
		this.ddi = telefone.getDdi();
		this.ddd = telefone.getDdd();
		this.numero = telefone.getNumero();
	}
	
}
