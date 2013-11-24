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

import br.ufg.inf.model.Taxonomia;
import br.ufg.inf.model.test.TaxonomiaBuilder;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

/**
 * Testes para {@link Taxonomia}
 *
 * @created 10/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Taxonomia
 * @see TaxonomiaRepository
 */
@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContextTest-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class TaxonomiaRepositoryTest {

    private final String SAVED_DB = "/databases/taxonomia/saved-db.xml";
    private final String DELETED_DB = "/databases/taxonomia/deleted-db.xml";
    private final String INITIAL_DB = "/databases/taxonomia/initial-db.xml";
    private final String UPDATED_DB = "/databases/taxonomia/updated-db.xml";

    @Autowired
    private TaxonomiaRepository repository;

    @Test
    @DatabaseSetup(INITIAL_DB)
    @ExpectedDatabase(value = SAVED_DB, assertionMode = NON_STRICT)
    public void testSave() {
        this.repository.save(this.getTaxonomia());
    }

    @Test
    @Ignore
    @DatabaseSetup(SAVED_DB)
    @ExpectedDatabase(value = UPDATED_DB, assertionMode = NON_STRICT)
    public void testUpdate() {
        final Taxonomia taxonomia = new TaxonomiaBuilder().id(1L).nome("Nova Versão da Taxonomia 1").status(true).padrao(false)
                .build();
        this.repository.save(taxonomia);
    }

    @Test
    @Ignore
    @DatabaseSetup(UPDATED_DB)
    @ExpectedDatabase(value = DELETED_DB, assertionMode = NON_STRICT)
    public void testDelete() {
        final Taxonomia taxonomia = this.getTaxonomia();
        taxonomia.setId(3L);
        this.repository.delete(taxonomia);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFind() {
        final Taxonomia result = this.repository.findOne(2L);
        final Matcher<Taxonomia> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(2L)),
                Matchers.hasProperty("nome", Matchers.is("Taxonomia 2")), Matchers.hasProperty("status", Matchers.is(true)),
                Matchers.hasProperty("padraoMinimo", Matchers.is(false)), Matchers.hasProperty("hidden", Matchers.is(false)));
        Assert.assertThat(result, mat1);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindAll() {
        final List<Taxonomia> resultList = this.repository.findAll();
        Assert.assertThat(resultList.size(), Matchers.is(2));
        final Matcher<Taxonomia> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                Matchers.hasProperty("nome", Matchers.is("Taxonomia 1")), Matchers.hasProperty("status", Matchers.is(false)),
                Matchers.hasProperty("padraoMinimo", Matchers.is(true)), Matchers.hasProperty("hidden", Matchers.is(false)));
        final Matcher<Taxonomia> mat2 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(2L)),
                Matchers.hasProperty("nome", Matchers.is("Taxonomia 2")), Matchers.hasProperty("status", Matchers.is(true)),
                Matchers.hasProperty("padraoMinimo", Matchers.is(false)), Matchers.hasProperty("hidden", Matchers.is(false)));
        Assert.assertThat(resultList, Matchers.contains(mat1, mat2));
    }

    private Taxonomia getTaxonomia() {
        return new TaxonomiaBuilder().nome("Taxonomia 3").status(false).padrao(true).build();
    }

}
