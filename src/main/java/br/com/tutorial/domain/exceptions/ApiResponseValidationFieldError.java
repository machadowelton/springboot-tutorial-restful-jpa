package br.com.tutorial.domain.exceptions;

import java.util.Date;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApiResponseValidationFieldError extends ApiResponseError {

	private static final long serialVersionUID = -2145387805738747406L;
	
	
	private Map<String, String> campos;
	
	public ApiResponseValidationFieldError(Map<String, String> campos, String mensagem, Date data, HttpStatus status, String url, String path) {
		super(mensagem, data, status, path, url);
		this.campos = campos;
	}

}
