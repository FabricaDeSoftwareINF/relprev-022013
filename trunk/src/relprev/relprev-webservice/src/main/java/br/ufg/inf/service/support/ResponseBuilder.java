package br.ufg.inf.service.support;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.util.ReflectionUtil;

/**
 * Builder para construção de objetos para retorno dos endpoints REST
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Response
 */
public class ResponseBuilder<E extends AbstractEntity<E>> {

    private final Response<E> response;

    public ResponseBuilder() {
        this.response = new Response<E>();
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code success}
     * 
     * @param success
     *            {@code true} se obteve sucesso no processamento da requisição, {@code false}, caso contrário
     * @return {@link ResponseBuilder}
     */
    public ResponseBuilder<E> success(final Boolean success) {
        ReflectionUtil.setField(this.response, "success", success);
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code data}
     * 
     * @param data
     *            dados das entidades a serem retornados na resposta
     * @return {@link ResponseBuilder}
     */
    public ResponseBuilder<E> data(final List<E> data) {
        ReflectionUtil.setField(this.response, "data", data);
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code data}
     * 
     * @param data
     *            dado da entidade a ser retornado na resposta
     * @return {@link ResponseBuilder}
     */
    public ResponseBuilder<E> data(final E data) {
        final List<E> dataList = new LinkedList<E>();
        if (data != null) {
            dataList.add(data);
            ReflectionUtil.setField(this.response, "data", dataList);
        }
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code count}
     * 
     * @param count
     *            dados das entidades a serem retornados na resposta
     * @return {@link ResponseBuilder}
     */
    public ResponseBuilder<E> count(final Long count) {
        ReflectionUtil.setField(this.response, "count", count);
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code status}
     * 
     * @param message
     *            mensagem a ser incluída na resposta. É o retorno do processamento
     * @return {@link ResponseBuilder}
     */
    public ResponseBuilder<E> message(final String message) {
        ReflectionUtil.setField(this.response, "message", message);
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code status}
     * 
     * @param status
     *            {@link HttpStatus}
     * @return {@link Response}
     */
    public ResponseBuilder<E> status(final HttpStatus status) {
        ReflectionUtil.setField(this.response, "status", status == null ? HttpStatus.EXPECTATION_FAILED.value() : status.value());
        return this;
    }

    public Response<E> build() {
        return this.response;
    }

}
