package br.ufg.inf.model.divop;

import javax.persistence.Column;
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
 * 
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
//@Entity
@Hiddenable
@JsonInclude(Include.NON_EMPTY)
@Table(name = "categorias_divop")
@Updatable(newinsert = true, updatable = false)
public class CategoriaDIVOP extends AbstractEntity<CategoriaDIVOP> {

    private static final long serialVersionUID = 2334737609795167852L;

    @JsonProperty
    @Column(nullable = false)
    @NotNull(message = "{validation.CategoriaDIVOP.nome.NotNull.message}")
    @Size(min = 1, message = "{validation.CategoriaDIVOP.nome.Size.message}")
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

}
