package br.ufg.inf.es.relprev.client.dominio;

import static br.ufg.inf.es.relprev.client.http.HttpClient.doGet;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doPost;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.fromJson;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.toJson;

import java.util.Date;
import java.util.List;
import java.util.Set;

import br.ufg.inf.es.relprev.client.RelPrevServicesConfig;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.RelatorioPrevencaoResponse;
import br.ufg.inf.es.relprev.client.http.response.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * User: halisson
 */
@JsonRootName(value = "relPrev")
public class RelatorioPrevencao extends ObjetoDeDominio {

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
    private final Situacao situacoes = new Situacao();

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

    private final RelPrevServicesConfig config = RelPrevServicesConfig.getInstance();

    @Override
    protected String getListURL() {
        return this.config.listRelPrevURL();
    }

    @Override
    protected String getFindByIDURL() {
        return this.config.findRelPrevURL();
    }

    @Override
    protected String getCreateURL() {
        return this.config.createRelPrevURL();
    }

    @Override
    protected String getUpdateURL() {
        return this.config.updateRelPrevURL();
    }

    @Override
    protected String getDeleteURL() {
        return this.config.deleteRelPrevURL();
    }

    @Override
    protected Class<?> getResponseClass() {
        return RelatorioPrevencaoResponse.class;
    }

    public AcaoRecomendada definaAcaoRecomendada(final AcaoRecomendada acaoRecomendada) throws RequestException {
        final String url = RelPrevServicesConfig.getInstance().addRelPrevAcaoRecomendadaURL();
        final RelatorioPrevencao relprevResponse = this.addRelationAndGetRelatorioAtualizado(url, acaoRecomendada);

        this.acaoRecomendada = relprevResponse.getAcaoRecomendada();
        acaoRecomendada.setRelPrev(this);
        return acaoRecomendada;
    }

    public Resposta definaResposta(final Resposta resposta) throws RequestException {
        final String url = RelPrevServicesConfig.getInstance().addRelPrevRespostaURL();
        final RelatorioPrevencao relprevResponse = this.addRelationAndGetRelatorioAtualizado(url, resposta);

        this.resposta = relprevResponse.getResposta();
        resposta.setRelPrev(this);
        return resposta;
    }

    public ParecerSetor definaParecerSetor(final ParecerSetor parecerSetor) throws RequestException {
        final String url = RelPrevServicesConfig.getInstance().addRelPrevParecerDoSetorURL();
        final RelatorioPrevencao relprevResponse = this.addRelationAndGetRelatorioAtualizado(url, parecerSetor);

        this.parecerSetor = relprevResponse.getParecerSetor();
        parecerSetor.setRelPrev(this);
        return parecerSetor;
    }

    public ClassificacaoRisco definaClassificacaoDeRisco(final ClassificacaoRisco classificacao) throws RequestException {
        final String url = RelPrevServicesConfig.getInstance().addRelPrevClassificadaoDeRiscoURL();
        final RelatorioPrevencao relprevResponse = this.addRelationAndGetRelatorioAtualizado(url, classificacao);

        this.classificacaoRisco = relprevResponse.getClassificacaoRisco();
        classificacao.setRelPrev(this);
        return classificacao;
    }

    public Encaminhamento definaEncaminhamento(final Encaminhamento encaminhamento) throws RequestException {
        final String url = RelPrevServicesConfig.getInstance().addRelPrevEncaminhamentoURL();
        final RelatorioPrevencao relprevResponse = this.addRelationAndGetRelatorioAtualizado(url, encaminhamento);

        this.encaminhamento = relprevResponse.getEncaminhamento();
        encaminhamento.setRelPrev(this);
        return encaminhamento;
    }

    public Observacao definaObservacao(final Observacao observacao) throws RequestException {
        final String url = RelPrevServicesConfig.getInstance().addRelPrevObservacaoURL();
        final RelatorioPrevencao relprevResponse = this.addRelationAndGetRelatorioAtualizado(url, observacao);

        this.observacao = relprevResponse.getObservacao();
        observacao.setRelPrev(this);
        return observacao;
    }

    public static List<RelatorioPrevencao> findRelPrevByLocal(final String local) throws RequestException {
        if (local == null || local.isEmpty()) {
            throw new IllegalArgumentException("O local é obrigatório");
        }
        final String url = RelPrevServicesConfig.getInstance().findRelPrevByLocalURL() + local;
        return findBy(url);
    }

    public static List<RelatorioPrevencao> findRelPrevByDescricao(final String descricao) throws RequestException {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("A descrição é obrigatória");
        }
        final String url = RelPrevServicesConfig.getInstance().findRelPrevByDescricaoURL() + descricao;
        return findBy(url);
    }

    private RelatorioPrevencao addRelationAndGetRelatorioAtualizado(final String url, final Object objeto)
            throws RequestException {
        if (this.getId() == null) {
            throw new IllegalStateException("Não é possível adicionar uma relação à um objeto não persistido");
        }

        final RelatorioPrevencaoResponse response = fromJson(doPost(url, toJson(objeto)), RelatorioPrevencaoResponse.class);

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return response.getData().get(0);
    }

    private static List<RelatorioPrevencao> findBy(final String url) throws RequestException {
        final Response<RelatorioPrevencao> response = fromJson(doGet(url), RelatorioPrevencaoResponse.class);
        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }
        return response.getData();
    }

}
