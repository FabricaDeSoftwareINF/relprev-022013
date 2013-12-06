package br.ufg.inf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.ModelConstants;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToOne(optional = false)
    @JoinColumn(name = "relprev_id")
    private RelatorioPrevencao relPrev;

    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_600, nullable = false)
    @NotNull(message = "validation.ParecerSetor.descricao.NotNull.message")
    @Size(min = ModelConstants.FIELD_SIZE_1, max = ModelConstants.FIELD_SIZE_600,
        message = "validation.ParecerSetor.descricao.Size.message")
    private String descricao;

    @JsonProperty
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "validation.ParecerSetor.data.NotNull.message")
    private Date data;

    public RelatorioPrevencao getRelPrev() {
        return this.relPrev;
    }

    public void setRelPrev(final RelatorioPrevencao relPrev) {
        this.relPrev = relPrev;
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
