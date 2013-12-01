package br.ufg.inf.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.ufg.inf.repository.RelatorioDePrevencaoRepository;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Testes para os endpoints REST dos Relatórios de Prevenção
 * 
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see RelatorioDePrevencaoRepository
 * @see RelatorioPrevencaoWebService
 */
@Ignore
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/META-INF/spring/applicationContextTest-mvc.xml")
public class RelatorioDePrevencaoWebServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private RelatorioDePrevencaoRepository relatorioDePrevencaoRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(this.relatorioDePrevencaoRepository);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testFindRelPrevByLocal() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(WebServicesURL.URL_RELPREV + WebServicesURL.URL_RELPREV_FIND_LOCAL
                + "/{local}", "Local 1"));
    }

    @Test
    public void testFindRelPrevByDescricao() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(WebServicesURL.URL_RELPREV + WebServicesURL.URL_RELPREV_FIND_DESCRICAO
                + "/{descricao}", "Descrição 1"));
    }

}
