package br.ufg.inf.repository.support;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import br.ufg.inf.model.support.Log;
import br.ufg.inf.model.support.TipoAlteracao;
import br.ufg.inf.repository.support.LogRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

/**
 * Testes para o Log de alterações de um objeto na Base de Dados
 * <P />
 * {@link #testSave()} <br />
 * {@link #testUpdate()} <br />
 * {@link #testDelete()} <br />
 * {@link #testFind()} <br />
 * {@link #testFindAll()} <br />
 *
 * @created 10/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Log
 * @see LogRepository
 */
@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContextTest-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class LogRepositoryTest {

    private final String SAVED_DB = "/databases/log/saved-db.xml";
    private final String INITIAL_DB = "/databases/log/initial-db.xml";

    @Autowired
    private LogRepository repository;

    @Test
    @DatabaseSetup(INITIAL_DB)
    @ExpectedDatabase(value = SAVED_DB, assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSave() {
        this.repository.save(this.getLog());
    }

    @DatabaseSetup(SAVED_DB)
    @Test(expected = JpaSystemException.class)
    public void testUpdate() {
        final Log log = new Log();
        log.setId(1L);
        log.setTabelaAlterada("relatorios_prevencao");
        log.setDescricaoAlteracao(String.format(TipoAlteracao.DELETE.getMensagem(), 1));
        log.setTipoAlteracao(TipoAlteracao.CREATE);
        this.repository.save(log);
    }

    @DatabaseSetup(SAVED_DB)
    @Test(expected = JpaSystemException.class)
    public void testDelete() {
        final Log log = this.getLog();
        log.setId(3L);
        this.repository.delete(log);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFind() {
        final Log result = this.repository.findOne(1L);
        final Matcher<Log> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                Matchers.hasProperty("tabelaAlterada", Matchers.is("elos_sipaer")),
                Matchers.hasProperty("descricaoAlteracao", Matchers.is(String.format(TipoAlteracao.CREATE.getMensagem(), 1))),
                Matchers.hasProperty("tipoAlteracao", Matchers.is(TipoAlteracao.CREATE)));
        Assert.assertThat(result, mat1);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindAll() {
        final List<Log> resultList = this.repository.findAll();
        Assert.assertThat(resultList.size(), Matchers.is(4));
        final Matcher<Log> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                Matchers.hasProperty("tabelaAlterada", Matchers.is("elos_sipaer")),
                Matchers.hasProperty("descricaoAlteracao", Matchers.is(String.format(TipoAlteracao.CREATE.getMensagem(), 1))),
                Matchers.hasProperty("tipoAlteracao", Matchers.is(TipoAlteracao.CREATE)));
        final Matcher<Log> mat2 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(2L)),
                Matchers.hasProperty("tabelaAlterada", Matchers.is("relatores")),
                Matchers.hasProperty("descricaoAlteracao", Matchers.is(String.format(TipoAlteracao.UPDATE.getMensagem(), 1, 2))),
                Matchers.hasProperty("tipoAlteracao", Matchers.is(TipoAlteracao.UPDATE)));
        final Matcher<Log> mat3 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(3L)),
                Matchers.hasProperty("tabelaAlterada", Matchers.is("situacoes")),
                Matchers.hasProperty("descricaoAlteracao", Matchers.is(String.format(TipoAlteracao.DELETE.getMensagem(), 1))),
                Matchers.hasProperty("tipoAlteracao", Matchers.is(TipoAlteracao.DELETE)));
        final Matcher<Log> mat4 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(4L)),
                Matchers.hasProperty("tabelaAlterada", Matchers.is("relatorios_prevencao")),
                Matchers.hasProperty("descricaoAlteracao", Matchers.is(String.format(TipoAlteracao.UPDATE.getMensagem(), 1, 2))),
                Matchers.hasProperty("tipoAlteracao", Matchers.is(TipoAlteracao.UPDATE)));
        Assert.assertThat(resultList, Matchers.contains(mat1, mat2, mat3, mat4));
    }

    private Log getLog() {
        final Log log = new Log();
        log.setTabelaAlterada("relatorios_prevencao");
        log.setDescricaoAlteracao(String.format(TipoAlteracao.DELETE.getMensagem(), 1));
        log.setTipoAlteracao(TipoAlteracao.DELETE);
        return log;
    }

}
