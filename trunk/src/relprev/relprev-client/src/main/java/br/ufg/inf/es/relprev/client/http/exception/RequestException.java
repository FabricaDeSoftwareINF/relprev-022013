package br.ufg.inf.es.relprev.client.http.exception;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 10:16 PM
 */
public class RequestException extends Throwable {

    private static final long serialVersionUID = 6485754414874782103L;

    public RequestException(final String mensagem) {
        super(mensagem);
    }

    public RequestException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
