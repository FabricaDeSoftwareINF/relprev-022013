package br.ufg.inf.model.support;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Entidade para persistência e retorno de JSON de anexos de um relatório de prevenção
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Table(name = "anexos")
@JsonRootName(value = "anexo")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"versao", "new", "isHidden", "dataInsercaoAlteracao"})
public class Anexo extends AbstractEntity {

	private static final long serialVersionUID = 4571775183834766912L;

	@JsonProperty(value = "mimeType")
	@Column(nullable = false, name = "mime_type")
	private String mimeType;

	@JsonProperty(value = "urlAnexo")
	@Column(nullable = false, name = "url_anexo")
	private String urlAnexo;

	public String getMimeType() {
		return this.mimeType;
	}

	public void setMimeType(final String mimeType) {
		this.mimeType = mimeType;
	}

	public String getUrlAnexo() {
		return this.urlAnexo;
	}

	public void setUrlAnexo(final String urlAnexo) {
		this.urlAnexo = urlAnexo;
	}

}