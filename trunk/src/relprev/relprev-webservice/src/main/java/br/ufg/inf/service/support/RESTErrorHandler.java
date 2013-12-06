package br.ufg.inf.service.support;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    public Response<E> processValidationError(final MethodArgumentNotValidException ex) {
        this.logger.info("handleMethodArgumentNotValidException - Catching: " + ex.getClass().getSimpleName(), ex);
        final BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        return this.buildResponse(fieldErrors);
    }

    /**
     * Constrói resposta em caso de validação com falha para a data das interações em relação à data de persistência do relatório
     * de prevenção
     * 
     * @param fieldErrors
     *            campos com erro de validação
     * @return {@link Response}
     */
    private Response<E> buildResponse(final List<FieldError> fieldErrors) {
        final Integer VERIFY_INCREMENT = 1;
        final StringBuilder message = new StringBuilder();
        final Integer errorsSize = fieldErrors.size();
        for (int i = 0; i < errorsSize; i++) {
            final String errorMessage = this.resolveLocalizedErrorMessage(fieldErrors.get(i));
            message.append(errorMessage);
            if (i + VERIFY_INCREMENT < errorsSize) {
                message.append(" | ");
            }
        }
        return new ResponseBuilder<E>().success(false).status(HttpStatus.BAD_REQUEST).message(message.toString()).build();
    }

    /**
     * Recupe de um message resource a mensagem de erro de validação
     * 
     * @param fieldError
     *            campo com erro de validação
     * @return messagem do resource com
     */
    private String resolveLocalizedErrorMessage(final FieldError fieldError) {
        final Locale currentLocale = LocaleContextHolder.getLocale();
        String localizedErrorMessage = this.messageSource.getMessage(fieldError, currentLocale);

        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
            final String[] fieldErrorCodes = fieldError.getCodes();
            localizedErrorMessage = fieldErrorCodes[0];
        }

        return localizedErrorMessage;
    }

}
