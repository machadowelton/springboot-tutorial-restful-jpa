package br.com.tutorial.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.tutorial.domain.audits.AuditModel;
import br.com.tutorial.domain.dto.v1.UsuarioDTO;
import br.com.tutorial.domain.enums.EPermissao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "usuarios")
@Entity
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
	
	public Usuario(final UsuarioDTO usuario) {
		this.setCriadoEm(usuario.getCriadoEm());
		this.setAtualizadoEm(usuario.getAtualizadoEm());
		this.id = usuario.getId();
		this.codLogin  = usuario.getCodLogin();
		this.senha = usuario.getSenha();
		this.permissao = usuario.getPermissao();
	}
	
}
