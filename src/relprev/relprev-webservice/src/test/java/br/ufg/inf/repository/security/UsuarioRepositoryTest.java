package br.ufg.inf.repository.security;

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

import br.ufg.inf.model.security.Usuario;
import br.ufg.inf.model.test.UsuarioBuilder;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

/**
 * Testes para o {@link Usuario}
 *
 * @created 20/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Usuario
 * @see UsuarioRepository
 */
@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContextTest-persistence.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UsuarioRepositoryTest {

    private final String SAVED_DB = "/databases/usuario/saved-db.xml";
    private final String DELETED_DB = "/databases/usuario/deleted-db.xml";
    private final String INITIAL_DB = "/databases/usuario/initial-db.xml";
    private final String UPDATED_DB = "/databases/usuario/updated-db.xml";

    @Autowired
    private UsuarioRepository repository;

    @Test
    @DatabaseSetup(INITIAL_DB)
    @ExpectedDatabase(value = SAVED_DB, assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSave() {
        this.repository.save(this.getUsuario());
    }

    @Test
    @DatabaseSetup(SAVED_DB)
    @Ignore // TODO verificar dataset
    @ExpectedDatabase(value = UPDATED_DB, assertionMode = NON_STRICT)
    public void testUpdate() {
        final Usuario usuario = new UsuarioBuilder().id(3L).email("EMAIL3@EMAIL.COM").funcao("Função 3 Nova").nome("Nome Completo 3 Novo")
                .posto("Posto 3 Novo").siglaSecao("SS3N").fixo("8888888888").usuario("user.three").ativo(true)
                .senha("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka").build();
        this.repository.save(usuario);
    }

    @Test
    @DatabaseSetup(UPDATED_DB)
    @Ignore // TODO verificar dataset
    @ExpectedDatabase(value = DELETED_DB, assertionMode = NON_STRICT)
    public void testDelete() {
        final Usuario elo = repository.findOne(4L);
        this.repository.delete(elo);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindByEmailLowerCase() {
        final Usuario result = this.repository.findByEmailIgnoreCase("email1@email.com");
        final Matcher<Usuario> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                Matchers.hasProperty("email", Matchers.is("email1@email.com")),
                Matchers.hasProperty("especialidade", Matchers.is("Especialidade 1")),
                Matchers.hasProperty("funcao", Matchers.is("Função 1")),
                Matchers.hasProperty("nomeCompleto", Matchers.is("Nome Completo 1")),
                Matchers.hasProperty("posto", Matchers.is("Posto 1")),
                Matchers.hasProperty("siglaSecao", Matchers.is("SS1")),
                Matchers.hasProperty("telefoneCelular", Matchers.is("1111111111")),
                Matchers.hasProperty("telefoneFixo", Matchers.is("2222222222")),
                Matchers.hasProperty("usuario", Matchers.is("user.one")),
                Matchers.hasProperty("senha", Matchers.is("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka")),
                Matchers.hasProperty("ativo", Matchers.is(true)));
        Assert.assertThat(result, mat1);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindByEmailUpperCase() {
        final Usuario result = this.repository.findByEmailIgnoreCase("EMAIL1@EMAIL.COM");
        final Matcher<Usuario> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                Matchers.hasProperty("email", Matchers.is("email1@email.com")),
                Matchers.hasProperty("especialidade", Matchers.is("Especialidade 1")),
                Matchers.hasProperty("funcao", Matchers.is("Função 1")),
                Matchers.hasProperty("nomeCompleto", Matchers.is("Nome Completo 1")),
                Matchers.hasProperty("posto", Matchers.is("Posto 1")),
                Matchers.hasProperty("siglaSecao", Matchers.is("SS1")),
                Matchers.hasProperty("telefoneCelular", Matchers.is("1111111111")),
                Matchers.hasProperty("telefoneFixo", Matchers.is("2222222222")),
                Matchers.hasProperty("usuario", Matchers.is("user.one")),
                Matchers.hasProperty("senha", Matchers.is("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka")),
                Matchers.hasProperty("ativo", Matchers.is(true)));
        Assert.assertThat(result, mat1);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindByUsuario_Exists() {
        final Usuario result = this.repository.findByUsuario("user.three");
        final Matcher<Usuario> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(3L)),
                Matchers.hasProperty("funcao", Matchers.is("Função 3")),
                Matchers.hasProperty("nomeCompleto", Matchers.is("Nome Completo 3")),
                Matchers.hasProperty("posto", Matchers.is("Posto 3")),
                Matchers.hasProperty("siglaSecao", Matchers.is("SS3")),
                Matchers.hasProperty("telefoneCelular", Matchers.is("5555555555")),
                Matchers.hasProperty("usuario", Matchers.is("user.three")),
                Matchers.hasProperty("senha", Matchers.is("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka")),
                Matchers.hasProperty("ativo", Matchers.is(true)));
        Assert.assertThat(result, mat1);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindByUsuario_NotExists() {
        final Usuario result = this.repository.findByUsuario("USER.THREE");
        Assert.assertNull(result);
    }

    @Test
    @DatabaseSetup(INITIAL_DB)
    public void testFindAll() {
        final List<Usuario> resultList = this.repository.findAll();
        Assert.assertThat(resultList.size(), Matchers.is(4));
        final Matcher<Usuario> mat1 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(1L)),
                Matchers.hasProperty("email", Matchers.is("email1@email.com")),
                Matchers.hasProperty("especialidade", Matchers.is("Especialidade 1")),
                Matchers.hasProperty("funcao", Matchers.is("Função 1")),
                Matchers.hasProperty("nomeCompleto", Matchers.is("Nome Completo 1")),
                Matchers.hasProperty("posto", Matchers.is("Posto 1")),
                Matchers.hasProperty("siglaSecao", Matchers.is("SS1")),
                Matchers.hasProperty("telefoneCelular", Matchers.is("1111111111")),
                Matchers.hasProperty("telefoneFixo", Matchers.is("2222222222")),
                Matchers.hasProperty("usuario", Matchers.is("user.one")),
                Matchers.hasProperty("senha", Matchers.is("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka")),
                Matchers.hasProperty("ativo", Matchers.is(true)));
        final Matcher<Usuario> mat2 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(2L)),
                Matchers.hasProperty("funcao", Matchers.is("Função 2")),
                Matchers.hasProperty("nomeCompleto", Matchers.is("Nome Completo 2")),
                Matchers.hasProperty("posto", Matchers.is("Posto 2")),
                Matchers.hasProperty("siglaSecao", Matchers.is("SS2")),
                Matchers.hasProperty("telefoneCelular", Matchers.is("3333333333")),
                Matchers.hasProperty("telefoneFixo", Matchers.is("4444444444")),
                Matchers.hasProperty("usuario", Matchers.is("user.two")),
                Matchers.hasProperty("senha", Matchers.is("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka")),
                Matchers.hasProperty("ativo", Matchers.is(true)));
        final Matcher<Usuario> mat3 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(3L)),
                Matchers.hasProperty("funcao", Matchers.is("Função 3")),
                Matchers.hasProperty("nomeCompleto", Matchers.is("Nome Completo 3")),
                Matchers.hasProperty("posto", Matchers.is("Posto 3")),
                Matchers.hasProperty("siglaSecao", Matchers.is("SS3")),
                Matchers.hasProperty("telefoneCelular", Matchers.is("5555555555")),
                Matchers.hasProperty("usuario", Matchers.is("user.three")),
                Matchers.hasProperty("senha", Matchers.is("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka")),
                Matchers.hasProperty("ativo", Matchers.is(true)));
        final Matcher<Usuario> mat4 = Matchers.allOf(Matchers.hasProperty("id", Matchers.is(4L)),
                Matchers.hasProperty("email", Matchers.is("EMAIL2@EMAIL.COM")),
                Matchers.hasProperty("funcao", Matchers.is("Função 4")),
                Matchers.hasProperty("nomeCompleto", Matchers.is("Nome Completo 4")),
                Matchers.hasProperty("posto", Matchers.is("Posto 4")),
                Matchers.hasProperty("siglaSecao", Matchers.is("SS4")),
                Matchers.hasProperty("telefoneFixo", Matchers.is("6666666666")),
                Matchers.hasProperty("usuario", Matchers.is("user.four")),
                Matchers.hasProperty("senha", Matchers.is("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka")),
                Matchers.hasProperty("ativo", Matchers.is(true)));
        Assert.assertThat(resultList, Matchers.contains(mat1, mat2, mat3, mat4));
    }

    private Usuario getUsuario() {
        return new UsuarioBuilder().email("EMAIL5@EMAIL.COM").funcao("Função 5").nome("Nome Completo 5").posto("Posto 5").siglaSecao("SS5")
                .fixo("7777777777").usuario("user.five").senha("af9afu9ahf9sfyagha98u3rgkljnv9e85u983o4thoflshdg9o8g89osudf9as8g789gsaud980g7as90d78gfashopva09387q49oyhfoag987sa09vgya9sdg79aka")
                .ativo(true).build();
    }

}
