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
@ContextConfiguration({"classpath:META-INF/spring/applicationContextTest-mvc.xml","classpath:META-INF/spring/applicationContextTest-persistence.xml"})
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
    	relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(relatorioDePrevencaoRepository, logRepository);
    	
    	relprev = new RelatorioPrevencao();
    	
    	Usuario usuario = new Usuario();
    	usuario.setAtivo(true);
    	usuario.setDataInsercaoAlteracao(new Date());
    	usuario.setNomeCompleto("teste nome");
    	usuario.setFuncao("funçaõ");
    	usuario.setPosto("posto");
    	usuario.setSenha("d131dd02c5e6eec4693d9a0698aff95c2fcab58712467eab4004583eb8fb7f89d15431dd02c5e6eec4693d9a0698aff95c2fcab58712467eab4004583eb8fb7f");
    	usuario.setSiglaSecao("SIGLA");
    	usuario.setUsuario("usuario");
    	
    	EloSipaer eloSipaer = new EloSipaer();
    	eloSipaer.setDataInsercaoAlteracao(new Date());
    	eloSipaer.setOrganizacao("teste organização");
    	eloSipaer.setSiglaOrganizacao("SIGLA");
    	eloSipaer.setUsuario(usuario);
    	
    	eloSipaerRepository.save(eloSipaer);
    	
    	Situacao situacao = new Situacao();
    	situacao.setFoiConcluido(false);
    	situacao.setTemAcaoRecomendada(false);
    	situacao.setTemDivulgacao(false);
    	situacao.setTemEncaminhamento(false);
    	
    	relprev.setDataInsercaoAlteracao(new Date());
    	relprev.setDataSituacaoPerigosa(new Date());
    	relprev.setDescricaoSituacaoPerigosa("teste descrição");
    	relprev.setEloSipaer(eloSipaer);
    	relprev.setEnvolvidos("teste envolvidos");
    	relprev.setLocal("teste local");
    	relprev.setSituacoes(situacao);
    	
    	relatorioDePrevencaoWebService.create(relprev);
    }

    @Test
    public void testFindRelPrevByLocal() throws Exception {
    	Response<?> r = relatorioDePrevencaoWebService.findRelPrevByLocal("teste local");
    	
    	assertNotNull(r);
    }

    @Test
    public void testFindRelPrevByDescricao() throws Exception {
    	Response<?> r = relatorioDePrevencaoWebService.findRelPrevByDescricao("teste descrição");
    	
    	assertNotNull(r);
    }
    
    @Test
    public void testFindRelPrevByLocalException() throws Exception {
    	relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(null, logRepository);
    	Response<RelatorioPrevencao> r = relatorioDePrevencaoWebService.findRelPrevByLocal("Teste");
    	
    	assertNotNull(r);
    }

    @Test
    public void testFindRelPrevByDescricaoException() throws Exception {
    	relatorioDePrevencaoWebService = new RelatorioDePrevencaoWebService(null, logRepository);
    	Response<?> r = relatorioDePrevencaoWebService.findRelPrevByDescricao("Teste");
    	
    	assertNotNull(r);
    }
    
    @Test
    public void testUpdate() throws Exception {
    	relprev.setEnvolvidos("env2");

    	Response<?> r =relatorioDePrevencaoWebService.update(relprev);
    	assertNotNull(r.getMessage());
    }
    
    @Test
    public void testDelete() throws Exception {
    	Response<?> r =relatorioDePrevencaoWebService.delete(relprev.getId());
    	System.out.println(r.getMessage());
    }
    
    @Test
    public void testAddAcaoRecomendada() throws Exception {
    	
    	relatorioDePrevencaoWebService.update(relprev);
    	System.out.println("\n\n"+relatorioDePrevencaoWebService.list().getData());
    	
    	AcaoRecomendada acaoRecomendada = new AcaoRecomendada();
    	acaoRecomendada.setDescricao("ação descrição");
    	acaoRecomendada.setDestinatario("destinatario");
    	acaoRecomendada.setRemetente("remetente");
    	acaoRecomendada.setRelPrev(relprev);
    	
    	Response<?> r = relatorioDePrevencaoWebService.addAcaoRecomendada(relprev.getId(), acaoRecomendada);
    	assertNotNull(r);
    }
    
    @Test
    public void testUpdateAcaoRecomendada() throws Exception {
    	
    	relatorioDePrevencaoWebService.update(relprev);
    	System.out.println("\n\n"+relatorioDePrevencaoWebService.list().getData());
    	
    	AcaoRecomendada acaoRecomendada = new AcaoRecomendada();
    	acaoRecomendada.setDescricao("ação descrição");
    	acaoRecomendada.setDestinatario("destinatario 2");
    	acaoRecomendada.setRemetente("remetente 2");
    	acaoRecomendada.setRelPrev(relprev);
    	
    	Response<?> r = relatorioDePrevencaoWebService.updateAcaoRecomendada(relprev.getId(), acaoRecomendada);
    	assertNotNull(r);
    }
        
    @Test(expected = NullPointerException.class) 
    public void testAddAcaoRecomendadaException() throws Exception {
    	relatorioDePrevencaoWebService.addAcaoRecomendada(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateAcaoRecomendadaException() throws Exception {
    	relatorioDePrevencaoWebService.updateAcaoRecomendada(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteAcaoRecomendadaException() throws Exception {
    	relatorioDePrevencaoWebService.deleteAcaoRecomendada(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddClassificacaoDeRiscoException() throws Exception {
    	relatorioDePrevencaoWebService.addClassificacaoDeRisco(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateClassificacaoDeRiscoException() throws Exception {
    	relatorioDePrevencaoWebService.updateClassificacaoDeRisco(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteClassificacaoDeRiscoException() throws Exception {
    	relatorioDePrevencaoWebService.deleteClassificacaoDeRisco(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddEncaminhamentoException() throws Exception {
    	relatorioDePrevencaoWebService.addEncaminhamento(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateEncaminhamentoException() throws Exception {
    	relatorioDePrevencaoWebService.updateEncaminhamento(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteEncaminhamentoException() throws Exception {
    	relatorioDePrevencaoWebService.deleteEncaminhamento(1L, null);
    }

    @Test(expected = NullPointerException.class) 
    public void testAddObservacaoException() throws Exception {
    	relatorioDePrevencaoWebService.addObservacao(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateObservacaoException() throws Exception {
    	relatorioDePrevencaoWebService.updateObservacao(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteObservacaoException() throws Exception {
    	relatorioDePrevencaoWebService.deleteObservacao(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddParecerSetorException() throws Exception {
    	relatorioDePrevencaoWebService.addParecerSetor(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateParecerSetorException() throws Exception {
    	relatorioDePrevencaoWebService.updateParecerSetor(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteParecerSetorException() throws Exception {
    	relatorioDePrevencaoWebService.deleteParecerSetor(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testAddRespostaException() throws Exception {
    	relatorioDePrevencaoWebService.addResposta(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testUpdateRespostaException() throws Exception {
    	relatorioDePrevencaoWebService.updateResposta(1L, null);
    }
    
    @Test(expected = NullPointerException.class) 
    public void testDeleteRespostaException() throws Exception {
    	relatorioDePrevencaoWebService.deleteResposta(1L, null);
    }
}
