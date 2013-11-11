package br.ufg.inf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e retorno de JSON de situações de um relatório de prevenção
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@Table(name = "situacoes")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Situacao extends AbstractEntity<Situacao> {

    private static final long serialVersionUID = -1792287986596099042L;

    @JsonProperty
    @Column(nullable = false, length = 5000)
    @NotNull(message = "{validation.Situacao.descricao.NotNull.message}")
    @Size(min = 1, message = "{validation.Situacao.descricao.Size.message}")
    private String descricao;

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

}
