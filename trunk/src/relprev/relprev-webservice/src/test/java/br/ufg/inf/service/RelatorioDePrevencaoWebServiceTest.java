package br.ufg.inf.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import br.ufg.inf.model.RelPrev;
import br.ufg.inf.repository.RelatorioDePrevencaoRepository;

/**
 * Testes para {@link RelatorioDePrevencaoWebService}
 * 
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@ContextConfiguration(locations = {""})
public class RelatorioDePrevencaoWebServiceTest extends GenericWebServiceTest<RelPrev, RelatorioDePrevencaoRepository> {

    @Autowired
    private RelatorioDePrevencaoRepository repository;

    @Override
    RelatorioDePrevencaoRepository getRepository() {
        return this.repository;
    }

    @Test
    public void testFindRelPrevByLocal() {

    }

    @Test
    public void testFindRelPrevByDescricao() {

    }

}
