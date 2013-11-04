package br.ufg.inf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufg.inf.model.support.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Entidade para persistência e representação de um Elo SIPAER
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Table(name = "elos_sipaer")
@JsonInclude(Include.NON_EMPTY)
@JsonRootName(value = "eloSipaer")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"versao", "new", "isHidden", "dataInsercaoAlteracao"})
public class EloSipaer extends AbstractEntity {

	private static final long serialVersionUID = 3850763253702817582L;

	@JsonProperty
	@Column(nullable = false, length = 100)
	@NotNull(message = "{validation.EloSipaer.organizacao.NotNull.message}")
	@Size(min = 1, max = 100, message = "{validation.EloSipaer.organizacao.Size.message}")
	private String organizacao;

	@JsonProperty(value = "sigla")
	@Column(name = "sigla_organizacao", nullable = false, length = 10)
	@NotNull(message = "{validation.EloSipaer.siglaOrganizacao.NotNull.message}")
	@Size(min = 1, max = 10, message = "{validation.EloSipaer.siglaOrganizacao.Size.message}")
	private String siglaOrganizacao;

	public String getOrganizacao() {
		return this.organizacao;
	}

	public void setOrganizacao(final String organizacao) {
		this.organizacao = organizacao;
	}

	public String getSiglaOrganizacao() {
		return this.siglaOrganizacao;
	}

	public void setSiglaOrganizacao(final String siglaOrganizacao) {
		this.siglaOrganizacao = siglaOrganizacao;
	}

}
