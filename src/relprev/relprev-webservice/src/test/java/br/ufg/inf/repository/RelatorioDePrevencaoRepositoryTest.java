package br.ufg.inf.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.model.RelPrev;
import br.ufg.inf.model.Relator;
import br.ufg.inf.model.Situacao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * Testes para {@link RelatorioDePrevencaoRepository}
 *
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContextTest-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
// TODO verificar o funcionamento do ExpectedDatabase
// TODO atualizar teste para testar os objetos encadeados
public class RelatorioDePrevencaoRepositoryTest {

    private final String LOCAL = "Local 1";
    private final String DESCRICAO = "Descrição 2";

    private final String INITIAL_DB = "/databases/relprev/initial-db.xml";
    private final String SAVE_DB = "/databases/relprev/saved-db.xml";
    private final String UPDATE_DB = "/databases/relprev/updated-db.xml";

    @Autowired
    private RelatorioDePrevencaoRepository repository;

    @Test
    @DatabaseSetup(INITIAL_DB)
    // @ExpectedDatabase(SAVE_DB)
    public void testSave() {
        this.repository.save(this.getrRelPrevTest());
    }

    @Test
    @DatabaseSetup(SAVE_DB)
    // @ExpectedDatabase(UPDATE_DB)
    public void testUpdate() {
        final RelPrev relPrevUpdate = this.getrRelPrevTest();
        relPrevUpdate.setEnvolvidos("Teste Envolvidos Alterados");
        relPrevUpdate.setDescricaoSituacaoPerigosa("Teste Descrição Alterada");
        this.repository.save(relPrevUpdate);
    }

    @Test
    @DatabaseSetup(UPDATE_DB)
    // @ExpectedDatabase(INITIAL_DB)
    public void testDelete() {
        this.repository.delete(this.getrRelPrevTest());
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindByLocalIgnoreCase() {
        final List<RelPrev> resultList = this.repository.findByLocalIgnoreCase(this.LOCAL);
        Assert.assertThat(resultList.size(), Matchers.is(1));
        Assert.assertThat(
                resultList,
                Matchers.contains(Matchers.allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                        Matchers.hasProperty("envolvidos", Matchers.is("Envolvidos RelPrev 1")),
                        Matchers.hasProperty("local", Matchers.is("Local 1")),
                        Matchers.hasProperty("descricaoSituacaoPerigosa", Matchers.is("Descricao 1")))));
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindByDescricaoSituacaoPerigosaContainsIgnoreCase() {
        final List<RelPrev> resultList = this.repository
                .findByDescricaoSituacaoPerigosaContainsIgnoreCase(this.DESCRICAO);
        Assert.assertThat(resultList.size(), Matchers.is(1));
        Assert.assertThat(
                resultList,
                Matchers.contains(Matchers.allOf(Matchers.hasProperty("id", Matchers.is(2L)),
                        Matchers.hasProperty("envolvidos", Matchers.is("Envolvidos RelPrev 2")),
                        Matchers.hasProperty("local", Matchers.is("Local 2")),
                        Matchers.hasProperty("descricaoSituacaoPerigosa", Matchers.is("Descrição 2")))));
    }

    private RelPrev getrRelPrevTest() {
        final Date dataInsercaoAlteracao = this.getDataInsercaoAlteracao();
        // elo sipaer
        final EloSipaer elo = new EloSipaer();
        elo.setOrganizacao("Organização 3");
        elo.setSiglaOrganizacao("ORG3");
        elo.setDataInsercaoAlteracao(dataInsercaoAlteracao);

        // relator
        final Relator relator = new Relator();
        relator.setNome("Relator 3");
        relator.setEmail("relator.tres@email.com.br");
        relator.setTelefone("3333333333");
        relator.setDataInsercaoAlteracao(dataInsercaoAlteracao);

        // situação
        final Situacao situacao = new Situacao();
        situacao.setDescricao("Situação 5");
        situacao.setDataInsercaoAlteracao(dataInsercaoAlteracao);

        final RelPrev relPrev = new RelPrev();
        relPrev.setEnvolvidos("Envolvidos RelPrev 3");
        relPrev.setLocal("Local 3");
        relPrev.setDataInsercaoAlteracao(dataInsercaoAlteracao);
        relPrev.setDataSituacaoPerigosa(dataInsercaoAlteracao);
        relPrev.setEloSipaer(elo);
        relPrev.setRelator(relator);
        final Set<Situacao> set = new HashSet<Situacao>();
        set.add(situacao);
        relPrev.setSituacoes(set);
        return relPrev;
    }

    private Date getDataInsercaoAlteracao() {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2013);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 5);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

}
