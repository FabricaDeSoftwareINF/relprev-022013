package br.ufg.inf.service.support;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import br.ufg.inf.model.support.AbstractEntity;
/**
 * Testes para RESTErrorHandler
 * @author Raul
 *
 */
@Ignore
public class RESTErrorHandlerTest<E extends AbstractEntity<E>> {
	@Mock
	private HttpClientErrorException clientException;
	
	@Mock
	private HttpServerErrorException serverException;
	
	private RESTErrorHandler<E> restErrorHandler;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		restErrorHandler = new RESTErrorHandler<E>();
	}

	@Test
	public void testProcessHttpClientErrorException() {
		Response<E> r = restErrorHandler.processHttpClientErrorException(clientException);
		assertNotNull(r);
	}
	
	@Test
	public void testProcessHttpServerErrorException() {
		Response<E> r = restErrorHandler.processHttpServerErrorException(serverException);
		assertNotNull(r);
	}
	
}
