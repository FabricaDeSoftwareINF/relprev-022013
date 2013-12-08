package br.ufg.inf.es.relprev.client.http;

import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;

public final class HttpClient {

    private HttpClient() {}

    public static String doGet(final String url) throws RequestException {
        try {
            return Request.Get(url).execute().returnContent().asString();
        } catch (final IOException e) {
            throw new RequestException("Erro ao tentar obter a url " + url + ": " + e.getMessage(), e);
        }
    }

    public static String doPost(final String url, final String body) throws RequestException {
        try {
            return Request.Post(url).bodyString(body, ContentType.APPLICATION_JSON).execute().returnContent().asString();
        } catch (final IOException e) {
            throw new RequestException("Erro ao tentar obter a url " + url + " com o body" + body + ": " + e.getMessage(), e);
        }
    }

    public static String doPut(final String url, final String body) throws RequestException {
        try {
            return Request.Put(url).bodyString(body, ContentType.APPLICATION_JSON).execute().returnContent().asString();
        } catch (final IOException e) {
            throw new RequestException("Erro ao tentar obter a url " + url + " com o body" + body + ": " + e.getMessage(), e);
        }
    }

    public static String doDelete(final String url) throws RequestException {
        try {
            return Request.Delete(url).execute().returnContent().asString();
        } catch (final IOException e) {
            throw new RequestException("Erro ao executar um get na url: " + e.getMessage(), e);
        }
    }

}
