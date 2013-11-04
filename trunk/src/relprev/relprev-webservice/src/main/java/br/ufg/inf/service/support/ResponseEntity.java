package br.ufg.inf.service.support;

import java.io.Serializable;
import java.util.List;

import br.ufg.inf.model.support.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para representação de dados de resposta e também de chamadas ao endpoints REST
 * 
 * @created 03/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class ResponseEntity<E extends AbstractEntity> implements Serializable {

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
	private String status;

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
		return this.count;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

}
