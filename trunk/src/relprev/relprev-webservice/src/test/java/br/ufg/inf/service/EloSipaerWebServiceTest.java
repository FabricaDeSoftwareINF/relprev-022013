package br.ufg.inf.service;

import java.nio.charset.Charset;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.model.test.EloSipaerBuilder;
import br.ufg.inf.repository.EloSipaerRepository;
import br.ufg.inf.service.support.ResponseMessages;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Testes para os endpoints REST dos Elos SIPAER
 * <p />
 * {@link #testCreate()} <br />
 * {@link #testUpdate()} <br />
 * {@link #testDelete()} <br />
 * {@link #testFind())} <br />
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see EloSipaerRepository
 * @see EloSipaerWebService
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContextTest-mvc.xml"})
public class EloSipaerWebServiceTest {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private EloSipaerRepository eloRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(this.eloRepository);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testFindFound() throws Exception {
        final EloSipaer elo = new EloSipaerBuilder().id(1L).organizacao("Organizacao 1").sigla("OES1").build();
        Mockito.when(this.eloRepository.findOne(1L)).thenReturn(elo);
        this.mockMvc.perform(MockMvcRequestBuilders.get(WebServicesURL.URL_ELOSIPAER + "/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id", Matchers.is(1L)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].organizacao", Matchers.is("Organizacao 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].sigla", Matchers.is("OES1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.count", Matchers.is(1L)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is(ResponseMessages.FIND_MESSAGE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(HttpStatus.OK.value())));
        Mockito.verify(this.eloRepository, Mockito.times(1)).findOne(1L);
        Mockito.verifyNoMoreInteractions(this.eloRepository);
    }

}
