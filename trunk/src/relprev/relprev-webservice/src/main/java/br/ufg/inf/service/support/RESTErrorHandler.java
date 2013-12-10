package br.ufg.inf.service.support;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

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
     * Manipula exceção para status HTTP {@code 4xx}, exceção do cliente
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
        return new ResponseBuilder<E>().success(false).status(HttpStatus.BAD_REQUEST).message(message).build();
    }

    /**
     * Manipula exceções para status HTTP {@code 400}
     * 
     * @param ex
     *            {@link Exception}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler({BindException.class, HttpMessageNotReadableException.class, MissingServletRequestParameterException.class,
            MissingServletRequestPartException.class, TypeMismatchException.class})
    public Response<E> processBadRequestExceptions(final Exception ex) {
        this.logger.info("handle" + ex.getClass().getName() + " - Catching: " + ex.getClass().getSimpleName(), ex);
        return new ResponseBuilder<E>().success(false).message(ex.getMessage()).status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Manipula exceção para status HTTP {@code 404}
     * 
     * @param ex
     *            {@link NoSuchRequestHandlingMethodException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
    public Response<E> processNoSuchRequestHandlingMethodException(final NoSuchRequestHandlingMethodException ex) {
        this.logger.info("handleNoSuchRequestHandlingMethodException - Catching: " + ex.getClass().getSimpleName(), ex);
        return new ResponseBuilder<E>().success(false).message("Não há 'handle' para o método chamado: " + ex.getMethodName())
                .status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    /**
     * Manipula exceção para status HTTP {@code 405}
     * 
     * @param ex
     *            {@link HttpRequestMethodNotSupportedException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response<E> processHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException ex) {
        this.logger.info("handleHttpRequestMethodNotSupportedException - Catching: " + ex.getClass().getSimpleName(), ex);
        return new ResponseBuilder<E>().success(false).message(ex.getMethod() + " não suportado.")
                .status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    /**
     * Manipula exceção para status HTTP {@code 406}
     * 
     * @param ex
     *            {@link HttpMediaTypeNotAcceptableException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public Response<E> processHttpMediaTypeNotAcceptableException(final HttpMediaTypeNotAcceptableException ex) {
        this.logger.info("handleHttpMediaTypeNotAcceptableException - Catching: " + ex.getClass().getSimpleName(), ex);
        return new ResponseBuilder<E>().success(false).message(ex.getMessage()).status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    /**
     * Manipula exceção para status HTTP {@code 415}
     * 
     * @param ex
     *            {@link HttpMediaTypeNotSupportedException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response<E> processHttpMediaTypeNotSupportedException(final HttpMediaTypeNotSupportedException ex) {
        this.logger.info("handleHttpMediaTypeNotSupportedException - Catching: " + ex.getClass().getSimpleName(), ex);
        return new ResponseBuilder<E>().success(false).message(ex.getContentType().getType() + " not supported")
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
    }

    /**
     * Manipula exceções para status HTTP {@code 500}
     * 
     * @param ex
     *            {@link Exception}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public Response<E> processInternalServerErrors(final Exception ex) {
        this.logger.info("handle" + ex.getClass().getName() + " - Catching: " + ex.getClass().getSimpleName(), ex);
        return new ResponseBuilder<E>().success(false).message(ex.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * Manipula exceção para status HTTP {@code 5xx}, exceção do servidor
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

}
