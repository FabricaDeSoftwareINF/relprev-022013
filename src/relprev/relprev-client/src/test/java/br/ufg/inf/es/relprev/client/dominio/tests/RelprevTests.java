package br.ufg.inf.es.relprev.client.dominio.tests;

import java.util.*;

import br.ufg.inf.es.relprev.client.dominio.*;
import junit.framework.TestCase;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import org.junit.Ignore;

/**
 * User: halisson
 * Date: 11/2/13
 * Time: 1:30 AM
 */
@Ignore
public class RelprevTests extends TestCase {

    public void test() throws RequestException {

        final RelatorioPrevencao relprev = new RelatorioPrevencao();
        relprev.setLocal("Local");
        final Date data = new Date();
        relprev.setDataSituacaoPerigosa(data);
        final String envolvidos = "Mecanico A e B";
        relprev.setEnvolvidos(envolvidos);
        final String situacao = "Situação de risco ao fazer tal e tal coisa =x";
        relprev.setDescricaoSituacaoPerigosa(situacao);

        relprev.save();

        AcaoRecomendada acaoRecomendada = new AcaoRecomendada();

        acaoRecomendada.setDescricao("teste");
        acaoRecomendada.setData(new Date());
        acaoRecomendada.setDestinatario("BUuuuHahah");
        acaoRecomendada.setRemetente("Trem");

        assertNotNull(relprev.definaAcaoRecomendada(acaoRecomendada));
        assertNotNull(relprev.getAcaoRecomendada());

        ClassificacaoRisco classificacaoRisco = new ClassificacaoRisco();
        classificacaoRisco.setAvaliacaoFinal("10");
        classificacaoRisco.setAvaliacaoInicial("1");

        assertNotNull(relprev.definaClassificacaoDeRisco(classificacaoRisco));
        assertNotNull(relprev.getClassificacaoRisco());

        Encaminhamento encaminhamento = new Encaminhamento();
        encaminhamento.setDescricao("Desc");
        encaminhamento.setRemetente("Show");
        encaminhamento.setDestinatario("MaisShow");
        encaminhamento.setData(new Date());

        assertNotNull(relprev.definaEncaminhamento(encaminhamento));
        assertNotNull(relprev.getEncaminhamento());

        Observacao obs = new Observacao();
        obs.setDescricao("laskdjlkasdlkjajdls");

        assertNotNull(relprev.definaObservacao(obs));
        assertNotNull(relprev.getObservacao());

        ParecerSetor parecerSetor = new ParecerSetor();
        parecerSetor.setDescricao("asjljkdsalkdsakdsakdsa");
        parecerSetor.setData(new Date());

        assertNotNull(relprev.definaParecerSetor(parecerSetor));
        assertNotNull(relprev.getParecerSetor());

        Resposta resposta = new Resposta();
        resposta.setDescricao("asjljkdsalkdsakdsakdsa");
        resposta.setDestinatario("kjfaslksajd");
        resposta.setRemetente("kjfaslksajdsaçlmsdlkasd");
        resposta.setData(new Date());

        assertNotNull(relprev.definaResposta(resposta));
        assertNotNull(relprev.getResposta());

        System.out.println(relprev);
    }

    public void testRelprevDeveConterLocal() {
        final RelatorioPrevencao relprev = new RelatorioPrevencao();
        relprev.setLocal("Local");
        TestCase.assertEquals("Local", relprev.getLocal());
    }

    public void testRelprevDeveConterData() {
        final RelatorioPrevencao relprev = new RelatorioPrevencao();
        final Date data = new Date();
        relprev.setDataSituacaoPerigosa(data);
        TestCase.assertEquals(data, relprev.getDataSituacaoPerigosa());
    }

    public void testRelprevDeveConterEnvolvidos() {
        final RelatorioPrevencao relprev = new RelatorioPrevencao();
        final String envolvidos = "Mecanico A e B";
        relprev.setEnvolvidos(envolvidos);
        TestCase.assertEquals(envolvidos, relprev.getEnvolvidos());
    }

    public void testRelprevDeveConterSituacao() {
        final RelatorioPrevencao relprev = new RelatorioPrevencao();
        final String situacao = "Situação de risco ao fazer tal e tal coisa =x";
        relprev.setDescricaoSituacaoPerigosa(situacao);
        TestCase.assertEquals(situacao, relprev.getDescricaoSituacaoPerigosa());
    }

    public void testRelprevDeveConterAnexos() {
        final RelatorioPrevencao relprev = new RelatorioPrevencao();
        final Set<Anexo> anexos = new HashSet<Anexo>();
        relprev.setAnexos(anexos);
        TestCase.assertEquals(anexos, relprev.getAnexos());
    }

    public void testRelprevDeveConterRelator() {
        final RelatorioPrevencao relprev = new RelatorioPrevencao();
        final Relator relator = new Relator();
        final String nome = "RelatorShow";
        final String contato = "RelatorShow@show.com";
        relator.setNome(nome);
        relator.setEmail(contato);
        relprev.setRelator(relator);
        assertEquals(relprev.getRelator(), relator);
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelListarOsRelprevsExistentes() throws RequestException {
        TestCase.assertNotNull(new RelatorioPrevencao().list());
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelObterUmRelprevPeloId() throws RequestException {
        TestCase.assertNotNull(new RelatorioPrevencao().get(2));
    }

    //TODO: Corrigir para usar mocks e mockar requisição real
    public void testDeveSerPossivelPersistirUmRelprev() throws RequestException {
        new RelatorioPrevencao().save();
    }
}
