package br.ufg.inf.es.relprev.client.dominio.tests.http;

import br.ufg.inf.es.relprev.client.http.HttpClient;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import junit.framework.TestCase;

import java.io.IOException;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 9:20 PM
 */
public class HttpClientTests extends TestCase {
    HttpClient httpClient = new HttpClient();

    public void testAASHKAKJS() throws IOException, RequestException {
        String response = httpClient.doGet("http://localhost:8090/relprev/2");
        System.out.println(response);
    }
}
