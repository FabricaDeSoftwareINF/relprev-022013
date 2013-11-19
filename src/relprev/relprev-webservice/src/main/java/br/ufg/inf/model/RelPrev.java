package br.ufg.inf.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.Anexo;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Entidade para persistência e retorno de JSON de relatórios de prevenção
 *
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@JsonInclude(Include.NON_EMPTY)
@JsonRootName(value = "relPrev")
@Table(name = "relatorios_prevencao")
@Updatable(newinsert = true, updatable = false)
public class RelPrev extends AbstractEntity<RelPrev> {

    private static final long serialVersionUID = -2567465353998731784L;

    @JsonProperty
    @Column(nullable = false, length = 60)
    @NotNull(message = "{validation.RelPrev.envolvidos.NotNull.message}")
    @Size(min = 1, max = 60, message = "{validation.RelPrev.envolvidos.Size.message}")
    private String envolvidos;

    @JsonProperty
    @Column(nullable = false, length = 60)
    @NotNull(message = "{validation.RelPrev.local.NotNull.message}")
    @Size(min = 1, max = 60, message = "{validation.RelPrev.local.Size.message}")
    private String local;

    @JsonProperty(value = "descricao")
    @Column(nullable = false, name = "descricao", length = 600)
    @NotNull(message = "{validation.RelPrev.descricaoSituacaoPerigosa.NotNull.message}")
    @Size(min = 1, max = 600, message = "{validation.RelPrev.descricaoSituacaoPerigosa.Size.message}")
    private String descricaoSituacaoPerigosa;

    @JsonProperty(value = "data")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "data")
    @Past(message = "{validation.RelPrev.dataSituacaoPerigosa.Past.message}")
    @NotNull(message = "{validation.RelPrev.dataSituacaoPerigosa.NotNull.message}")
    private Date dataSituacaoPerigosa;

    @JsonProperty(value = "situacao")
    @Column(name = "situacao", length = 5000)
    private String situacao;

    @JsonProperty
    @JoinColumn(name = "elosipaer_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private EloSipaer eloSipaer;

    @JsonProperty
    @JoinColumn(name = "relator_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Relator relator;

    @JsonProperty
    @JoinColumn(name = "situacoes_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Situacao situacoes;

    @JoinColumn(name = "relprev_id")
    @JsonProperty(value = "anexos")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Anexo> anexos;

    public String getEnvolvidos() {
        return this.envolvidos;
    }

    public void setEnvolvidos(final String envolvidos) {
        this.envolvidos = envolvidos;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(final String local) {
        this.local = local;
    }

    public String getDescricaoSituacaoPerigosa() {
        return this.descricaoSituacaoPerigosa;
    }

    public void setDescricaoSituacaoPerigosa(final String descricaoSituacaoPerigosa) {
        this.descricaoSituacaoPerigosa = descricaoSituacaoPerigosa;
    }

    public Date getDataSituacaoPerigosa() {
        return this.dataSituacaoPerigosa;
    }

    public void setDataSituacaoPerigosa(final Date dataSituacaoPerigosa) {
        this.dataSituacaoPerigosa = dataSituacaoPerigosa;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(final String situacao) {
        this.situacao = situacao;
    }

    public EloSipaer getEloSipaer() {
        return this.eloSipaer;
    }

    public void setEloSipaer(final EloSipaer eloSipaer) {
        this.eloSipaer = eloSipaer;
    }

    public Relator getRelator() {
        return this.relator;
    }

    public Situacao getSituacoes() {
        return this.situacoes;
    }

    public void setSituacoes(final Situacao situacoes) {
        this.situacoes = situacoes;
    }

    public void setRelator(final Relator relator) {
        this.relator = relator;
    }

    public Set<Anexo> getAnexos() {
        return this.anexos;
    }

    public void setAnexos(final Set<Anexo> anexos) {
        this.anexos = anexos;
    }

}
