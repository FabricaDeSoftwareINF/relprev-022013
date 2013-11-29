package br.ufg.inf.service.support;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.repository.support.GenericRepository;
import br.ufg.inf.repository.support.LogRepository;
/**
 * Testes para GenericWebService
 * @author Raul
 *
 */
public class GenericWebServiceTest<E extends AbstractEntity<E>, R extends GenericRepository<E, Long>> {
	@Mock
	private GenericWebService<E, R> gws;
	
	@Mock
	private R repository;
	
	@Mock
	private LogRepository logRepository;
	
	@Mock
	private E entity;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		gws = new GenericWebService<E, R>(repository, logRepository);
	}
	
	@Test
	public void testConstrutor() {
		gws = new GenericWebService<E, R>(repository, logRepository);
		assertNotNull(gws);
	}
	
	@Test
	public void testList() {
		Response<E> r = gws.list();
		assertNotNull(r);
	}
	
	@Test
	public void testListException() {
		gws = new GenericWebService<E, R>(null, logRepository);
		Response<E> r = gws.list();
		assertNotNull(r);
	}
	
	@Test
	public void testFind() {
		gws = new GenericWebService<E, R>(repository, logRepository);
		Response<E> r = gws.find(0L);
		assertNotNull(r);
	}

	@Test
	public void testFindException() {
		gws = new GenericWebService<E, R>(null, logRepository);
		Response<E> r = gws.find(0L);
		assertNotNull(r);
	}
	
	@Test
	public void testCreate() {
		gws = new GenericWebService<E, R>(repository, logRepository);
		entity.setId(1L);
		Response<E> r = gws.create(entity);
		assertNotNull(r);
	}
	
	@Test
	public void testUpdate() {
		gws = new GenericWebService<E, R>(repository, logRepository);
		Response<E> r = gws.update(entity);
		assertNotNull(r);
	}
	
	//@Test
	public void testDelete() {
		gws = new GenericWebService<E, R>(repository, logRepository);
		entity.setId(1L);
		Response<E> r = gws.create(entity);
		r = gws.delete(0L);
		assertNotNull(r);
	}
}
