package br.com.tutorial.domain.exceptions;

public class AplicacaoException extends  RuntimeException {


    private static final long serialVersionUID = 1216990042077601866L;

    public AplicacaoException() {}

    public AplicacaoException(String msg) {
        super(msg);
    }

    public AplicacaoException(Throwable thr) {
        super(thr);
    }

    public AplicacaoException(String msg, Throwable thr) {
        super(msg, thr);
    }
}