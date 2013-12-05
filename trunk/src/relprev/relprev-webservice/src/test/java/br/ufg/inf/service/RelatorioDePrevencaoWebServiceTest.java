package br.ufg.inf.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.ufg.inf.model.AcaoRecomendada;
import br.ufg.inf.model.Resposta;
import br.ufg.inf.model.Observacao;
import br.ufg.inf.model.ParecerSetor;
import br.ufg.inf.model.Encaminhamento;
import br.ufg.inf.model.ClassificacaoRisco;
import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.model.RelatorioPrevencao;
import br.ufg.inf.model.Situacao;
import br.ufg.inf.model.security.Usuario;
import br.ufg.inf.repository.EloSipaerRepository;
import br.ufg.inf.repository.RelatorioDePrevencaoRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.Response;

/**
 * Testes para os endpoints REST dos Relatórios de Prevenção
 * 
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see RelatorioDePrevencaoRepository
 * @see RelatorioPrevencaoWebService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContextTest-mvc.xml",
        "classpath:META-INF/spring/applicationContextTest-persistence.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class RelatorioDePrevencaoWebServiceTest {

    @Autowired
    private RelatorioDePrevencaoRepository relatorioDePrevencaoRepository;

    @Autowired
    private EloSipaerRepository eloSipaerRepository;

    @Autowired
    private LogRepository logRepository;

    private RelatorioDePrevencaoWebService relatorioDePrevencaoWebService;

    private RelatorioPrevencao relprev;

    @Before
    public void setUp() {
        this.relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(this.relatorioDePrevencaoRepository,
                this.logRepository);

        this.relprev = new RelatorioPrevencao();

        final Usuario usuario = new Usuario();
        usuario.setAtivo(true);
        usuario.setDataInsercaoAlteracao(new Date());
        usuario.setNomeCompleto("teste nome");
        usuario.setFuncao("funçaõ");
        usuario.setPosto("posto");
        usuario.setSenha("d131dd02c5e6eec4693d9a0698aff95c2fcab58712467eab4004583eb8fb7f89d15431dd02c5e6eec4693d9a0698aff95c2fcab58712467eab4004583eb8fb7f");
        usuario.setSiglaSecao("SIGLA");
        usuario.setUsuario("usuario");

        final EloSipaer eloSipaer = new EloSipaer();
        eloSipaer.setDataInsercaoAlteracao(new Date());
        eloSipaer.setOrganizacao("teste organização");
        eloSipaer.setSiglaOrganizacao("SIGLA");
        eloSipaer.setUsuario(usuario);

        this.eloSipaerRepository.save(eloSipaer);

        final Situacao situacao = new Situacao();
        situacao.setFoiConcluido(false);
        situacao.setTemAcaoRecomendada(false);
        situacao.setTemDivulgacao(false);
        situacao.setTemEncaminhamento(false);

        this.relprev.setDataInsercaoAlteracao(new Date());
        this.relprev.setDataSituacaoPerigosa(new Date());
        this.relprev.setDescricaoSituacaoPerigosa("teste descrição");
        this.relprev.setEloSipaer(eloSipaer);
        this.relprev.setEnvolvidos("teste envolvidos");
        this.relprev.setLocal("teste local");
        this.relprev.setSituacoes(situacao);

        this.relatorioDePrevencaoWebService.create(this.relprev);
    }

    @Test
    public void testFindRelPrevByLocal() throws Exception {
        final Response<?> r = this.relatorioDePrevencaoWebService.findRelPrevByLocal("teste local");

        assertNotNull(r);
    }

    @Test
    public void testFindRelPrevByDescricao() throws Exception {
        final Response<?> r = this.relatorioDePrevencaoWebService.findRelPrevByDescricao("teste descrição");

        assertNotNull(r);
    }

    @Test
    public void testFindRelPrevByLocalException() throws Exception {
        this.relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(null, this.logRepository);
        final Response<RelatorioPrevencao> r = this.relatorioDePrevencaoWebService.findRelPrevByLocal("Teste");

        assertNotNull(r);
    }

    @Test
    public void testFindRelPrevByDescricaoException() throws Exception {
        this.relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(null, this.logRepository);
        final Response<?> r = this.relatorioDePrevencaoWebService.findRelPrevByDescricao("Teste");

        assertNotNull(r);
    }

    @Test
    public void testUpdate() throws Exception {
        this.relprev.setEnvolvidos("env2");

        final Response<?> r = this.relatorioDePrevencaoWebService.update(this.relprev);
        assertNotNull(r.getMessage());
    }

    @Test
    public void testDelete() throws Exception {
        final Response<?> r = this.relatorioDePrevencaoWebService.delete(this.relprev.getId());
        System.out.println(r.getMessage());
    }

    @Test
    public void testAddAcaoRecomendada() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final AcaoRecomendada acaoRecomendada = new AcaoRecomendada();
        acaoRecomendada.setDescricao("ação descrição");
        acaoRecomendada.setDestinatario("destinatario");
        acaoRecomendada.setRemetente("remetente");
        acaoRecomendada.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.addAcaoRecomendada(this.relprev.getId(), acaoRecomendada);
        assertNotNull(r);
    }

    @Test
    public void testUpdateAcaoRecomendada() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final AcaoRecomendada acaoRecomendada = new AcaoRecomendada();
        acaoRecomendada.setDescricao("ação descrição");
        acaoRecomendada.setDestinatario("destinatario 2");
        acaoRecomendada.setRemetente("remetente 2");
        acaoRecomendada.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.updateAcaoRecomendada(this.relprev.getId(), acaoRecomendada);
        assertNotNull(r);
    }

    @Test
    public void testAddClassificacaoRisco() throws Exception {

        relatorioDePrevencaoWebService.update(relprev);
        // System.out.println("\n\n"+relatorioDePrevencaoWebService.list().getData());

        final ClassificacaoRisco classificacaoRisco = new ClassificacaoRisco();
        classificacaoRisco.setAvaliacaoInicial("AA");
        classificacaoRisco.setAvaliacaoFinal("AB");
        classificacaoRisco.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.addClassificacaoDeRisco(this.relprev.getId(),
                classificacaoRisco);
        assertNotNull(r);
    }

    @Test
    public void testUpdateClassificacaoRisco() throws Exception {

        relatorioDePrevencaoWebService.update(relprev);
        // System.out.println("\n\n"+relatorioDePrevencaoWebService.list().getData());

        final ClassificacaoRisco classificacaoRisco = new ClassificacaoRisco();
        classificacaoRisco.setAvaliacaoInicial("AA");
        classificacaoRisco.setAvaliacaoFinal("AB");
        classificacaoRisco.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.updateClassificacaoDeRisco(this.relprev.getId(),
                classificacaoRisco);
        assertNotNull(r);
    }
    
    @Test
    public void testAddEncaminhamento() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final Encaminhamento encaminhamento = new Encaminhamento();
        encaminhamento.setDescricao("encaminhamento descrição");
        encaminhamento.setDestinatario("destinatario");
        encaminhamento.setRemetente("remetente");
        encaminhamento.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.addEncaminhamento(this.relprev.getId(), encaminhamento);
        assertNotNull(r);
    }

    @Test
    public void testUpdateEncaminhamento() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final Encaminhamento encaminhamento = new Encaminhamento();
        encaminhamento.setDescricao("encaminhamento descrição");
        encaminhamento.setDestinatario("destinatario 2");
        encaminhamento.setRemetente("remetente 2");
        encaminhamento.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.updateEncaminhamento(this.relprev.getId(), encaminhamento);
        assertNotNull(r);
    }
    
    @Test
    public void testAddObservacao() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final Observacao observacao = new Observacao();
        observacao.setDescricao("observacao descrição");
        observacao.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.addObservacao(this.relprev.getId(), observacao);
        assertNotNull(r);
    }

    @Test
    public void testUpdateObservacao() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final Observacao observacao = new Observacao();
        observacao.setDescricao("observacao descrição 2");
        observacao.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.updateObservacao(this.relprev.getId(), observacao);
        assertNotNull(r);
    }
    
    @Test
    public void testAddParecerSetor() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final ParecerSetor parecerSetor = new ParecerSetor();
        parecerSetor.setDescricao("parecerSetor descrição");
        parecerSetor.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.addParecerSetor(this.relprev.getId(), parecerSetor);
        assertNotNull(r);
    }

    @Test
    public void testUpdateParecerSetor() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final ParecerSetor parecerSetor = new ParecerSetor();
        parecerSetor.setDescricao("parecerSetor descrição 2");
        parecerSetor.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.updateParecerSetor(this.relprev.getId(), parecerSetor);
        assertNotNull(r);
    }
    
    @Test
    public void testAddResposta() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final Resposta resposta = new Resposta();
        resposta.setDescricao("resposta descrição");
        resposta.setDestinatario("destinatario");
        resposta.setRemetente("remetente");
        resposta.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.addResposta(this.relprev.getId(), resposta);
        assertNotNull(r);
    }

    @Test
    public void testUpdateResposta() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final Resposta resposta = new Resposta();
        resposta.setDescricao("resposta descrição");
        resposta.setDestinatario("destinatario 2");
        resposta.setRemetente("remetente 2");
        resposta.setRelPrev(this.relprev);

        final Response<?> r = this.relatorioDePrevencaoWebService.updateResposta(this.relprev.getId(), resposta);
        assertNotNull(r);
    }
    
    @Test
    public void testAddInserirEntidadeExistente() throws Exception {

        this.relatorioDePrevencaoWebService.update(this.relprev);
        //System.out.println("\n\n" + this.relatorioDePrevencaoWebService.list().getData());

        final Resposta resposta = new Resposta();
        resposta.setDescricao("resposta descrição");
        resposta.setDestinatario("destinatario");
        resposta.setRemetente("remetente");
        resposta.setRelPrev(this.relprev);

        Response<?> r = this.relatorioDePrevencaoWebService.addResposta(this.relprev.getId(), resposta);
        r = this.relatorioDePrevencaoWebService.addResposta(this.relprev.getId(), resposta);
        
        assertNotNull(r);
    }

    @Test(expected = NullPointerException.class)
    public void testAddAcaoRecomendadaException() throws Exception {
        this.relatorioDePrevencaoWebService.addAcaoRecomendada(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateAcaoRecomendadaException() throws Exception {
        this.relatorioDePrevencaoWebService.updateAcaoRecomendada(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteAcaoRecomendadaException() throws Exception {
        this.relatorioDePrevencaoWebService.deleteAcaoRecomendada(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddClassificacaoDeRiscoException() throws Exception {
        this.relatorioDePrevencaoWebService.addClassificacaoDeRisco(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateClassificacaoDeRiscoException() throws Exception {
        this.relatorioDePrevencaoWebService.updateClassificacaoDeRisco(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteClassificacaoDeRiscoException() throws Exception {
        this.relatorioDePrevencaoWebService.deleteClassificacaoDeRisco(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddEncaminhamentoException() throws Exception {
        this.relatorioDePrevencaoWebService.addEncaminhamento(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateEncaminhamentoException() throws Exception {
        this.relatorioDePrevencaoWebService.updateEncaminhamento(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteEncaminhamentoException() throws Exception {
        this.relatorioDePrevencaoWebService.deleteEncaminhamento(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddObservacaoException() throws Exception {
        this.relatorioDePrevencaoWebService.addObservacao(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateObservacaoException() throws Exception {
        this.relatorioDePrevencaoWebService.updateObservacao(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteObservacaoException() throws Exception {
        this.relatorioDePrevencaoWebService.deleteObservacao(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddParecerSetorException() throws Exception {
        this.relatorioDePrevencaoWebService.addParecerSetor(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateParecerSetorException() throws Exception {
        this.relatorioDePrevencaoWebService.updateParecerSetor(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteParecerSetorException() throws Exception {
        this.relatorioDePrevencaoWebService.deleteParecerSetor(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddRespostaException() throws Exception {
        this.relatorioDePrevencaoWebService.addResposta(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateRespostaException() throws Exception {
        this.relatorioDePrevencaoWebService.updateResposta(1L, null);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteRespostaException() throws Exception {
        this.relatorioDePrevencaoWebService.deleteResposta(1L, null);
    }
}
