package br.ufg.inf.es.relprev.client.http;

import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;

public class HttpClient {
    public static String doGet(String url) throws RequestException {
        try {
            return Request.Get(url).execute().returnContent().asString();
        } catch (IOException e) {
            throw new RequestException("Erro ao tentar obter a url " + url + ": " + e.getMessage());
        }
    }

    public static String doPost(String url, String body) throws RequestException {
        try {
            return Request.Post(url)
                    .bodyString(body, ContentType.APPLICATION_JSON)
                    .execute().returnContent().asString();
        } catch (IOException e) {
            throw new RequestException("Erro ao tentar obter a url " + url + " com o body" + body + ": " + e.getMessage());
        }
    }
}
