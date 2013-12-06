package br.ufg.inf.service.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import br.ufg.inf.model.support.AbstractEntity;

/**
 * Trata exceções dos controllers, formando respostas ao cliente
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@ControllerAdvice
public class RESTErrorHandler<E extends AbstractEntity<E>> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    /**
     * Manipula exceções para status HTTP {@code 4xx}, exceções do cliente
     * 
     * @param ex
     *            {@link HttpClientErrorException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(HttpClientErrorException.class)
    public Response<E> processHttpClientErrorException(final HttpClientErrorException ex) {
        this.logger.info("handleHttpClientErrorException - Catching: " + ex.getClass().getSimpleName(), ex);
        return new ResponseBuilder<E>().success(false).message(ex.getMessage()).status(ex.getStatusCode()).build();
    }

    /**
     * Manipula exceções para status HTTP {@code 5xx}, exceções do servidor
     * 
     * @param ex
     *            {@link HttpServerErrorException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(HttpServerErrorException.class)
    public Response<E> processHttpServerErrorException(final HttpServerErrorException ex) {
        this.logger.info("handleHttpServerErrorException - Catching: " + ex.getClass().getSimpleName(), ex);
        return new ResponseBuilder<E>().success(false).message(ex.getMessage()).status(ex.getStatusCode()).build();
    }

    /**
     * Manipula exceção de validação de objetos nos serviços
     * 
     * @param ex
     *            {@link MethodArgumentNotValidException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<E> processMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        this.logger.info("handleMethodArgumentNotValidException - Catching: " + ex.getClass().getSimpleName(), ex);
        final BindingResult result = ex.getBindingResult();
        final FieldError fieldError = result.getFieldError();
        final String message = this.messageSource.getMessage(fieldError.getDefaultMessage(), null, null);
        return new ResponseBuilder<E>().success(false).status(HttpStatus.BAD_REQUEST).message(message.toString()).build();
    }

}
