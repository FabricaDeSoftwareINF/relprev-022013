package br.ufg.inf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "relatorio_taxonomia")
@Updatable(newinsert = true, updatable = false)
public class RelatorioTaxonomia extends AbstractEntity<RelatorioTaxonomia> {

    private static final long serialVersionUID = -3558622120537900967L;

    @JsonProperty
    @OneToOne(optional = false)
    @JoinColumn(name = "relprev_id")
    private RelatorioPrevencao relPrev;

    @JsonProperty
    @JoinColumn(name = "taxonomia_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Taxonomia taxonomia;

    @JsonProperty
    @JoinColumn(name = "categoria_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Categoria categoria;

    public RelatorioPrevencao getRelPrev() { // NOSONAR
        return this.relPrev;
    }

    public void setRelPrev(final RelatorioPrevencao relPrev) { // NOSONAR
        this.relPrev = relPrev;
    }

    public Taxonomia getTaxonomia() { // NOSONAR
        return this.taxonomia;
    }

    public void setTaxonomia(final Taxonomia taxonomia) { // NOSONAR
        this.taxonomia = taxonomia;
    }

    public Categoria getCategoria() { // NOSONAR
        return this.categoria;
    }

    public void setCategoria(final Categoria categoria) { // NOSONAR
        this.categoria = categoria;
    }

}
