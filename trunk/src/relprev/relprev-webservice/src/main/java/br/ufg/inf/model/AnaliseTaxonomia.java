package br.ufg.inf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Hiddenable
@JsonInclude(Include.NON_EMPTY)
@Table(name = "analises_taxonomia")
@Updatable(newinsert = true, updatable = false)
public class AnaliseTaxonomia extends AbstractEntity<AnaliseTaxonomia> {

    private static final long serialVersionUID = -3558622120537900967L;

    @JsonProperty
    @JoinColumn(name = "analise_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Analise analise;

    @JsonProperty
    @JoinColumn(name = "taxonomia_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Taxonomia taxonomia;

    @JsonProperty
    @JoinColumn(name = "categoria_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Categoria categoria;

    public Analise getAnalise() {
        return this.analise;
    }

    public void setAnalise(final Analise analise) {
        this.analise = analise;
    }

    public Taxonomia getTaxonomia() {
        return this.taxonomia;
    }

    public void setTaxonomia(final Taxonomia taxonomia) {
        this.taxonomia = taxonomia;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(final Categoria categoria) {
        this.categoria = categoria;
    }

}
