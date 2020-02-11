package br.com.tutorial.domain.audits;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"criadoEm", "atualizadoEm"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable  {
	
	private static final long serialVersionUID = 5792572642022720231L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "criado_em", nullable = false, updatable = false)
	@CreatedDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss:sss z")
	private Date criadoEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "atualizado_em", nullable = false)
	@LastModifiedDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss:sss z")
	private Date atualizadoEm;

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Date getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Date atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
		
}
