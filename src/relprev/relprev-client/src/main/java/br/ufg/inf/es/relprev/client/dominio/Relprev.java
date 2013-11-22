package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.RelprevResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.util.Date;
import java.util.List;

import static br.ufg.inf.es.relprev.client.RelprevConfig.*;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doGet;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doPost;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.fromJson;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.toJson;

/**
 * User: halisson Date: 11/2/13 Time: 2:17 AM
 */
public class Relprev extends ObjetoDeDominio {
    @JsonProperty
    private String local;
    @JsonProperty(value = "data")
    private Date dataHora;
    @JsonProperty(value = "envolvidos")
    private String pessoalEnvolvido;
    @JsonProperty
    private String descricao;
    private List<File> anexos;
    private Relator relator;
    private EloSipaer eloSipaer;
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    protected String getController() {
        return CONTROLLER_RELPREV;
    }

    protected Class getResponseClass() {
        return RelprevResponse.class;
    }

    public List<Relprev> list() throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV;
        return ((RelprevResponse) (fromJson(doGet(url), RelprevResponse.class))).getData();
    }

    public Relprev get(Integer id) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + id;
        return ((RelprevResponse) (fromJson(doGet(url), RelprevResponse.class))).getData().get(0);
    }

    public Relprev save() throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + ACTION_CREATE;
        RelprevResponse response = (RelprevResponse) fromJson(doPost(url, toJson(this)), RelprevResponse.class);
        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }
        return this;
    }

    public Relprev delete() {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date data) {
        this.dataHora = data;
    }

    public String getPessoalEnvolvido() {
        return pessoalEnvolvido;
    }

    public void setPessoalEnvolvido(String pessoalEnvolvido) {
        this.pessoalEnvolvido = pessoalEnvolvido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<File> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<File> anexos) {
        this.anexos = anexos;
    }

    public Relator getRelator() {
        return relator;
    }

    public void setRelator(Relator relator) {
        this.relator = relator;
    }

    public EloSipaer getEloSipaer() {
        return eloSipaer;
    }

    public void setEloSipaer(EloSipaer elosipaer) {
        this.eloSipaer = elosipaer;
    }

    @JsonIgnore
    public String getContatoRelator() {
        if (relator != null) {
            return relator.getEmail();
        }
        return "";
    }

    @JsonIgnore
    public String getNomeRelator() {
        if (relator != null) {
            return relator.getNome();
        }
        return "";
    }
}
