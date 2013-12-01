package br.ufg.inf.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufg.inf.repository.TaxonomiaRepository;
import br.ufg.inf.repository.support.LogRepository;

/**
 * Testes para os endpoints REST de Taxonomia
 * 
 * @created 30/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see TaxonomiaRepository
 * @see TaxonomiaWebService
 */
@RunWith(MockitoJUnitRunner.class)
public class TaxonomiaWebServiceTest {

    @Mock
    private TaxonomiaWebService taxonomiaWebService;

    @Mock
    private LogRepository logRepository;

    @Mock
    private TaxonomiaRepository taxonomiaRepository;

    @Test
    public void testConstrutor() {
        this.taxonomiaWebService = new TaxonomiaWebService(this.taxonomiaRepository, this.logRepository);
        assertNotNull(this.taxonomiaWebService);
    }

}
