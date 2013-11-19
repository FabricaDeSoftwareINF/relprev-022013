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
@Table(name = "analises")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Analise extends AbstractEntity<Analise> {

    private static final long serialVersionUID = 2393867123956873223L;

    @JsonProperty
    @JoinColumn(name = "relprev_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private RelPrev relPrev;

    public RelPrev getRelPrev() {
        return this.relPrev;
    }

    public void setRelPrev(final RelPrev relPrev) {
        this.relPrev = relPrev;
    }

}
