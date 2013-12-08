package br.ufg.inf.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ufg.inf.repository.CategoriaRepository;
import br.ufg.inf.repository.support.LogRepository;

/**
 * Testes para os endpoints REST dos Elos SIPAER
 * 
 * @created 12/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see CategoriaRepository
 * @see CategoriaWebService
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriaWebServiceTest {

    @Mock
    private CategoriaWebService categoriaWebService;

    @Mock
    private LogRepository logRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Test
    public void testConstrutor() {
        this.categoriaWebService = new CategoriaWebService(this.categoriaRepository, this.logRepository);
        assertNotNull(this.categoriaWebService);
    }

}
