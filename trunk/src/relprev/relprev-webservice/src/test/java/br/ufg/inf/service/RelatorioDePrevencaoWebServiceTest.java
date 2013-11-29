package br.ufg.inf.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.ufg.inf.repository.RelatorioDePrevencaoRepository;
import br.ufg.inf.service.support.WebServicesURL;

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
 * @see RelatorioPrevencaoWebService
 */
@Ignore
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "/META-INF/spring/applicationContextTest-mvc.xml")
public class RelatorioDePrevencaoWebServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private RelatorioDePrevencaoRepository relRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(this.relRepository);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testFindRelPrevByLocal() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get(WebServicesURL.URL_RELPREV + WebServicesURL.URL_RELPREV_FIND_LOCAL + "/{local}", ""));
    }

    @Test
    public void testFindRelPrevByDescricao() {

    }

}
