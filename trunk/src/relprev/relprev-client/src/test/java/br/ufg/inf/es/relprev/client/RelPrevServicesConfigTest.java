package br.ufg.inf.es.relprev.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

import br.ufg.inf.es.relprev.client.util.Configuration;

/**
 * Testes para {@link RelPrevServicesConfig}
 * 
 * @created 06/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class RelPrevServicesConfigTest {

    private final RelPrevServicesConfig config = RelPrevServicesConfig.getInstance();

    private final String SERVICES_URL_WITHOUT_REPLACEMENT = "http://localhost:8080/services";

    @Before
    public void setUp() {
        this.config.setConfiguration(new Configuration("services-test"));
    }

    @Test
    public void testConstructorIsPrivate() throws Exception {
        final Constructor<RelPrevServicesConfig> constructor = RelPrevServicesConfig.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void testGetInstance() {
        final RelPrevServicesConfig anotherConfig = RelPrevServicesConfig.getInstance();
        assertSame(this.config, anotherConfig);
    }

    @Test
    public void testSetConfiguration() {
        final RelPrevServicesConfig anotherConfig = RelPrevServicesConfig.getInstance();
        anotherConfig.setConfiguration(new Configuration("services"));
        assertSame(this.config, anotherConfig);
    }

    @Test
    public void testListRelPrevURL() {
        assertEquals(this.config.listRelPrevURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev");
    }

    @Test
    public void testFindRelPrevURL() {
        assertEquals(this.config.findRelPrevURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/");
    }

    @Test
    public void testCreateRelPrevURL() {
        assertEquals(this.config.createRelPrevURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/create");
    }

    @Test
    public void testUpdateRelPrevURL() {
        assertEquals(this.config.updateRelPrevURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/update");
    }

    @Test
    public void testDeleteRelPrevURL() {
        assertEquals(this.config.deleteRelPrevURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev");
    }

    @Test
    public void testFindRelPrevByLocalURL() {
        assertEquals(this.config.findRelPrevByLocalURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/local/");
    }

    @Test
    public void testFindRelPrevByDescricaoURL() {
        assertEquals(this.config.findRelPrevByDescricaoURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/descricao/");
    }

    @Test
    public void testAddRelPrevAcaoRecomendadaURL() {
        assertEquals(this.config.addRelPrevAcaoRecomendadaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/acao");
    }

    @Test
    public void testAddRelPrevClassificadaoDeRiscoURL() {
        assertEquals(this.config.addRelPrevClassificadaoDeRiscoURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT
                + "/relprev/classificacao");
    }

    @Test
    public void testAddRelPrevEncaminhamentoURL() {
        assertEquals(this.config.addRelPrevEncaminhamentoURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/encaminhamento");
    }

    @Test
    public void testAddRelPrevObservacaoURL() {
        assertEquals(this.config.addRelPrevObservacaoURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/observacao");
    }

    @Test
    public void testAddRelPrevParecerDoSetorURL() {
        assertEquals(this.config.addRelPrevParecerDoSetorURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/parecer");
    }

    @Test
    public void testAddRelPrevRespostaURL() {
        assertEquals(this.config.addRelPrevRespostaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relprev/resposta");
    }

    @Test
    public void testListEloSIPAERURL() {
        assertEquals(this.config.listEloSIPAERURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/elosipaer");
    }

    @Test
    public void testFindEloSIPAERURL() {
        assertEquals(this.config.findEloSIPAERURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/elosipaer/");
    }

    @Test
    public void testCreateEloSIPAERURL() {
        assertEquals(this.config.createEloSIPAERURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/elosipaer/create");
    }

    @Test
    public void testUpdateEloSIPAERURL() {
        assertEquals(this.config.updateEloSIPAERURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/elosipaer/update");
    }

    @Test
    public void testDeleteEloSIPAERURL() {
        assertEquals(this.config.deleteEloSIPAERURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/elosipaer");
    }

    @Test
    public void testListTaxonomiaURL() {
        assertEquals(this.config.listTaxonomiaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/taxonomia");
    }

    @Test
    public void testFindTaxonomiaURL() {
        assertEquals(this.config.findTaxonomiaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/taxonomia/");
    }

    @Test
    public void testCreateTaxonomiaURL() {
        assertEquals(this.config.createTaxonomiaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/taxonomia/create");
    }

    @Test
    public void testUpdateTaxonomiaURL() {
        assertEquals(this.config.updateTaxonomiaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/taxonomia/update");
    }

    @Test
    public void testDeleteTaxonomiaURL() {
        assertEquals(this.config.deleteTaxonomiaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/taxonomia");
    }

    @Test
    public void testListCategoriaURL() {
        assertEquals(this.config.listCategoriaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/categoria");
    }

    @Test
    public void testFindCategoriaURL() {
        assertEquals(this.config.findCategoriaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/categoria/");
    }

    @Test
    public void testCreateCategoriaURL() {
        assertEquals(this.config.createCategoriaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/categoria/create");
    }

    @Test
    public void testUpdateCategoriaURL() {
        assertEquals(this.config.updateCategoriaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/categoria/update");
    }

    @Test
    public void testDeleteCategoriaURL() {
        assertEquals(this.config.deleteCategoriaURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/categoria");
    }

    @Test
    public void testListRelatorURL() {
        assertEquals(this.config.listRelatorURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relator");
    }

    @Test
    public void testFindRelatorURL() {
        assertEquals(this.config.findRelatorURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relator/");
    }

    @Test
    public void testCreateRelatorURL() {
        assertEquals(this.config.createRelatorURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relator/create");
    }

    @Test
    public void testUpdateRelatorURL() {
        assertEquals(this.config.updateRelatorURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relator/update");
    }

    @Test
    public void testDeleteRelatorURL() {
        assertEquals(this.config.deleteRelatorURL(), this.SERVICES_URL_WITHOUT_REPLACEMENT + "/relator");
    }

}
