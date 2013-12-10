package br.ufg.inf.service.security;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufg.inf.model.security.Usuario;
import br.ufg.inf.repository.security.UsuarioRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.GenericWebService;
import br.ufg.inf.service.support.Response;
import br.ufg.inf.service.support.ResponseBuilder;
import br.ufg.inf.service.support.ResponseMessages;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços para o {@link Usuario}
 * 
 * @created 09/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericWebService
 */
@Controller
@RequestMapping(value = WebServicesURL.URL_USUARIO)
public class UsuarioWebService extends GenericWebService<Usuario, UsuarioRepository> {

    @Autowired
    public UsuarioWebService(final UsuarioRepository repository, final LogRepository logRepository) {
        super(repository, logRepository);
    }

    /**
     * Busca por usuário pelo login fornecido
     * 
     * @param login
     *            login a ser consultado
     * @return {@link Usuario}
     */
    @ResponseBody
    @RequestMapping(value = "/{login}", method = {GET, POST}, produces = APPLICATION_JSON)
    public Response<Usuario> findUsuarioByUsuario(@PathVariable("login") final String login) {
        Response<Usuario> response;
        this.getLogger().debug("buscando usuário pelo login '" + login + "'");
        try {
            final Usuario usuario = this.getRepository().findByUsuario(login);
            if (usuario != null) {
                response = new ResponseBuilder<Usuario>().success(true).data(usuario)
                        .message(String.format(ResponseMessages.FIND_MESSAGE, usuario.getId())).status(HttpStatus.OK).build();
                this.getLogger().debug("sucesso ao buscar usuário pelo email '" + login + "'");
            } else {
                response = new ResponseBuilder<Usuario>().success(true)
                        .message(String.format("Usuário de login %s não foi encontrado", login)).status(HttpStatus.OK).build();
                this.getLogger().debug("não foi encontrado usuário com login '" + login + "'");
            }
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = new ResponseBuilder<Usuario>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("erro ao buscar usuário pelo login '" + login + "'", e);
        }
        return response;
    }

    /**
     * Busca por usuário pelo email fornecido
     * 
     * @param email
     *            email a ser consultado
     * @return {@link Usuario}
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_USUARIO_FIND_EMAIL + "/{email}", method = {GET, POST}, produces = APPLICATION_JSON)
    public Response<Usuario> findUsuarioByEmail(@PathVariable("email") final String email) {
        Response<Usuario> response;
        this.getLogger().debug("buscando usuário pelo email '" + email + "'");
        try {
            final Usuario usuario = this.getRepository().findByEmailIgnoreCase(email);
            if (usuario != null) {
                response = new ResponseBuilder<Usuario>().success(true).data(usuario)
                        .message(String.format(ResponseMessages.FIND_MESSAGE, usuario.getId())).status(HttpStatus.OK).build();
                this.getLogger().debug("sucesso ao buscar usuário pelo email '" + email + "'");
            } else {
                response = new ResponseBuilder<Usuario>().success(true)
                        .message(String.format("Usuário com email %s não foi encontrado", email)).status(HttpStatus.OK).build();
                this.getLogger().debug("não foi encontrado usuário com email '" + email + "'");
            }
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = new ResponseBuilder<Usuario>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("erro ao buscar usuário pelo email '" + email + "'", e);
        }
        return response;
    }

    /**
     * Busca por usuário pelo nome completo fornecido
     * 
     * @param nomeCompleto
     *            nome completo a ser consultado
     * @return {@link Usuario}
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_USUARIO_FIND_NOME + "/{nomeCompleto}",
        method = {GET, POST},
        produces = APPLICATION_JSON)
    public Response<Usuario> findUsuarioByNomeCompleto(@PathVariable("nomeCompleto") final String nomeCompleto) {
        Response<Usuario> response;
        this.getLogger().debug("buscando usuário pelo nome '" + nomeCompleto + "'");
        try {
            final Usuario usuario = this.getRepository().findByNomeCompletoIgnoreCase(nomeCompleto);
            if (usuario != null) {
                response = new ResponseBuilder<Usuario>().success(true).data(usuario)
                        .message(String.format(ResponseMessages.FIND_MESSAGE, usuario.getId())).status(HttpStatus.OK).build();
                this.getLogger().debug("sucesso ao buscar usuário pelo nome '" + nomeCompleto + "'");
            } else {
                response = new ResponseBuilder<Usuario>().success(true)
                        .message(String.format("Usuário com nome %s não foi encontrado", nomeCompleto)).status(HttpStatus.OK)
                        .build();
                this.getLogger().debug("não foi encontrado usuário com nome '" + nomeCompleto + "'");
            }
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = new ResponseBuilder<Usuario>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("erro ao buscar usuário pelo nome '" + nomeCompleto + "'", e);
        }
        return response;
    }

    /**
     * Busca por usuário pelo login e senha fornecidos
     * 
     * @param login
     *            nome completo a ser consultado
     * @param senha
     *            senha do usuário
     * @return {@link Usuario}
     */
    @ResponseBody
    @RequestMapping(value = "/{login}/{senha}", method = POST, produces = APPLICATION_JSON)
    public Response<Usuario> findUsuarioByUsuarioESenha(@PathVariable("login") final String login,
            @PathVariable("senha") final String senha) {
        Response<Usuario> response;
        this.getLogger().debug("buscando usuário pelo login '" + login + "' e senha XXX");
        try {
            final Usuario usuario = this.getRepository().findByUsuarioAndSenha(login, senha);
            if (usuario != null) {
                response = new ResponseBuilder<Usuario>().success(true).data(usuario)
                        .message(String.format(ResponseMessages.FIND_MESSAGE, usuario.getId())).status(HttpStatus.OK).build();
                this.getLogger().debug("sucesso ao buscar usuário pelo nome '" + login + "' e senha XXX");
            } else {
                response = new ResponseBuilder<Usuario>().success(true)
                        .message(String.format("Busca por senha e usuário com login %s sem resultado", login))
                        .status(HttpStatus.OK).build();
                this.getLogger().debug("não foi encontrado usuário com nome '" + login + "' e senha XXX");
            }
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = new ResponseBuilder<Usuario>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("erro ao buscar usuário pelo nome '" + login + "' e senha", e);
        }
        return response;
    }

}
