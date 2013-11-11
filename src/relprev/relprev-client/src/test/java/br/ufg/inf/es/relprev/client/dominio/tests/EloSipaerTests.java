package br.ufg.inf.es.relprev.client.dominio.tests;

import br.ufg.inf.es.relprev.client.dominio.EloSipaer;
import br.ufg.inf.es.relprev.client.dominio.Relprev;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import junit.framework.TestCase;

/**
 * User: halisson
 * Date: 11/2/13
 * Time: 1:30 AM
 */
public class EloSipaerTests extends TestCase {

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelPersistirUmRelprev() throws RequestException {
        EloSipaer elosipaer = new EloSipaer();
        elosipaer.setOrganizacao("OrganizacaoMaluca");
        elosipaer.setSigla("OrgMal");
        elosipaer.save();
    }
}
