package br.ufg.inf.service.support;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import br.ufg.inf.model.support.AbstractEntity;

/**
 * Testes para RESTErrorHandler
 * 
 * @author Raul
 * 
 */
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class RESTErrorHandlerTest<E extends AbstractEntity<E>> {

    @Mock
    private HttpClientErrorException clientException;

    @Mock
    private HttpServerErrorException serverException;

    @Mock
    private RESTErrorHandler<E> restErrorHandler;

    @Before
    public void setUp() {}

    @Test
    public void testProcessHttpClientErrorException() {
        final Response<E> r = this.restErrorHandler.processHttpClientErrorException(this.clientException);
        assertNull(r);
    }

    @Test
    public void testProcessHttpServerErrorException() {
        final Response<E> r = this.restErrorHandler.processHttpServerErrorException(this.serverException);
        assertNull(r);
    }

}
