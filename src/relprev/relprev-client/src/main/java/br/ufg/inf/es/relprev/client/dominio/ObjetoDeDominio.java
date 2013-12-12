package br.ufg.inf.es.relprev.client.dominio;

import static br.ufg.inf.es.relprev.client.http.HttpClient.doDelete;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doGet;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doPost;
import static br.ufg.inf.es.relprev.client.http.HttpClient.doPut;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.fromJson;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.toJson;

import java.util.List;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 11:55 PM
 */
public abstract class ObjetoDeDominio {

    @JsonProperty
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public List list() throws RequestException {
        final String url = this.getListURL();

        final Response response = (Response) fromJson(doGet(url), this.getResponseClass());

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return response.getData();
    }

    public ObjetoDeDominio get(final Integer id) throws RequestException {
        final String url = this.getFindByIDURL() + id;
        final Response response = (Response) fromJson(doGet(url), this.getResponseClass());
        return (ObjetoDeDominio) response.getData().get(0);
    }

    public ObjetoDeDominio save() throws RequestException {
        Response response = null;
        if (this.getId() == null) {
            response = (Response) fromJson(doPost(this.getCreateURL(), toJson(this)), this.getResponseClass());
        } else {
            response = (Response) fromJson(doPut(this.getUpdateURL(), toJson(this)), this.getResponseClass());
        }

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        this.id = response.getData() != null ? ((ObjetoDeDominio) response.getData().get(0)).id : null;
        return this;
    }

    public ObjetoDeDominio delete() throws RequestException {
        final String url = this.getDeleteURL() + this.id;
        final Response response = (Response) fromJson(doDelete(url), this.getResponseClass());

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return this;
    }

    /**
     * Recupera a URL para busca de um objeto pelo ID
     * 
     * @return URL para busca de objeto
     */
    protected abstract String getFindByIDURL();

    /**
     * Recupera a URL para listagem dos Objetos
     * 
     * @return URL para listagem dos Objetos
     */
    protected abstract String getListURL();

    /**
     * Recupera a URL para criação de um objeto
     * 
     * @return URL para criação de objeto
     */
    protected abstract String getCreateURL();

    /**
     * Recupera a URL para atualização de um objeto
     * 
     * @return URL para atualização de objeto
     */
    protected abstract String getUpdateURL();

    /**
     * Recupera a URL para remoção de um objeto
     * 
     * @return URL para remoção de objeto
     */
    protected abstract String getDeleteURL();

    protected abstract Class<?> getResponseClass();

}
