package br.ufg.inf.service;

import org.junit.Test;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.repository.support.GenericRepository;
import br.ufg.inf.service.support.GenericWebService;

/**
 * Testes para os endpoints REST Genéricos
 * <p />
 * A documentação dos casos de teste está nos testes especializados
 * 
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericWebService
 */
public abstract class GenericWebServiceTest<E extends AbstractEntity<E>, R extends GenericRepository<E, Long>> {

    abstract R getRepository();

    @Test
    public void testFind() {

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
