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
import javax.persistence.OneToOne;
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
public class RelatorioPrevencao extends AbstractEntity<RelatorioPrevencao> {

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

    @ManyToOne
    @JsonProperty
    @JoinColumn(name = "elosipaer_id")
    private EloSipaer eloSipaer; // TODO não existe na EOR esta associação. Confirmar como ficará

    @JsonProperty
    @JoinColumn(name = "relator_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Relator relator;

    @JsonProperty
    @JoinColumn(name = "situacoes_id")
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.EAGER)
    private Situacao situacoes;

    @JoinColumn(name = "relprev_id")
    @JsonProperty(value = "anexos")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Anexo> anexos;

    @JsonProperty
    @OneToOne(mappedBy = "relPrev", fetch = FetchType.EAGER)
    private AcaoRecomendada acaoRecomendada;

    @JsonProperty
    @OneToOne(mappedBy = "relPrev", fetch = FetchType.EAGER)
    private ClassificacaoRisco classificacaoRisco;

    @JsonProperty
    @OneToOne(mappedBy = "relPrev", fetch = FetchType.EAGER)
    private Encaminhamento encaminhamento;

    @JsonProperty
    @OneToOne(mappedBy = "relPrev", fetch = FetchType.EAGER)
    private Observacao observacao;

    @JsonProperty
    @OneToOne(mappedBy = "relPrev", fetch = FetchType.EAGER)
    private ParecerSetor parecerSetor;

    @JsonProperty
    @OneToOne(mappedBy = "relPrev", fetch = FetchType.EAGER)
    private Resposta resposta;

    public String getEnvolvidos() { // NOSONAR
        return this.envolvidos;
    }

    public void setEnvolvidos(final String envolvidos) { // NOSONAR
        this.envolvidos = envolvidos;
    }

    public String getLocal() { // NOSONAR
        return this.local;
    }

    public void setLocal(final String local) { // NOSONAR
        this.local = local;
    }

    public String getDescricaoSituacaoPerigosa() { // NOSONAR
        return this.descricaoSituacaoPerigosa;
    }

    public void setDescricaoSituacaoPerigosa(final String descricaoSituacaoPerigosa) { // NOSONAR
        this.descricaoSituacaoPerigosa = descricaoSituacaoPerigosa;
    }

    public Date getDataSituacaoPerigosa() { // NOSONAR
        return this.dataSituacaoPerigosa;
    }

    public void setDataSituacaoPerigosa(final Date dataSituacaoPerigosa) { // NOSONAR
        this.dataSituacaoPerigosa = dataSituacaoPerigosa;
    }

    public String getSituacao() { // NOSONAR
        return this.situacao;
    }

    public void setSituacao(final String situacao) { // NOSONAR
        this.situacao = situacao;
    }

    public EloSipaer getEloSipaer() { // NOSONAR
        return this.eloSipaer;
    }

    public void setEloSipaer(final EloSipaer eloSipaer) { // NOSONAR
        this.eloSipaer = eloSipaer;
    }

    public Relator getRelator() { // NOSONAR
        return this.relator;
    }

    public Situacao getSituacoes() { // NOSONAR
        return this.situacoes;
    }

    public void setSituacoes(final Situacao situacoes) { // NOSONAR
        this.situacoes = situacoes;
    }

    public void setRelator(final Relator relator) { // NOSONAR
        this.relator = relator;
    }

    public Set<Anexo> getAnexos() { // NOSONAR
        return this.anexos;
    }

    public void setAnexos(final Set<Anexo> anexos) { // NOSONAR
        this.anexos = anexos;
    }

    public AcaoRecomendada getAcaoRecomendada() { // NOSONAR
        return this.acaoRecomendada;
    }

    public void setAcaoRecomendada(final AcaoRecomendada acaoRecomendada) { // NOSONAR
        this.acaoRecomendada = acaoRecomendada;
    }

    public ClassificacaoRisco getClassificacaoRisco() { // NOSONAR
        return this.classificacaoRisco;
    }

    public void setClassificacaoRisco(final ClassificacaoRisco classificacaoRisco) { // NOSONAR
        this.classificacaoRisco = classificacaoRisco;
    }

    public Encaminhamento getEncaminhamento() { // NOSONAR
        return this.encaminhamento;
    }

    public void setEncaminhamento(final Encaminhamento encaminhamento) { // NOSONAR
        this.encaminhamento = encaminhamento;
    }

    public Observacao getObservacao() { // NOSONAR
        return this.observacao;
    }

    public void setObservacao(final Observacao observacao) { // NOSONAR
        this.observacao = observacao;
    }

    public ParecerSetor getParecerSetor() { // NOSONAR
        return this.parecerSetor;
    }

    public void setParecerSetor(final ParecerSetor parecerSetor) { // NOSONAR
        this.parecerSetor = parecerSetor;
    }

    public Resposta getResposta() { // NOSONAR
        return this.resposta;
    }

    public void setResposta(final Resposta resposta) { // NOSONAR
        this.resposta = resposta;
    }

}
