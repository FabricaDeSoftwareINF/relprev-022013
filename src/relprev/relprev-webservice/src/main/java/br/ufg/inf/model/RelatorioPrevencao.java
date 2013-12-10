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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.Anexo;
import br.ufg.inf.model.support.ModelConstants;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private static final String RELPREV = "relPrev";

    @JsonProperty
    @Column(nullable = false, length = ModelConstants.COLUMN_SIZE_60)
    @NotNull(message = "validation.RelatorioPrevencao.envolvidos.NotNull.message")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_60,
        message = "validation.RelatorioPrevencao.envolvidos.Size.message")
    private String envolvidos;

    @JsonProperty
    @Column(nullable = false, length = ModelConstants.COLUMN_SIZE_60)
    @NotNull(message = "validation.RelatorioPrevencao.local.NotNull.message")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_60,
        message = "validation.RelatorioPrevencao.local.Size.message")
    private String local;

    @JsonProperty(value = "descricao")
    @Column(nullable = false, name = "descricao", length = ModelConstants.COLUMN_SIZE_600)
    @NotNull(message = "validation.RelatorioPrevencao.descricaoSituacaoPerigosa.NotNull.message")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_600,
        message = "validation.RelatorioPrevencao.descricaoSituacaoPerigosa.Size.message")
    private String descricaoSituacaoPerigosa;

    @JsonProperty(value = "data")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "data")
    @Past(message = "validation.RelatorioPrevencao.dataSituacaoPerigosa.Past.message")
    @NotNull(message = "validation.RelatorioPrevencao.dataSituacaoPerigosa.NotNull.message")
    private Date dataSituacaoPerigosa;

    @JsonProperty(value = "situacao")
    @Column(name = "situacao", length = ModelConstants.COLUMN_SIZE_5000)
    private String situacao;

    @ManyToOne
    @JsonProperty
    @JoinColumn(name = "elosipaer_id")
    // TODO não existe na EOR esta associação. Confirmar como ficará
    private EloSipaer eloSipaer;

    @JsonProperty
    @JoinColumn(name = "relator_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Relator relator;

    @JsonProperty
    @JoinColumn(name = "situacoes_id")
    @NotNull(message = "validation.RelatorioPrevencao.situacoes.NotNull.message")
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.EAGER)
    private Situacao situacoes;

    @JoinColumn(name = "relprev_id")
    @JsonProperty(value = "anexos")
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Anexo> anexos;

    @JsonIgnore
    @OneToMany(mappedBy = RELPREV, fetch = FetchType.EAGER)
    private Set<AcaoRecomendada> acoesRecomendadas;

    @Transient
    @JsonProperty
    private AcaoRecomendada acaoRecomendada;

    @JsonIgnore
    @OneToMany(mappedBy = RELPREV, fetch = FetchType.EAGER)
    private Set<ClassificacaoRisco> classificacoesRisco;

    @Transient
    @JsonProperty
    private ClassificacaoRisco classificacaoRisco;

    @JsonIgnore
    @OneToMany(mappedBy = RELPREV, fetch = FetchType.EAGER)
    private Set<Encaminhamento> encaminhamentos;

    @Transient
    @JsonProperty
    private Encaminhamento encaminhamento;

    @JsonIgnore
    @OneToMany(mappedBy = RELPREV, fetch = FetchType.EAGER)
    private Set<Observacao> observacoes;

    @Transient
    @JsonProperty
    private Observacao observacao;

    @JsonIgnore
    @OneToMany(mappedBy = RELPREV, fetch = FetchType.EAGER)
    private Set<ParecerSetor> pareceresSetor;

    @Transient
    @JsonProperty
    private ParecerSetor parecerSetor;

    @JsonIgnore
    @OneToMany(mappedBy = RELPREV, fetch = FetchType.EAGER)
    private Set<Resposta> respostas;

    @Transient
    @JsonProperty
    private Resposta resposta;

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

    public Set<AcaoRecomendada> getAcoesRecomendadas() {
        return this.acoesRecomendadas;
    }

    public void setAcoesRecomendadas(final Set<AcaoRecomendada> acoesRecomendadas) {
        this.acoesRecomendadas = acoesRecomendadas;
    }

    public AcaoRecomendada getAcaoRecomendada() {
        if (this.acaoRecomendada == null && this.getAcoesRecomendadas() != null) {
            for (final AcaoRecomendada acao : this.getAcoesRecomendadas()) {
                if (!acao.getHidden()) {
                    this.setAcaoRecomendada(acao);
                    break;
                }
            }
        }
        return this.acaoRecomendada;
    }

    public void setAcaoRecomendada(final AcaoRecomendada acaoRecomendada) {
        this.acaoRecomendada = acaoRecomendada;
    }

    public Set<ClassificacaoRisco> getClassificacoesRisco() {
        return this.classificacoesRisco;
    }

    public void setClassificacoesRisco(final Set<ClassificacaoRisco> classificacoesRisco) {
        this.classificacoesRisco = classificacoesRisco;
    }

    public ClassificacaoRisco getClassificacaoRisco() {
        if (this.classificacaoRisco == null && this.getClassificacoesRisco() != null) {
            for (final ClassificacaoRisco classificacao : this.getClassificacoesRisco()) {
                if (!classificacao.getHidden()) {
                    this.setClassificacaoRisco(classificacao);
                    break;
                }
            }
        }
        return this.classificacaoRisco;
    }

    public void setClassificacaoRisco(final ClassificacaoRisco classificacaoRisco) {
        this.classificacaoRisco = classificacaoRisco;
    }

    public Set<Encaminhamento> getEncaminhamentos() {
        return this.encaminhamentos;
    }

    public void setEncaminhamentos(final Set<Encaminhamento> encaminhamentos) {
        this.encaminhamentos = encaminhamentos;
    }

    public Encaminhamento getEncaminhamento() {
        if (this.encaminhamento == null && this.getEncaminhamentos() != null) {
            for (final Encaminhamento enc : this.getEncaminhamentos()) {
                if (!enc.getHidden()) {
                    this.setEncaminhamento(enc);
                    break;
                }
            }
        }
        return this.encaminhamento;
    }

    public void setEncaminhamento(final Encaminhamento encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public Set<Observacao> getObservacoes() {
        return this.observacoes;
    }

    public void setObservacoes(final Set<Observacao> observacoes) {
        this.observacoes = observacoes;
    }

    public Observacao getObservacao() {
        if (this.observacao == null && this.getObservacoes() != null) {
            for (final Observacao obs : this.getObservacoes()) {
                if (!obs.getHidden()) {
                    this.setObservacao(obs);
                    break;
                }
            }
        }
        return this.observacao;
    }

    public void setObservacao(final Observacao observacao) {
        this.observacao = observacao;
    }

    public Set<ParecerSetor> getPareceresSetor() {
        return this.pareceresSetor;
    }

    public void setPareceresSetor(final Set<ParecerSetor> pareceresSetor) {
        this.pareceresSetor = pareceresSetor;
    }

    public ParecerSetor getParecerSetor() {
        if (this.parecerSetor == null && this.getPareceresSetor() != null) {
            for (final ParecerSetor parecer : this.getPareceresSetor()) {
                if (!parecer.getHidden()) {
                    this.setParecerSetor(parecer);
                    break;
                }
            }
        }
        return this.parecerSetor;
    }

    public void setParecerSetor(final ParecerSetor parecerSetor) {
        this.parecerSetor = parecerSetor;
    }

    public Set<Resposta> getRespostas() {
        return this.respostas;
    }

    public void setRespostas(final Set<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Resposta getResposta() {
        if (this.resposta == null && this.getRespostas() != null) {
            for (final Resposta resp : this.getRespostas()) {
                if (!resp.getHidden()) {
                    this.setResposta(resp);
                    break;
                }
            }
        }
        return this.resposta;
    }

    public void setResposta(final Resposta resposta) {
        this.resposta = resposta;
    }

}
