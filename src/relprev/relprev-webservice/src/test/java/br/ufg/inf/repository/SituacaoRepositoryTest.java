package br.ufg.inf.repository;

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

import br.ufg.inf.model.Situacao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

/**
 * Testes para Situação
 * <P />
 * {@link #testSave()} <br />
 * {@link #testUpdate()} <br />
 * {@link #testDelete()} <br />
 * {@link #testFind()} <br />
 * {@link #testFindAll()} <br />
 *
 * @created 10/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Situacao
 * @see SituacaoRepository
 */
@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContextTest-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class SituacaoRepositoryTest {

    private final String SAVED_DB = "/databases/situacao/saved-db.xml";
    private final String DELETED_DB = "/databases/situacao/deleted-db.xml";
    private final String INITIAL_DB = "/databases/situacao/initial-db.xml";
    private final String UPDATED_DB = "/databases/situacao/updated-db.xml";

    @Autowired
    private SituacaoRepository repository;

    @Test
    @DatabaseSetup(INITIAL_DB)
    @ExpectedDatabase(value = SAVED_DB, assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSave() {
        this.repository.save(this.getSituacao());
    }

    @Test
    @Ignore // TODO verificar dataset
    @DatabaseSetup(SAVED_DB)
    @ExpectedDatabase(value = UPDATED_DB, assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() {
        final Situacao situacao = new Situacao();
        situacao.setId(3L);
        situacao.setDescricao("Nova Situação 3");
        this.repository.save(situacao);
    }

    @Test
    @Ignore // TODO verificar dataset
    @DatabaseSetup(UPDATED_DB)
    @ExpectedDatabase(value = DELETED_DB, assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDelete() {
        final Situacao situacao = this.getSituacao();
        situacao.setId(5L);
        this.repository.delete(situacao);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFind() {
        final Situacao result = this.repository.findOne(4L);
        final Matcher<Situacao> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(4L)),
                Matchers.hasProperty("descricao", Matchers.is("Situação 4")), Matchers.hasProperty("hidden", Matchers.is(false)));
        Assert.assertThat(result, mat1);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindAll() {
        final List<Situacao> resultList = this.repository.findAll();
        Assert.assertThat(resultList.size(), Matchers.is(4));
        final Matcher<Situacao> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                Matchers.hasProperty("descricao", Matchers.is("Situação 1")), Matchers.hasProperty("hidden", Matchers.is(false)));
        final Matcher<Situacao> mat2 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(2L)),
                Matchers.hasProperty("descricao", Matchers.is("Situação 2")), Matchers.hasProperty("hidden", Matchers.is(false)));
        final Matcher<Situacao> mat3 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(3L)),
                Matchers.hasProperty("descricao", Matchers.is("Situação 3")), Matchers.hasProperty("hidden", Matchers.is(false)));
        final Matcher<Situacao> mat4 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(4L)),
                Matchers.hasProperty("descricao", Matchers.is("Situação 4")), Matchers.hasProperty("hidden", Matchers.is(false)));
        Assert.assertThat(resultList, Matchers.contains(mat1, mat2, mat3, mat4));
    }

    private Situacao getSituacao() {
        final Situacao situacao = new Situacao();
        situacao.setDescricao("Situação 5");
        return situacao;
    }

}
