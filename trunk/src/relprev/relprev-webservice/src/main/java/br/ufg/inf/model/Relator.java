package br.ufg.inf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Telefone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Entidade para persistência e retorno de JSON de relatores de um relatório de prevenção
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Table(name = "relatores")
@JsonInclude(Include.NON_EMPTY)
@JsonRootName(value = "relator")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"versao", "new", "isHidden", "dataInsercaoAlteracao"})
public class Relator extends AbstractEntity {

	private static final long serialVersionUID = -671624807223719350L;

	@JsonProperty
	@Column(length = 120)
	private String nome;

	@JsonProperty
	@Column(length = 20)
	@Telefone(message = "{validation.Relator.telefone.Telefone.message}")
	private String telefone;

	@JsonProperty
	@Column(length = 120)
	@Email(message = "{validation.Relator.email.Email.message}")
	private String email;

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
