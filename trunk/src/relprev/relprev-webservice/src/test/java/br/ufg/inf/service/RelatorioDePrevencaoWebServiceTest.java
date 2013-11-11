package br.ufg.inf.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import br.ufg.inf.model.RelPrev;
import br.ufg.inf.repository.RelatorioDePrevencaoRepository;

/**
 * Testes para os endpoints REST dos Relatórios de Prevenção
 * <p />
 * {@link #testCreate()} <br />
 * {@link #testUpdate()} <br />
 * {@link #testDelete()} <br />
 * {@link #testFind())} <br />
 * {@link #testFindRelPrevByDescricao()} <br />
 * {@link #testFindRelPrevByLocal()} <br />
 *
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see RelatorioDePrevencaoRepository
 * @see RelatorioDePrevencaoWebService
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
