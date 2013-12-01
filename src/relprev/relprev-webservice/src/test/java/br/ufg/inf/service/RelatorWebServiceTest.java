package br.ufg.inf.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufg.inf.repository.RelatorRepository;
import br.ufg.inf.repository.support.LogRepository;

/**
 * Testes para os endpoints REST do Relator
 * 
 * @created 30/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see RelatorRepository
 * @see RelatorWebService
 */
@RunWith(MockitoJUnitRunner.class)
public class RelatorWebServiceTest {

    @Mock
    private RelatorWebService relatorWebService;

    @Mock
    private LogRepository logRepository;

    @Mock
    private RelatorRepository relatorRepository;

    @Test
    public void testConstrutor() {
        this.relatorWebService = new RelatorWebService(this.relatorRepository, this.logRepository);
        assertNotNull(this.relatorWebService);
    }

}
