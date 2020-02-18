package br.com.tutorial.domain.dto.v1.embs;

import br.com.tutorial.domain.embs.Telefone;
import br.com.tutorial.domain.enums.ETipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

	private ETipoTelefone tipoTelefone;
	
	private Integer ddi;
	
	private Integer ddd;
	
	private Long numero;
	
	public TelefoneDTO(Telefone telefone) {
		this.ddi = telefone.getDdi();
		this.ddd = telefone.getDdd();
		this.numero = telefone.getNumero();
		this.tipoTelefone = telefone.getTipoTelefone();
	}
	
}
