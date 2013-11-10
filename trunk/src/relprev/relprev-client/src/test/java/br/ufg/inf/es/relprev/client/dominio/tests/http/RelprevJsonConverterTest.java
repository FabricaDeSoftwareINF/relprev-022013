package br.ufg.inf.es.relprev.client.dominio.tests.http;

import br.ufg.inf.es.relprev.client.dominio.EloSipaer;
import br.ufg.inf.es.relprev.client.dominio.Relator;
import br.ufg.inf.es.relprev.client.dominio.Relprev;
import br.ufg.inf.es.relprev.client.dominio.Situacao;
import br.ufg.inf.es.relprev.client.http.JsonConverter;
import junit.framework.TestCase;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: halisson
 * Date: 11/9/13
 * Time: 12:05 AM
 */
public class RelprevJsonConverterTest extends TestCase {
    public void testConvert() {
        Relprev relprev = new Relprev();

        Relator relator = new Relator();
        relator.setNome("Relator Show");
        relator.setContato("RelatorShow@Aq.ui");

        EloSipaer eloSipaer = new EloSipaer();
        eloSipaer.setOrganizacao("Des. Organização ");
        eloSipaer.setSigla("DesOrg.");

        Situacao situacaoNaoShow = new Situacao();
        situacaoNaoShow.setDescricao("NaoShow");
        Situacao situacaoQuaseShow = new Situacao();
        situacaoQuaseShow.setDescricao("QuaseShow");
        Situacao situacaoShow = new Situacao();
        situacaoShow.setDescricao("Show");

        Set<Situacao> situacoes = new HashSet<Situacao>();
        situacoes.add(situacaoNaoShow);
        situacoes.add(situacaoQuaseShow);
        situacoes.add(situacaoShow);

        relprev.setLocal("Local locão");
        relprev.setRelator(relator);
        relprev.setDataHora(new Date());
        relprev.setPessoalEnvolvido("Muitos Loucos");
        relprev.setDescricao("Situação maluca nehh... bem maluca");
        relprev.setEloSipaer(eloSipaer);
        relprev.setSituacoes(situacoes);

        String json = new JsonConverter().toJson(relprev);
        assertNotNull(json);
    }
}
