package br.ufg.inf.es.relprev.client.dominio.tests;

import br.ufg.inf.es.relprev.client.dominio.Relator;
import br.ufg.inf.es.relprev.client.dominio.Relprev;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import junit.framework.TestCase;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: halisson
 * Date: 11/2/13
 * Time: 1:30 AM
 */
public class RelprevTests extends TestCase {

    public void testRelprevDeveConterLocal() {
        Relprev relprev = new Relprev();
        relprev.setLocal("Local");
        assertEquals("Local", relprev.getLocal());
    }

    public void testRelprevDeveConterData() {
        Relprev relprev = new Relprev();
        Date data = new Date();
        relprev.setDataHora(data);
        assertEquals(data, relprev.getDataHora());
    }

    public void testRelprevDeveConterEnvolvidos() {
        Relprev relprev = new Relprev();
        String pessoalEnvolvido = "Mecanico A e B";
        relprev.setPessoalEnvolvido(pessoalEnvolvido);
        assertEquals(pessoalEnvolvido, relprev.getPessoalEnvolvido());
    }

    public void testRelprevDeveConterSituacao() {
        Relprev relprev = new Relprev();
        String situacao = "Situação de risco ao fazer tal e tal coisa =x";
        relprev.setDescricao(situacao);
        assertEquals(situacao, relprev.getDescricao());
    }

    public void testRelprevDeveConterAnexos() {
        Relprev relprev = new Relprev();
        List<File> anexos = new ArrayList<File>();
        relprev.setAnexos(anexos);
        assertEquals(anexos, relprev.getAnexos());
    }

    public void testRelprevDeveConterRelator() {
        Relprev relprev = new Relprev();
        Relator relator = new Relator();
        String nome = "RelatorShow";
        String contato = "RelatorShow@show.com";
        relator.setNome(nome);
        relator.setEmail(contato);
        relprev.setRelator(relator);
        assertEquals(nome, relprev.getNomeRelator());
        assertEquals(contato, relprev.getContatoRelator());
    }

    public void testRelprevSeNaoTiverRelatorDeveRetornarVazioParaONomeEContato() {
        Relprev relprev = new Relprev();
        String nome = "";
        String contato = "";
        assertEquals(nome, relprev.getNomeRelator());
        assertEquals(contato, relprev.getContatoRelator());
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelListarOsRelprevsExistentes() throws RequestException {
        assertNotNull(new Relprev().list());
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelObterUmRelprevPeloId() throws RequestException {
        assertNotNull(new Relprev().get(2));
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelPersistirUmRelprev() throws RequestException {
        new Relprev().save();
    }
}
