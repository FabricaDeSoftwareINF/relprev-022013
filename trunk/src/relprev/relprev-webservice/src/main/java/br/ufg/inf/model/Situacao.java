package br.ufg.inf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.ufg.inf.model.support.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Entidade para persistência e retorno de JSON de situações de um relatório de prevenção
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Table(name = "situacoes")
@JsonInclude(Include.NON_EMPTY)
@JsonRootName(value = "situacao")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"versao", "new", "isHidden", "dataInsercaoAlteracao"})
public class Situacao extends AbstractEntity {

	private static final long serialVersionUID = -1792287986596099042L;

	@JsonProperty
	@Column(nullable = false, length = 5000)
	@NotNull(message = "{validation.Situacao.descricao.NotNull.message}")
	private String descricao;

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

}
