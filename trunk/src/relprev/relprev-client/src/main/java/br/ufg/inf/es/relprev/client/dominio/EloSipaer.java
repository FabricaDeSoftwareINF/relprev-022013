package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.EloSipaerResponse;
import br.ufg.inf.es.relprev.client.http.response.RelprevResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static br.ufg.inf.es.relprev.client.RelprevConfig.*;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doGet;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doPost;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.fromJson;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.toJson;

/**
 * User: halisson
 * Date: 11/9/13
 * Time: 12:25 AM
 */
public class EloSipaer extends ObjetoDeDominio {
    private static final long serialVersionUID = 3850763253702817582L;
    @JsonProperty
    private String organizacao;
    @JsonProperty(value = "sigla")
    private String sigla;

    public List<EloSipaer> list() throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_ELO_SIPAER;
        return ((EloSipaerResponse) (fromJson(doGet(url), EloSipaerResponse.class))).getData();
    }

    public EloSipaer get(Integer id) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_ELO_SIPAER + "/" + id;
        return ((EloSipaerResponse) (fromJson(doGet(url), EloSipaerResponse.class))).getData().get(0);
    }

    public EloSipaer save() throws RequestException {
        //TODO: Corrigir para preencher propriedades de acordo com response
        String url = URL_SERVIDOR + "/" + CONTROLLER_ELO_SIPAER + "/" + ACTION_CREATE;
        RelprevResponse response = (RelprevResponse) fromJson(doPost(url, toJson(this)), RelprevResponse.class);
        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return this;
    }

    public EloSipaer delete() {
        return null;
    }

    public String getOrganizacao() {
        return this.organizacao;
    }

    public void setOrganizacao(final String organizacao) {
        this.organizacao = organizacao;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(final String siglaOrganizacao) {
        this.sigla = siglaOrganizacao;
    }
}
