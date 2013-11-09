package br.ufg.inf.service;

import org.junit.Test;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.repository.support.GenericRepository;

/**
 * Testes para {@link GenericWebService}
 * 
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public abstract class GenericWebServiceTest<E extends AbstractEntity, R extends GenericRepository<E, Long>> {

    abstract R getRepository();

    @Test
    public void testFind() {

    }

    @Test
    public void testFindById() {

    }

    @Test
    public void testCreate() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }

}
