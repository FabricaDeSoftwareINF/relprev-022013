package br.ufg.inf.service.support;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import br.ufg.inf.model.support.AbstractEntity;

/**
 * Testes para RESTErrorHandler
 * 
 * @author Raul
 */
@RunWith(MockitoJUnitRunner.class)
public class RESTErrorHandlerTest<E extends AbstractEntity<E>> {

    @Mock
    private RESTErrorHandler<E> restErrorHandler;

    @Test
    public void testProcessHttpClientErrorException() {
        final HttpClientErrorException clientException = new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        final Response<E> r = this.restErrorHandler.processHttpClientErrorException(clientException);
        assertNull(r);
    }

    @Test
    public void testProcessHttpServerErrorException() {
        final HttpServerErrorException serverException = new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        final Response<E> response = this.restErrorHandler.processHttpServerErrorException(serverException);
        assertNull(response);
    }

    @Test
    public void testProcessMethodArgumentNotValidException() {}

}
