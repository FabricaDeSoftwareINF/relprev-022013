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
 * Entidade para persistência e representação JSON sobre a resposta realizada pelo OSV
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see AbstractInteracao
 */
@Entity
@Hiddenable
@Table(name = "respostas")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Resposta extends AbstractEntity<Resposta> {

    private static final long serialVersionUID = -7029497486055552998L;

    @JsonProperty
    @JoinColumn(name = "analise_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Analise analise;

    @JsonProperty
    @Column(length = 60, nullable = false)
    @NotNull(message = "{validation.Resposta.remetente.NotNull.message}")
    @Size(min = 1, message = "{validation.Resposta.remetente.Size.message}")
    private String remetente;

    @JsonProperty
    @Column(length = 60, nullable = false)
    @NotNull(message = "{validation.Resposta.destinatario.NotNull.message}")
    @Size(min = 1, message = "{validation.Resposta.destinatario.Size.message}")
    private String destinatario;

    @JsonProperty
    @Column(length = 600, nullable = false)
    @NotNull(message = "{validation.Resposta.descricao.NotNull.message}")
    @Size(min = 1, message = "{validation.Resposta.descricao.Size.message}")
    private String descricao;

    @JsonProperty
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Future(message = "{validation.Resposta.data.Future.message}")
    @NotNull(message = "{validation.Resposta.data.NotNull.message}")
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
