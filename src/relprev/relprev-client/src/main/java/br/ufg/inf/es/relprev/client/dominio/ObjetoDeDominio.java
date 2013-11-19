package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static br.ufg.inf.es.relprev.client.RelprevConfig.*;
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

    public List list() throws RequestException {
        String url = URL_SERVIDOR + "/" + getController();
        return ((Response) (fromJson(doGet(url), getResponseClass()))).getData();
    }

    public ObjetoDeDominio get(Integer id) throws RequestException {
        String url = URL_SERVIDOR + "/" + getController() + "/" + id;
        return (ObjetoDeDominio) ((Response) (fromJson(doGet(url), getResponseClass()))).getData().get(0);
    }

    public ObjetoDeDominio save() throws RequestException {
        String url = URL_SERVIDOR + "/" + CONTROLLER_RELPREV + "/" + ACTION_CREATE;
        Response response = (Response) fromJson(doPost(url, toJson(this)), getResponseClass());
        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }
        this.id = ((ObjetoDeDominio) response.getData().get(0)).id;
        return this;
    }

    public ObjetoDeDominio delete() {
        return null;
    }

    protected abstract String getController();

    protected abstract Class getResponseClass();
}
