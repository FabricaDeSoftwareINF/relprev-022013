package br.ufg.inf.es.relprev.client.dominio.tests.http;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Ignore;

import br.ufg.inf.es.relprev.client.http.HttpClient;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

/**
 * User: halisson
 * Date: 11/6/13
 * Time: 9:20 PM
 */
@Ignore
public class HttpClientTests extends TestCase {

    public void testAASHKAKJS() throws IOException, RequestException {
        final String response = HttpClient.doGet("http://localhost:8090/relprev/2");
        System.out.println(response);
    }

}
