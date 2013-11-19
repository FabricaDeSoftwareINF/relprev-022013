package br.ufg.inf.es.relprev.client.http.response;

import br.ufg.inf.es.relprev.client.dominio.ObjetoDeDominio;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
    //    Integer status;
    @JsonProperty
    private String status;

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", data=" + data +
                ", count=" + count +
                ", status='" + status + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
