package br.ufg.inf.es.relprev.client.dominio.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevenvao;
import junit.framework.TestCase;
import br.ufg.inf.es.relprev.client.dominio.Anexo;
import br.ufg.inf.es.relprev.client.dominio.Relator;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

/**
 * User: halisson
 * Date: 11/2/13
 * Time: 1:30 AM
 */
public class RelprevTests extends TestCase {

    public void testRelprevDeveConterLocal() {
        final RelatorioPrevenvao relprev = new RelatorioPrevenvao();
        relprev.setLocal("Local");
        TestCase.assertEquals("Local", relprev.getLocal());
    }

    public void testRelprevDeveConterData() {
        final RelatorioPrevenvao relprev = new RelatorioPrevenvao();
        final Date data = new Date();
        relprev.setDataHora(data);
        TestCase.assertEquals(data, relprev.getDataHora());
    }

    public void testRelprevDeveConterEnvolvidos() {
        final RelatorioPrevenvao relprev = new RelatorioPrevenvao();
        final String pessoalEnvolvido = "Mecanico A e B";
        relprev.setPessoalEnvolvido(pessoalEnvolvido);
        TestCase.assertEquals(pessoalEnvolvido, relprev.getPessoalEnvolvido());
    }

    public void testRelprevDeveConterSituacao() {
        final RelatorioPrevenvao relprev = new RelatorioPrevenvao();
        final String situacao = "Situação de risco ao fazer tal e tal coisa =x";
        relprev.setDescricao(situacao);
        TestCase.assertEquals(situacao, relprev.getDescricao());
    }

    public void testRelprevDeveConterAnexos() {
        final RelatorioPrevenvao relprev = new RelatorioPrevenvao();
        final List<Anexo> anexos = new ArrayList<Anexo>();
        relprev.setAnexos(anexos);
        TestCase.assertEquals(anexos, relprev.getAnexos());
    }

    public void testRelprevDeveConterRelator() {
        final RelatorioPrevenvao relprev = new RelatorioPrevenvao();
        final Relator relator = new Relator();
        final String nome = "RelatorShow";
        final String contato = "RelatorShow@show.com";
        relator.setNome(nome);
        relator.setEmail(contato);
        relprev.setRelator(relator);
        TestCase.assertEquals(nome, relprev.getNomeRelator());
        TestCase.assertEquals(contato, relprev.getContatoRelator());
    }

    public void testRelprevSeNaoTiverRelatorDeveRetornarVazioParaONomeEContato() {
        final RelatorioPrevenvao relprev = new RelatorioPrevenvao();
        final String nome = "";
        final String contato = "";
        TestCase.assertEquals(nome, relprev.getNomeRelator());
        TestCase.assertEquals(contato, relprev.getContatoRelator());
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelListarOsRelprevsExistentes() throws RequestException {
        TestCase.assertNotNull(new RelatorioPrevenvao().list());
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelObterUmRelprevPeloId() throws RequestException {
        TestCase.assertNotNull(new RelatorioPrevenvao().get(2));
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelPersistirUmRelprev() throws RequestException {
        new RelatorioPrevenvao().save();
    }
}
