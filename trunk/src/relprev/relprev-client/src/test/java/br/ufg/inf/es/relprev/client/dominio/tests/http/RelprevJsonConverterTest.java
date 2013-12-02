package br.ufg.inf.es.relprev.client.dominio.tests.http;

import br.ufg.inf.es.relprev.client.dominio.EloSipaer;
import br.ufg.inf.es.relprev.client.dominio.Relator;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.http.JsonConverter;
import junit.framework.TestCase;

import java.util.Date;

/**
 * User: halisson
 * Date: 11/9/13
 * Time: 12:05 AM
 */
public class RelprevJsonConverterTest extends TestCase {
    public void testConvert() {
        RelatorioPrevencao relprev = new RelatorioPrevencao();

        Relator relator = new Relator();
        relator.setNome("Relator Show");
        relator.setEmail("RelatorShow@Aq.ui");

        EloSipaer eloSipaer = new EloSipaer();
        eloSipaer.setOrganizacao("Des. Organização ");
        eloSipaer.setSigla("DesOrg.");

        relprev.setLocal("Local locão");
        relprev.setRelator(relator);
        relprev.setDataSituacaoPerigosa(new Date());
        relprev.setEnvolvidos("Muitos Loucos");
        relprev.setDescricaoSituacaoPerigosa("Situação maluca nehh... bem maluca");
//        relprev.setEloSipaer(eloSipaer);
        relprev.setSituacao("tensa");

        String json = new JsonConverter().toJson(relprev);
        assertNotNull(json);
    }
}
