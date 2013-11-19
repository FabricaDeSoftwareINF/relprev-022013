package br.ufg.inf.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e representação JSON dos pareceres do setor em relação à situação de perigo
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@Table(name = "pareceres_setor")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class ParecerSetor extends AbstractEntity<ParecerSetor> {

    private static final long serialVersionUID = -2223879036406313667L;

    @JsonProperty
    @JoinColumn(name = "analise_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Analise analise;

    @JsonProperty
    @Column(length = 600, nullable = false)
    @NotNull(message = "{validation.ParecerSetor.descricao.NotNull.message}")
    @Size(min = 1, max = 600, message = "{validation.ParecerSetor.descricao.Size.message}")
    private String descricao;

    @JsonProperty
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Future(message = "{validation.ParecerSetor.data.Future.message}")
    @NotNull(message = "{validation.ParecerSetor.data.NotNull.message}")
    private Date data;

    public Analise getAnalise() {
        return this.analise;
    }

    public void setAnalise(final Analise analise) {
        this.analise = analise;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(final Date data) {
        this.data = data;
    }

}
