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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e representação JSON sobre as ações recomendadas pelo OSV sobre a situação de Risco
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@JsonInclude(Include.NON_EMPTY)
@Table(name = "acoes_recomendadas")
@Updatable(newinsert = true, updatable = false)
public class AcaoRecomendada extends AbstractEntity<AcaoRecomendada> {

    private static final long serialVersionUID = 485557117602416591L;

    @JsonProperty
    @JoinColumn(name = "analise_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Analise analise;

    @JsonProperty
    @Column(length = 60, nullable = false)
    @NotNull(message = "{validation.AbstractInteracao.remetente.NotNull.message}")
    @Size(min = 1, message = "{validation.AbstractInteracao.remetente.Size.message}")
    private String remetente;

    @JsonProperty
    @Column(length = 60, nullable = false)
    @NotNull(message = "{validation.AbstractInteracao.destinatario.NotNull.message}")
    @Size(min = 1, message = "{validation.AbstractInteracao.destinatario.Size.message}")
    private String destinatario;

    @JsonProperty
    @Column(length = 600, nullable = false)
    @NotNull(message = "{validation.AbstractInteracao.descricao.NotNull.message}")
    @Size(min = 1, message = "{validation.AbstractInteracao.descricao.Size.message}")
    private String descricao;

    @JsonProperty
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "{validation.AcaoRecomendada.data.NotNull.message}")
    private Date data;

    public Analise getAnalise() {
        return this.analise;
    }

    public void setAnalise(final Analise analise) {
        this.analise = analise;
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
