package br.ufg.inf.es.relprev.client.http.response;

import java.util.List;

import br.ufg.inf.es.relprev.client.dominio.ObjetoDeDominio;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 10:20 PM
 */
public abstract class Response<T extends ObjetoDeDominio> {

    @JsonProperty
    private String message;

    @JsonProperty
    private Boolean success;

    @JsonProperty
    private List<T> data;

    @JsonProperty
    private Integer count;

    @JsonProperty
    private String status;

    @Override
    public String toString() {
        return "Response{" + "message='" + this.message + '\'' + ", success=" + this.success + ", data=" + this.data + ", count="
                + this.count + ", status='" + this.status + '\'' + '}';
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(final List<T> data) {
        this.data = data;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
