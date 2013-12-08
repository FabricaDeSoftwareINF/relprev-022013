package br.ufg.inf.es.relprev.client.dominio.tests.http;

import java.util.Date;

import junit.framework.TestCase;
import br.ufg.inf.es.relprev.client.dominio.EloSipaer;
import br.ufg.inf.es.relprev.client.dominio.Relator;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.http.JsonConverter;

/**
 * User: halisson
 * Date: 11/9/13
 * Time: 12:05 AM
 */
public class RelprevJsonConverterTest extends TestCase {

    public void testConvert() {
        final RelatorioPrevencao relprev = new RelatorioPrevencao();

        final Relator relator = new Relator();
        relator.setNome("Relator Show");
        relator.setEmail("RelatorShow@Aq.ui");

        final EloSipaer eloSipaer = new EloSipaer();
        eloSipaer.setOrganizacao("Des. Organização ");
        eloSipaer.setSigla("DesOrg.");

        relprev.setLocal("Local locão");
        relprev.setRelator(relator);
        relprev.setDataSituacaoPerigosa(new Date());
        relprev.setEnvolvidos("Muitos Loucos");
        relprev.setDescricaoSituacaoPerigosa("Situação maluca nehh... bem maluca");
        // relprev.setEloSipaer(eloSipaer);
        relprev.setSituacao("tensa");

        final String json = JsonConverter.toJson(relprev);
        assertNotNull(json);
    }

}
