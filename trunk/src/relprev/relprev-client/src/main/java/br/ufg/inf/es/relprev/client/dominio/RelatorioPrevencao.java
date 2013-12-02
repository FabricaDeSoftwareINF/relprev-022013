package br.ufg.inf.es.relprev.client.dominio;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import br.ufg.inf.es.relprev.client.http.response.RelatorioPrevencaoResponse;

import static br.ufg.inf.es.relprev.client.RelprevConfig.*;

/**
 * User: halisson
 */
@JsonInclude(Include.NON_EMPTY)
@JsonRootName(value = "relPrev")
public class RelatorioPrevencao extends ObjetoDeDominio {

    private static final long serialVersionUID = -2567465353998731784L;

    private static final String RELPREV = "relPrev";

    @JsonProperty
    private String envolvidos;

    @JsonProperty
    private String local;

    @JsonProperty(value = "descricao")
    private String descricaoSituacaoPerigosa;

    @JsonProperty(value = "data")
    private Date dataSituacaoPerigosa;

    @JsonProperty(value = "situacao")
    private String situacao;

    @JsonProperty
    private EloSipaer eloSipaer;

    @JsonProperty
    private Relator relator;

    @JsonProperty
    private Situacao situacoes;

    @JsonProperty(value = "anexos")
    private Set<Anexo> anexos;

    @JsonProperty
    private AcaoRecomendada acaoRecomendada;

    @JsonProperty
    private ClassificacaoRisco classificacaoRisco;

    @JsonProperty
    private Encaminhamento encaminhamento;

    @JsonProperty
    private Observacao observacao;

    @JsonProperty
    private ParecerSetor parecerSetor;

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

    public AcaoRecomendada getAcaoRecomendada() {
        return this.acaoRecomendada;
    }

    public void setAcaoRecomendada(final AcaoRecomendada acaoRecomendada) {
        this.acaoRecomendada = acaoRecomendada;
    }

    public ClassificacaoRisco getClassificacaoRisco() {
        return this.classificacaoRisco;
    }

    public void setClassificacaoRisco(final ClassificacaoRisco classificacaoRisco) {
        this.classificacaoRisco = classificacaoRisco;
    }

    public Encaminhamento getEncaminhamento() {
        return this.encaminhamento;
    }

    public void setEncaminhamento(final Encaminhamento encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public Observacao getObservacao() {
        return this.observacao;
    }

    public void setObservacao(final Observacao observacao) {
        this.observacao = observacao;
    }

    public ParecerSetor getParecerSetor() {
        return this.parecerSetor;
    }

    public void setParecerSetor(final ParecerSetor parecerSetor) {
        this.parecerSetor = parecerSetor;
    }

    public Resposta getResposta() {
        return this.resposta;
    }

    public void setResposta(final Resposta resposta) {
        this.resposta = resposta;
    }

    @Override
    protected String getController() {
        return CONTROLLER_RELPREV;
    }

    @Override
    protected Class getResponseClass() {
        return RelatorioPrevencaoResponse.class;
    }
}
