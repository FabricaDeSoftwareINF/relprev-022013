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
 * Entidade para persistência e retorno de JSON de taxonomias de um relatório de prevenção
 * 
 * @created 09/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@Table(name = "taxonomias")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Taxonomia extends AbstractEntity<Taxonomia> {

    private static final long serialVersionUID = -8111373397877993819L;

    @JsonProperty
    @Column(nullable = false)
    @NotNull(message = "{validation.Taxonomia.nome.NotNull.message}")
    @Size(min = 1, message = "{validation.Taxonomia.nome.Size.message}")
    private String nome;

    @JsonProperty
    @Column(nullable = false)
    @NotNull(message = "{validation.Taxonomia.status.NotNull.message}")
    private Boolean status;

    @JsonProperty
    @Column(name = "padrao_minimo")
    private Boolean padraoMinimo;

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(final Boolean status) {
        this.status = status;
    }

    public Boolean getPadraoMinimo() {
        return this.padraoMinimo;
    }

    public void setPadraoMinimo(final Boolean padraoMinimo) {
        this.padraoMinimo = padraoMinimo;
    }

}
