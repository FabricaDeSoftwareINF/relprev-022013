package br.ufg.inf.service.support;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.repository.support.GenericRepository;
import br.ufg.inf.repository.support.LogRepository;

/**
 * Testes para GenericWebService
 * 
 * @author Raul
 * 
 */
@RunWith(MockitoJUnitRunner.class)
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
    public void setUp() {
        this.gws = new GenericWebService<E, R>(this.repository, this.logRepository);
    }

    @Test
    public void testConstrutor() {
        this.gws = new GenericWebService<E, R>(this.repository, this.logRepository);
        assertNotNull(this.gws);
    }

    @Test
    public void testList() {
        final Response<E> r = this.gws.list();
        assertNotNull(r);
    }

    @Test
    public void testListException() {
        this.gws = new GenericWebService<E, R>(null, this.logRepository);
        final Response<E> r = this.gws.list();
        assertNotNull(r);
    }

    @Test
    public void testFind() {
        this.gws = new GenericWebService<E, R>(this.repository, this.logRepository);
        final Response<E> r = this.gws.find(0L);
        assertNotNull(r);
    }

    @Test
    public void testFindException() {
        this.gws = new GenericWebService<E, R>(null, this.logRepository);
        final Response<E> r = this.gws.find(0L);
        assertNotNull(r);
    }

    @Test
    public void testCreate() {
        this.gws = new GenericWebService<E, R>(this.repository, this.logRepository);
        this.entity.setId(1L);
        final Response<E> r = this.gws.create(this.entity);
        assertNotNull(r);
    }

    @Test
    public void testUpdate() {
        this.gws = new GenericWebService<E, R>(this.repository, this.logRepository);
        final Response<E> r = this.gws.update(this.entity);
        assertNotNull(r);
    }

    @Test
    @Ignore
    public void testDelete() {
        this.gws = new GenericWebService<E, R>(this.repository, this.logRepository);
        final Response<E> r = this.gws.delete(1L);
        assertNotNull(r);
    }
}
