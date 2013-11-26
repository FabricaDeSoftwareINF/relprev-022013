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
import br.ufg.inf.model.support.ModelConstantNumbers;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e representação JSON sobre o Encaminhamento realizado pelo OSV
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see AbstractInteracao
 */
@Entity
@Hiddenable
@Table(name = "encaminhamentos")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Encaminhamento extends AbstractEntity<Encaminhamento> {

    private static final long serialVersionUID = 3651594571617958528L;

    @JsonIgnore
    @OneToOne(optional = false)
    @JoinColumn(name = "relprev_id")
    private RelatorioPrevencao relPrev;

    @JsonProperty
    @Column(length = ModelConstantNumbers.COLUMN_SIZE_60, nullable = false)
    @NotNull(message = "{validation.AbstractInteracao.remetente.NotNull.message}")
    @Size(min = ModelConstantNumbers.FIELD_SIZE_1, message = "{validation.AbstractInteracao.remetente.Size.message}")
    private String remetente;

    @JsonProperty
    @Column(length = ModelConstantNumbers.COLUMN_SIZE_60, nullable = false)
    @NotNull(message = "{validation.AbstractInteracao.destinatario.NotNull.message}")
    @Size(min = ModelConstantNumbers.FIELD_SIZE_1, message = "{validation.AbstractInteracao.destinatario.Size.message}")
    private String destinatario;

    @JsonProperty
    @Column(length = ModelConstantNumbers.COLUMN_SIZE_600, nullable = false)
    @NotNull(message = "{validation.AbstractInteracao.descricao.NotNull.message}")
    @Size(min = ModelConstantNumbers.FIELD_SIZE_1, message = "{validation.AbstractInteracao.descricao.Size.message}")
    private String descricao;

    @JsonProperty
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "{validation.Encaminhamento.data.NotNull.message}")
    private Date data;

    public RelatorioPrevencao getRelPrev() {
        return this.relPrev;
    }

    public void setRelPrev(final RelatorioPrevencao relPrev) {
        this.relPrev = relPrev;
    }

    public String getRemetente() {
        return this.remetente;
    }

    public void setRemetente(final String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(final String destinatario) {
        this.destinatario = destinatario;
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
