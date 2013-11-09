package br.ufg.inf.repository.support;

import org.junit.Test;

import br.ufg.inf.model.support.AbstractEntity;

/**
 * Teste para {@link GenericRepository}
 * 
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public abstract class GenericRepositoryTest<E extends AbstractEntity, R extends GenericRepository<E, Long>> {

    abstract R getRepository();

    @Test
    public void testCreate() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testDeleteInBatch() {

    }

    @Test
    public void testFindOne() {

    }

}
