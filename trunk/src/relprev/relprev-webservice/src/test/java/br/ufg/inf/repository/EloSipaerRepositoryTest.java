package br.ufg.inf.repository;

import static com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT;

import java.util.List;

import org.hamcrest.Matcher;
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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

/**
 * Testes para {@link EloSipaer}
 *
 * @created 10/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContextTest-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class EloSipaerRepositoryTest {

    private final String SAVED_DB = "/databases/elosipaer/saved-db.xml";
    private final String DELETED_DB = "/databases/elosipaer/deleted-db.xml";
    private final String INITIAL_DB = "/databases/elosipaer/initial-db.xml";
    private final String UPDATED_DB = "/databases/elosipaer/updated-db.xml";

    @Autowired
    private EloSipaerRepository repository;

    @Test
    @DatabaseSetup(INITIAL_DB)
    @ExpectedDatabase(value = SAVED_DB, assertionMode = NON_STRICT)
    public void testSave() {
        this.repository.save(this.getEloSipaer());
    }

    @Test
    @Ignore // TODO verificar dataset
    @DatabaseSetup(SAVED_DB)
    @ExpectedDatabase(value = UPDATED_DB, assertionMode = NON_STRICT)
    public void testUpdate() {
        final EloSipaer elo = new EloSipaer();
        elo.setId(1L);
        elo.setSiglaOrganizacao("ORG1N");
        elo.setOrganizacao("Nova Versão da Organização 1");
        this.repository.save(elo);
    }

    @Test
    @Ignore // TODO verificar dataset
    @DatabaseSetup(UPDATED_DB)
    @ExpectedDatabase(value = DELETED_DB, assertionMode = NON_STRICT)
    public void testDelete() {
        final EloSipaer elo = this.getEloSipaer();
        elo.setId(3L);
        this.repository.delete(elo);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFind() {
        final EloSipaer result = this.repository.findOne(1L);
        final Matcher<EloSipaer> mat1 = Matchers
                .allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                        Matchers.hasProperty("organizacao", Matchers.is("Organização 1")),
                        Matchers.hasProperty("siglaOrganizacao", Matchers.is("ORG1")),
                        Matchers.hasProperty("hidden", Matchers.is(false)));
        Assert.assertThat(result, mat1);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindAll() {
        final List<EloSipaer> resultList = this.repository.findAll();
        Assert.assertThat(resultList.size(), Matchers.is(2));
        final Matcher<EloSipaer> mat1 = Matchers
                .allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                        Matchers.hasProperty("organizacao", Matchers.is("Organização 1")),
                        Matchers.hasProperty("siglaOrganizacao", Matchers.is("ORG1")),
                        Matchers.hasProperty("hidden", Matchers.is(false)));
        final Matcher<EloSipaer> mat2 = Matchers
                .allOf(Matchers.hasProperty("id", Matchers.is(2L)),
                        Matchers.hasProperty("organizacao", Matchers.is("Organização 2")),
                        Matchers.hasProperty("siglaOrganizacao", Matchers.is("ORG2")),
                        Matchers.hasProperty("hidden", Matchers.is(false)));
        Assert.assertThat(resultList, Matchers.contains(mat1, mat2));
    }

    private EloSipaer getEloSipaer() {
        final EloSipaer elo = new EloSipaer();
        elo.setOrganizacao("Organização 3");
        elo.setSiglaOrganizacao("ORG3");
        return elo;
    }

}
