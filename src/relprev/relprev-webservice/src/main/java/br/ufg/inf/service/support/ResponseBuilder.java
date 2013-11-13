package br.ufg.inf.service.support;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;

import br.ufg.inf.model.support.AbstractEntity;

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
        setField("success", success);
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
        setField("data", data);
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
            setField("data", dataList);
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
        setField("count", count);
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
        setField("message", message);
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
        setField("status", status.value());
        return this;
    }

    public Response<E> build() {
        return this.response;
    }

    /**
     * Seta em um atributo de uma classe o atributo com nome '{@code name}' o valor '{@code value}' no objeto desta instância
     *
     * @param name nome do atributo a ser setado o conteúdo
     * @param value conteúdo a ser setado
     * @see ReflectionUtils#findField(Class, String)
     * @see ReflectionUtils#makeAccessible(Field)
     * @see ReflectionUtils#setField(Field, Object, Object)
     */
    private void setField(final String name, final Object value) {
        final Field field = ReflectionUtils.findField(this.response.getClass(), name);
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, this.response, value);
    }

}
