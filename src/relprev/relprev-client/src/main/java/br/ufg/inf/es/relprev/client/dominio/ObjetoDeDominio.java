package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static br.ufg.inf.es.relprev.client.RelprevConfig.ACTION_CREATE;
import static br.ufg.inf.es.relprev.client.RelprevConfig.URL_SERVIDOR;
import static br.ufg.inf.es.relprev.client.http.HttpClient.*;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.fromJson;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.toJson;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 11:55 PM
 */
public abstract class ObjetoDeDominio {
    @JsonProperty
    public Integer id;

    public Integer getId() {
        return id;
    }

    public List list() throws RequestException {
        String url = URL_SERVIDOR + "/" + getController();

        Response response = ((Response) (fromJson(doGet(url), getResponseClass())));

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return response.getData();
    }

    public ObjetoDeDominio get(Integer id) throws RequestException {
        String url = URL_SERVIDOR + "/" + getController() + "/" + id;
        Response response = ((Response) (fromJson(doGet(url), getResponseClass())));
        return (ObjetoDeDominio) response.getData().get(0);
    }

    public ObjetoDeDominio save() throws RequestException {
        Response response = null;
        if (this.getId() == null) {
            String url = URL_SERVIDOR + "/" + getController() + "/" + ACTION_CREATE;
            response = (Response) fromJson(doPost(url, toJson(this)), getResponseClass());
            this.id = ((ObjetoDeDominio) response.getData().get(0)).id;
        } else {
            String url = URL_SERVIDOR + "/" + getController() + "/" + ACTION_CREATE;
            response = (Response) fromJson(doPut(url, toJson(this)), getResponseClass());
        }

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return this;
    }

    public ObjetoDeDominio delete() throws RequestException {
        String url = URL_SERVIDOR + "/" + getController() + id;
        Response response = (Response) fromJson(doDelete(url), getResponseClass());

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return this;
    }

    protected abstract String getController();

    protected abstract Class getResponseClass();
}
