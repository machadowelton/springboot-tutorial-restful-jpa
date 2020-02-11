package br.com.tutorial.controllers.handle;

import br.com.tutorial.domain.exceptions.ApiResponseError;
import br.com.tutorial.domain.exceptions.RecursoNaoEncontradoException;
import br.com.tutorial.domain.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Value("${br.com.tutorial.host}")
	private String host;
	
	private final String SPLIT_URI = "=";
	
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public final ResponseEntity<ApiResponseError> RecursoNaoEncontradoHandle(RecursoNaoEncontradoException ex, WebRequest request) {
		String path = request.getDescription(false).split("=")[1];
		String url = host + path;
		ApiResponseError apiResponse = new ApiResponseError(ex.getMessage(), new Date(), HttpStatus.NOT_FOUND, path, url);
		return new ResponseEntity<ApiResponseError>(apiResponse, new HttpHeaders(), apiResponse.getStatus());
	}
	
	@ExceptionHandler(ValidacaoException.class)
	public final ResponseEntity<ApiResponseError> ValidacaoHandle(ValidacaoException ex, WebRequest request) {
		String path = request.getDescription(false).split("=")[1];
		String url = host + path;
		ApiResponseError apiResponse = new ApiResponseError(ex.getMessage(), new Date(), HttpStatus.BAD_REQUEST, path, url);
		return new ResponseEntity<ApiResponseError>(apiResponse, new HttpHeaders(), apiResponse.getStatus());
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String path = request.getDescription(false).split(SPLIT_URI)[1];
		String url = host + path;
		String mensagem = "O recurso solicitado não existe ou não está disponível: " + url;
		ApiResponseError apiResponseError = new ApiResponseError(mensagem, new Date(), HttpStatus.NOT_FOUND, path, url);
		return new ResponseEntity<Object>(apiResponseError, new HttpHeaders(), apiResponseError.getStatus());
	}
		
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApiResponseError> ErroInterno(Exception ex, WebRequest request) {
		String path = request.getDescription(false).split("=")[1];
		String url = host + path;
		ApiResponseError apiResponse = new ApiResponseError("Ocorreu um erro ao processar a requisição", new Date(), HttpStatus.INTERNAL_SERVER_ERROR, path, url);
		return new ResponseEntity<ApiResponseError>(apiResponse, new HttpHeaders(), apiResponse.getStatus());
	}
	
}
