package br.com.tutorial.domain;

import br.com.tutorial.domain.audits.AuditModel;
import br.com.tutorial.domain.enums.EPermissao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(
        value = {"senha", "operador", "leitor" },
        allowSetters = true
)
@JsonPropertyOrder(value = {
		"id",
		"codLogin",
		"permissao",
		"criadoEm",
		"atualizadoEm"
})
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Usuario extends AuditModel {

	private static final long serialVersionUID = 7111764113159191778L;
	
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private Long id;
	
	@NotNull
	@Column(unique = true)
	private String codLogin;
		
	@NotNull
	private String senha;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EPermissao permissao;
	
	@OneToOne(mappedBy = "usuario")
	private Operador operador;
	
	@OneToOne(mappedBy = "usuario")
	private Leitor leitor;
	
	public Usuario(final String senha, final Usuario usuario) {
		this.senha = senha;
		if(usuario.id != null) this.id = usuario.id;
		this.codLogin = usuario.codLogin;
		this.permissao = usuario.permissao;
		if(usuario.leitor != null) this.leitor = usuario.leitor;
		if(usuario.operador != null) this.operador = usuario.operador;
	}

	public Usuario(final EPermissao permissao, final Usuario usuario) {
		this.senha = usuario.senha;
		if(usuario.id != null) this.id = usuario.id;
		this.codLogin = usuario.codLogin;
		this.permissao = permissao;
		if(usuario.leitor != null) this.leitor = usuario.leitor;
		if(usuario.operador != null) this.operador = usuario.operador;
	}
	
}
