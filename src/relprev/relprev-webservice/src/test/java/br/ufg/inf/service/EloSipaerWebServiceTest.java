package br.ufg.inf.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufg.inf.repository.EloSipaerRepository;
import br.ufg.inf.repository.support.LogRepository;

/**
 * Testes para os endpoints REST dos Elos SIPAER
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see EloSipaerRepository
 * @see EloSipaerWebService
 */
@RunWith(MockitoJUnitRunner.class)
public class EloSipaerWebServiceTest {

    @Mock
    private EloSipaerWebService eloSipaerWebService;

    @Mock
    private LogRepository logRepository;

    @Mock
    private EloSipaerRepository eloRepository;

    @Test
    public void testConstrutor() {
        this.eloSipaerWebService = new EloSipaerWebService(this.eloRepository, this.logRepository);
        assertNotNull(this.eloSipaerWebService);
    }

}
