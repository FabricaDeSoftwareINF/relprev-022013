package br.ufg.inf.es.relprev.client.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testes para {@link Configuration}
 * 
 * @created 06/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class ConfigurationTest {

    private final Configuration configuration = new Configuration("services-test");

    @Test
    public void testGetPropertyFound() {
        final String keyValue = this.configuration.getProperty("services.url");
        assertEquals(keyValue, "http://localhost:8080/services");
    }

    @Test(expected = RuntimeException.class)
    public void testGetPropertyNotFound() {
        this.configuration.getProperty("key.not.found");
    }

    @Test(expected = RuntimeException.class)
    public void testConfigurationFileNotFound() {
        new Configuration("service-notfound");
    }

}
