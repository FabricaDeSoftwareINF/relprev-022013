package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.JsonConverter;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.RelprevResponse;
import br.ufg.inf.es.relprev.client.http.response.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static br.ufg.inf.es.relprev.client.RelprevConfig.ACTION_CREATE;
import static br.ufg.inf.es.relprev.client.RelprevConfig.CONTROLLER_ELO_SIPAER;
import static br.ufg.inf.es.relprev.client.RelprevConfig.URL_SERVIDOR;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doGet;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doPost;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.fromJson;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.toJson;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 11:55 PM
 */
public abstract class ObjetoDeDominio {
    @JsonProperty
    protected Integer id;

    public abstract List list() throws RequestException;
    public abstract ObjetoDeDominio get(Integer id) throws RequestException;
    public abstract ObjetoDeDominio save() throws RequestException;
    public abstract ObjetoDeDominio delete() throws RequestException;
}
