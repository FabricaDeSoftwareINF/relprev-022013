package br.ufg.inf.service;

import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.model.security.Usuario;
import br.ufg.inf.repository.EloSipaerRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.Response;
import br.ufg.inf.repository.security.UsuarioRepository;
import br.ufg.inf.service.security.UsuarioWebService;

/**
 * Testes para os endpoints REST dos Usuários
 * 
 * @created 12/12/2013
 * @author Raul Barca
 */
@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContextTest-mvc.xml",
        "classpath:META-INF/spring/applicationContextTest-persistence.xml"})
@TransactionConfiguration(defaultRollback = true)
public class UsuarioWebServiceTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EloSipaerRepository eloSipaerRepository;

    @Autowired
    private LogRepository logRepository;

    private UsuarioWebService usuarioWebService;

    @Before
    public void setUp() {
        this.usuarioWebService = new UsuarioWebService(this.usuarioRepository,
                this.logRepository);

        final Usuario usuario = new Usuario();
        usuario.setAtivo(true);
        usuario.setDataInsercaoAlteracao(new Date());
        usuario.setNomeCompleto("teste nome");
        usuario.setFuncao("funçaõ");
        usuario.setPosto("posto");
        usuario.setSenha("86f7b7fc676c5f7006a9c80ac531bf9ef3b4d21a");
        usuario.setSiglaSecao("SIGLA");
        usuario.setUsuario("usuario");

        final EloSipaer eloSipaer = new EloSipaer();
        eloSipaer.setDataInsercaoAlteracao(new Date());
        eloSipaer.setOrganizacao("teste organização");
        eloSipaer.setSiglaOrganizacao("SIGLA");
        eloSipaer.setUsuario(usuario);

        this.eloSipaerRepository.save(eloSipaer);
    }

    @Test
    public void testFindUsuarioByUsuario() throws Exception {
        final Response<?> r = this.usuarioWebService.findUsuarioByUsuario("usuario");
        assertNotNull(r);
    }

}
