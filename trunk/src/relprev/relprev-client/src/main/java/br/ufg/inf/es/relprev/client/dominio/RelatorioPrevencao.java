package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.RelatorioPrevencaoResponse;
import br.ufg.inf.es.relprev.client.http.response.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static br.ufg.inf.es.relprev.client.RelprevConfig.*;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doGet;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doPost;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.fromJson;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.toJson;

/**
 * User: halisson
 */
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

    @JsonInclude(JsonInclude.Include.ALWAYS)
    @JsonProperty
    private Situacao situacoes = new Situacao();

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

    public Relator getRelator() {
        return this.relator;
    }

    public Situacao getSituacoes() {
        return this.situacoes;
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

    public ClassificacaoRisco getClassificacaoRisco() {
        return this.classificacaoRisco;
    }

    public Encaminhamento getEncaminhamento() {
        return this.encaminhamento;
    }

    public Observacao getObservacao() {
        return this.observacao;
    }

    public ParecerSetor getParecerSetor() {
        return this.parecerSetor;
    }

    public Resposta getResposta() {
        return this.resposta;
    }

    @Override
    protected String getController() {
        return CONTROLLER_RELPREV;
    }

    @Override
    protected Class getResponseClass() {
        return RelatorioPrevencaoResponse.class;
    }

    public AcaoRecomendada definaAcaoRecomendada(AcaoRecomendada acaoRecomendada) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + this.id + "/" + ACTION_SET_ACAO_RECOMENDADA;
        RelatorioPrevencao relprevResponse = addRelationAndGetRelatorioAtualizado(url, acaoRecomendada);

        this.acaoRecomendada = relprevResponse.getAcaoRecomendada();
        acaoRecomendada.setRelPrev(this);
        return acaoRecomendada;
    }

    public Resposta definaResposta(Resposta resposta) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + this.id + "/" + ACTION_SET_RESPOSTA;
        RelatorioPrevencao relprevResponse = addRelationAndGetRelatorioAtualizado(url, resposta);

        this.resposta = relprevResponse.getResposta();
        resposta.setRelPrev(this);
        return resposta;
    }

    public ParecerSetor definaParecerSetor(ParecerSetor parecerSetor) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + this.id + "/" + ACTION_SET_PARECER_SETOR;
        RelatorioPrevencao relprevResponse = addRelationAndGetRelatorioAtualizado(url, parecerSetor);

        this.parecerSetor = relprevResponse.getParecerSetor();
        parecerSetor.setRelPrev(this);
        return parecerSetor;
    }

    public ClassificacaoRisco definaClassificacaoDeRisco(ClassificacaoRisco classificacao) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + this.id + "/" + ACTION_SET_CLASSIFICACAO_DE_RISCO;
        RelatorioPrevencao relprevResponse = addRelationAndGetRelatorioAtualizado(url, classificacao);

        this.classificacaoRisco = relprevResponse.getClassificacaoRisco();
        classificacao.setRelPrev(this);
        return classificacao;
    }

    public Encaminhamento definaEncaminhamento(Encaminhamento encaminhamento) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + this.id + "/" + ACTION_SET_ENCAMINHAMENTO;
        RelatorioPrevencao relprevResponse = addRelationAndGetRelatorioAtualizado(url, encaminhamento);

        this.encaminhamento = relprevResponse.getEncaminhamento();
        encaminhamento.setRelPrev(this);
        return encaminhamento;
    }

    public Observacao definaObservacao(Observacao observacao) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + this.id + "/" + ACTION_SET_OBSERVACAO;
        RelatorioPrevencao relprevResponse = addRelationAndGetRelatorioAtualizado(url, observacao);

        this.observacao = relprevResponse.getObservacao();
        observacao.setRelPrev(this);
        return observacao;
    }

    static List<RelatorioPrevencao> findRelPrevByLocal(String local) throws RequestException {
        if (local == null || local.isEmpty()) {
            throw new IllegalArgumentException("O local é obrigatório");
        }
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + ACTION_FIND_RELPREV_BY_LOCAL + "/" + local;
        return findBy(url);
    }

    static List<RelatorioPrevencao> findRelPrevByDescricao(String descricao) throws RequestException {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("A descrição é obrigatória");
        }
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + ACTION_FIND_RELPREV_BY_DESCRICAO + "/" + descricao;
        return findBy(url);
    }

    private RelatorioPrevencao addRelationAndGetRelatorioAtualizado(String url, Object objeto) throws RequestException {
        if (this.id == null) {
            throw new IllegalStateException("Não é possível adicionar uma relação à um objeto não persistido");
        }

        RelatorioPrevencaoResponse response = (RelatorioPrevencaoResponse) fromJson(doPost(url, toJson(objeto)), RelatorioPrevencaoResponse.class);

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return response.getData().get(0);
    }

    private static List<RelatorioPrevencao> findBy(String url) throws RequestException {
        Response response = (Response) fromJson(doGet(url), RelatorioPrevencaoResponse.class);
        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }
        return response.getData();
    }
}