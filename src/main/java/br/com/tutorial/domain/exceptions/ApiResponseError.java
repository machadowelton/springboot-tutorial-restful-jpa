package br.com.tutorial.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseError implements Serializable {
	
	private static final long serialVersionUID = 7919391012593870427L;

	private String mensagem;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss:sss z")
	private Date data = new Date();	
	
	private HttpStatus status;
	
	private String path;
	
	private String url;

	
}
