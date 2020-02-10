package br.com.tutorial.domain.exceptions;

public class ValidacaoException extends RuntimeException {

	private static final long serialVersionUID = -4829646883506610202L;
	
	public ValidacaoException() {}
	
	public ValidacaoException(String msg) {
		super(msg);
	}
	
	public ValidacaoException(Throwable thr) {
		super(thr);
	}
	
	public ValidacaoException(String msg, Throwable thr) {
		super(msg, thr);
	}

}
