package br.ufg.inf.service.support;

import java.io.Serializable;
import java.util.List;

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
public class Response<E extends AbstractEntity<E>> implements Serializable {

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

}
