package br.ufg.inf.service.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.LinkedList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.model.Relator;
import br.ufg.inf.model.test.EloSipaerBuilder;

/**
 * Testes para o ResponseBuilder
 * 
 * @created 24/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class ResponseBuilderTest {

    @Mock
    private List<Relator> relatores;

    @Test
    public void testSetSuccess() {
        final Response<Relator> response = new Response<Relator>();
        response.setSuccess(false);
        assertFalse(response.getSuccess());
    }

    @Test
    public void testSetData() {
        final Response<Relator> response = new Response<Relator>();
        response.setData(this.relatores);
        assertEquals(this.relatores, response.getData());
    }

    @Test
    public void testSetCount() {
        final Response<Relator> response = new Response<Relator>();
        response.setCount(1L);
        assertEquals(Long.valueOf(1L), response.getCount());
    }

    @Test
    public void testSetMessage() {
        final Response<Relator> response = new Response<Relator>();
        response.setMessage("Teste");
        assertEquals("Teste", response.getMessage());
    }

    @Test
    public void testSetStatus() {
        final Response<Relator> response = new Response<Relator>();
        response.setStatus(1);
        assertEquals(Integer.valueOf(1), response.getStatus());
    }

    @Test
    public void testSimpleResponse() {
        final Response<EloSipaer> successResponse = new ResponseBuilder<EloSipaer>().success(false)
                .message("Simple Responde Setting Count").count(0L).status(HttpStatus.OK).build();
        final Matcher<Response<EloSipaer>> mat1 = Matchers.allOf(Matchers.hasProperty("success", Matchers.is(false)),
                Matchers.hasProperty("data", Matchers.nullValue()), Matchers.hasProperty("count", Matchers.is(0L)),
                Matchers.hasProperty("message", Matchers.is("Simple Responde Setting Count")),
                Matchers.hasProperty("status", Matchers.is(200)));
        Assert.assertThat(successResponse, mat1);
    }

    @Test
    public void testResponseStatusNull() {
        final Response<EloSipaer> successResponse = new ResponseBuilder<EloSipaer>().success(false)
                .message("Simple Responde Setting Count").count(0L).status(null).build();
        final Matcher<Response<EloSipaer>> mat1 = Matchers.allOf(Matchers.hasProperty("success", Matchers.is(false)),
                Matchers.hasProperty("data", Matchers.nullValue()), Matchers.hasProperty("count", Matchers.is(0L)),
                Matchers.hasProperty("message", Matchers.is("Simple Responde Setting Count")),
                Matchers.hasProperty("status", Matchers.is(417)));
        Assert.assertThat(successResponse, mat1);
    }

    @Test
    public void testSuccessEloSIPAERResponse() {
        final EloSipaer eloSipaer = new EloSipaerBuilder().id(1L).organizacao("Organização").sigla("ORG").build();
        final Response<EloSipaer> successResponse = new ResponseBuilder<EloSipaer>().success(true)
                .message(ResponseMessages.CREATE_MESSAGE).data(eloSipaer).status(HttpStatus.OK).build();
        final Matcher<Response<EloSipaer>> mat1 = Matchers.allOf(Matchers.hasProperty("success", Matchers.is(true)),
                Matchers.hasProperty("data", Matchers.containsInAnyOrder(eloSipaer)),
                Matchers.hasProperty("count", Matchers.is(1L)),
                Matchers.hasProperty("message", Matchers.is("Objeto criado com Sucesso")),
                Matchers.hasProperty("status", Matchers.is(200)));
        Assert.assertThat(successResponse, mat1);
    }

    @Test
    public void testSuccessMultiple_EloSIPAERResponse() {
        final EloSipaer eloSipaer1 = new EloSipaerBuilder().id(1L).organizacao("Organização 1").sigla("ORG 1").build();
        final EloSipaer eloSipaer2 = new EloSipaerBuilder().id(2L).organizacao("Organização 2").sigla("ORG 2").build();
        final List<EloSipaer> elosSipaer = new LinkedList<EloSipaer>();
        elosSipaer.add(eloSipaer1);
        elosSipaer.add(eloSipaer2);
        final Response<EloSipaer> successResponse = new ResponseBuilder<EloSipaer>().success(true)
                .message(ResponseMessages.CREATE_MESSAGE).data(elosSipaer).status(HttpStatus.OK).build();
        final Matcher<Response<EloSipaer>> mat1 = Matchers.allOf(Matchers.hasProperty("success", Matchers.is(true)),
                Matchers.hasProperty("data", Matchers.contains(eloSipaer1, eloSipaer2)),
                Matchers.hasProperty("count", Matchers.is(2L)),
                Matchers.hasProperty("message", Matchers.is("Objeto criado com Sucesso")),
                Matchers.hasProperty("status", Matchers.is(200)));
        Assert.assertThat(successResponse, mat1);
    }

    @Test
    public void testSuccessNull_EloSIPAERResponse() {
        final EloSipaer eloSipaer = null;
        final Response<EloSipaer> successResponse = new ResponseBuilder<EloSipaer>().success(true)
                .message(ResponseMessages.CREATE_MESSAGE).data(eloSipaer).status(HttpStatus.OK).build();
        final Matcher<Response<EloSipaer>> mat1 = Matchers.allOf(Matchers.hasProperty("success", Matchers.is(true)),
                Matchers.hasProperty("data", Matchers.nullValue()), Matchers.hasProperty("count", Matchers.is(0L)),
                Matchers.hasProperty("message", Matchers.is("Objeto criado com Sucesso")),
                Matchers.hasProperty("status", Matchers.is(200)));
        Assert.assertThat(successResponse, mat1);
    }

}
