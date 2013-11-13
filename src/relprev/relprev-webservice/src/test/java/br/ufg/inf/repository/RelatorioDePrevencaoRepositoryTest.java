package br.ufg.inf.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

/**
 * Testes para Relatórios de Prevenção
 * <P />
 * {@link #testSave()} <br />
 * {@link #testUpdate()} <br />
 * {@link #testDelete()} <br />
 * {@link #testFind()} <br />
 * {@link #testFindAll()} <br />
 * {@link #testFindByDescricaoSituacaoPerigosaContainsIgnoreCase()} <br />
 * {@link #testFindByLocalIgnoreCase()} <br />
 *
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see RelPrev
 * @see RelatorioDePrevencaoRepository
 */
@Ignore // TODO ajustar os datasets
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContextTest-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class RelatorioDePrevencaoRepositoryTest {

    private final String SAVED_DB = "/databases/relprev/saved-db.xml";
    private final String DELETED_DB = "/databases/relprev/deleted-db.xml";
    private final String INITIAL_DB = "/databases/relprev/initial-db.xml";
    private final String UPDATED_DB = "/databases/relprev/updated-db.xml";

    @Autowired
    private RelatorioDePrevencaoRepository repository;

    @Test
    @DatabaseSetup(INITIAL_DB)
    @ExpectedDatabase(value = SAVED_DB, assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSave() {
        this.repository.save(this.getrRelPrevTest());
    }

    @Test
    @DatabaseSetup(SAVED_DB)
    @ExpectedDatabase(value = UPDATED_DB, assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() {
        final RelPrev relPrevUpdate = this.getrRelPrevTest();
        relPrevUpdate.setEnvolvidos("Teste Envolvidos Alterados");
        relPrevUpdate.setDescricaoSituacaoPerigosa("Teste Descrição Alterada");
        this.repository.save(relPrevUpdate);
    }

    @Test
    @DatabaseSetup(UPDATED_DB)
    @ExpectedDatabase(value = DELETED_DB, assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDelete() {
        this.repository.delete(this.getrRelPrevTest());
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFind() {

    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindAll() {

    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindByLocalIgnoreCase() {
        final List<RelPrev> resultList = this.repository.findByLocalIgnoreCase("Local 1");
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
        final List<RelPrev> resultList = this.repository.findByDescricaoSituacaoPerigosaContainsIgnoreCase("Descrição 2");
        Assert.assertThat(resultList.size(), Matchers.is(1));
        Assert.assertThat(
                resultList,
                Matchers.contains(Matchers.allOf(Matchers.hasProperty("id", Matchers.is(2L)),
                        Matchers.hasProperty("envolvidos", Matchers.is("Envolvidos RelPrev 2")),
                        Matchers.hasProperty("local", Matchers.is("Local 2")),
                        Matchers.hasProperty("descricaoSituacaoPerigosa", Matchers.is("Descrição 2")))));
    }

    private RelPrev getrRelPrevTest() {
        // elo sipaer
        final EloSipaer elo = new EloSipaer();
        elo.setOrganizacao("Organização 3");
        elo.setSiglaOrganizacao("ORG3");

        // relator
        final Relator relator = new Relator();
        relator.setNome("Relator 3");
        relator.setEmail("relator.tres@email.com.br");
        relator.setTelefone("3333333333");


        final RelPrev relPrev = new RelPrev();
        relPrev.setEnvolvidos("Envolvidos RelPrev 3");
        relPrev.setLocal("Local 3");
        relPrev.setDataSituacaoPerigosa(this.getDataInsercaoAlteracao());
        relPrev.setEloSipaer(elo);
        relPrev.setRelator(relator);
        relPrev.setSituacao("tensa");
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
