package br.ufg.inf.service.support;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;

import br.ufg.inf.model.support.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para representação de dados de resposta e também de chamadas ao endpoints REST
 * 
 * @created 03/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@JsonInclude(Include.NON_EMPTY)
public class ResponseEntity<E extends AbstractEntity<E>> implements Serializable {

    private static final long serialVersionUID = 415873352876691068L;

    @JsonProperty
    private Boolean success;

    @JsonProperty
    private List<E> data;

    @JsonProperty
    private Long count;

    @JsonProperty
    private String message;

    @JsonProperty
    private Integer status;

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    @JsonInclude(Include.NON_NULL)
    public List<E> getData() {
        return this.data;
    }

    public void setData(final List<E> data) {
        this.data = data;
    }

    public Long getCount() {
        return this.count != null ? this.count : this.getData() != null ? this.getData().size() : 0L;
    }

    public void setCount(final Long count) {
        this.count = count;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code success}
     * 
     * @param success
     *            {@code true} se obteve sucesso no processamento da requisição, {@code false}, caso contrário
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<E> success(final Boolean success) {
        this.setSuccess(success);
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code data}
     * 
     * @param data
     *            dados das entidades a serem retornados na resposta
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<E> data(final List<E> data) {
        this.setData(data);
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code data}
     * 
     * @param data
     *            dado da entidade a ser retornado na resposta
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<E> data(final E data) {
        final List<E> dataList = new LinkedList<E>();
        dataList.add(data);
        this.setData(dataList);
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code count}
     * 
     * @param count
     *            quantidade de objetos retornados em {@code data}
     * @return {@link ResponseEntity}
     */
    // public ResponseEntity<E> count(final Long count) {
    // this.setCount(count);
    // return this;
    // }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code status}
     * 
     * @param message
     *            mensagem a ser incluída na resposta. É o retorno do processamento
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<E> message(final String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * Ajusta a mensagem de reposta com a propriedade {@code status}
     * 
     * @param status
     *            {@link HttpStatus}
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<E> status(final HttpStatus status) {
        this.setStatus(status.value());
        return this;
    }

}
