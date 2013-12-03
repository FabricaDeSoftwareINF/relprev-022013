package br.ufg.inf.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.ufg.inf.repository.RelatorioDePrevencaoRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.Response;



/**
 * Testes para os endpoints REST dos Relatórios de Prevenção
 * 
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see RelatorioDePrevencaoRepository
 * @see RelatorioPrevencaoWebService
 */
public class RelatorioDePrevencaoWebServiceTest {

    @Mock
    private RelatorioDePrevencaoRepository relatorioDePrevencaoRepository;
    
    @Mock
    private LogRepository logRepository;
    
    private RelatorioDePrevencaoWebService relatorioDePrevencaoWebService;

    @Before
    public void setUp() {
    	relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(relatorioDePrevencaoRepository, logRepository);
    }

    @Test
    public void testFindRelPrevByLocal() throws Exception {
    	Response<?> r = relatorioDePrevencaoWebService.findRelPrevByLocal("Teste");
    	
    	assertNotNull(r);
    }

    @Test
    public void testFindRelPrevByDescricao() throws Exception {
    	Response<?> r = relatorioDePrevencaoWebService.findRelPrevByDescricao("Teste");
    	
    	assertNotNull(r);
    }
    
    @Test
    public void testFindRelPrevByLocalException() throws Exception {
    	relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(null, logRepository);
    	Response<?> r = relatorioDePrevencaoWebService.findRelPrevByLocal("Teste");
    	
    	assertNotNull(r);
    }

    @Test
    public void testFindRelPrevByDescricaoException() throws Exception {
    	relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(null, logRepository);
    	Response<?> r = relatorioDePrevencaoWebService.findRelPrevByDescricao("Teste");
    	
    	assertNotNull(r);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddAcaoRecomendada() throws Exception {
    	relatorioDePrevencaoWebService.addAcaoRecomendada(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateAcaoRecomendada() throws Exception {
    	relatorioDePrevencaoWebService.updateAcaoRecomendada(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteAcaoRecomendada() throws Exception {
    	relatorioDePrevencaoWebService.deleteAcaoRecomendada(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddClassificacaoDeRisco() throws Exception {
    	relatorioDePrevencaoWebService.addClassificacaoDeRisco(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateClassificacaoDeRisco() throws Exception {
    	relatorioDePrevencaoWebService.updateClassificacaoDeRisco(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteClassificacaoDeRisco() throws Exception {
    	relatorioDePrevencaoWebService.deleteClassificacaoDeRisco(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddEncaminhamento() throws Exception {
    	relatorioDePrevencaoWebService.addEncaminhamento(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateEncaminhamento() throws Exception {
    	relatorioDePrevencaoWebService.updateEncaminhamento(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteEncaminhamento() throws Exception {
    	relatorioDePrevencaoWebService.deleteEncaminhamento(1L, null);
    }

    @Test(expected = NullPointerException.class) 
    public void testAddObservacao() throws Exception {
    	relatorioDePrevencaoWebService.addObservacao(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateObservacao() throws Exception {
    	relatorioDePrevencaoWebService.updateObservacao(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteObservacao() throws Exception {
    	relatorioDePrevencaoWebService.deleteObservacao(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddParecerSetor() throws Exception {
    	relatorioDePrevencaoWebService.addParecerSetor(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateParecerSetor() throws Exception {
    	relatorioDePrevencaoWebService.updateParecerSetor(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteParecerSetor() throws Exception {
    	relatorioDePrevencaoWebService.deleteParecerSetor(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddResposta() throws Exception {
    	relatorioDePrevencaoWebService.addResposta(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateResposta() throws Exception {
    	relatorioDePrevencaoWebService.updateResposta(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteResposta() throws Exception {
    	relatorioDePrevencaoWebService.deleteResposta(1L, null);
    }
}
