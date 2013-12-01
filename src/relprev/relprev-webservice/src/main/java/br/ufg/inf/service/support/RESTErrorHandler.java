package br.ufg.inf.service.support;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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
        return new ResponseBuilder<E>().success(false).message(ex.getMessage()).status(ex.getStatusCode()).build();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<E> processValidationError(final MethodArgumentNotValidException ex) {
        final BindingResult result = ex.getBindingResult();
        return this.buildDataInteracaoResponse(result);
    }

    /**
     * Constrói resposta em caso de validação com falha para a data das interações em relação à data de persistência do relatório
     * de prevenção
     * 
     * @param result
     *            {@link BindingResult}
     * @return {@link Response}
     */
    private Response<E> buildDataInteracaoResponse(final BindingResult result) {
        return new ResponseBuilder<E>().success(false).status(HttpStatus.BAD_REQUEST)
                .message(result.getFieldError("data").getDefaultMessage()).build();
    }

}
