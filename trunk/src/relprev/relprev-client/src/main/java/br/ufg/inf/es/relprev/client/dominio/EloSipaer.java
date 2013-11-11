package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.RelprevResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static br.ufg.inf.es.relprev.client.RelprevConfig.ACTION_CREATE;
import static br.ufg.inf.es.relprev.client.RelprevConfig.CONTROLLER_ELO_SIPAER;
import static br.ufg.inf.es.relprev.client.RelprevConfig.URL_SERVIDOR;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doGet;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doPost;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.*;

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


    public static List<Relprev> list() throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_ELO_SIPAER;
        return ((RelprevResponse) (fromJson(doGet(url), RelprevResponse.class))).getData();
    }

    public static Relprev get(Integer id) throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_ELO_SIPAER + "/" + id;
        return ((RelprevResponse) (fromJson(doGet(url), RelprevResponse.class))).getData().get(0);
    }

    public void save() throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_ELO_SIPAER + "/" + ACTION_CREATE;
        RelprevResponse response = (RelprevResponse) fromJson(doPost(url, toJson(this)), RelprevResponse.class);
        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }
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
