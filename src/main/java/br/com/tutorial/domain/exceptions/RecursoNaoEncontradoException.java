package br.com.tutorial.domain.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -3254845756249266155L;
	
	public RecursoNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public RecursoNaoEncontradoException(Throwable thr) {
		super(thr);
	}
	
	public RecursoNaoEncontradoException(String msg, Throwable thr) {
		super(msg, thr);
	}

}
