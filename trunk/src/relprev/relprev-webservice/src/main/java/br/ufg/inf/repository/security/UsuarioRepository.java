package br.ufg.inf.repository.security;

import br.ufg.inf.model.security.Usuario;
import br.ufg.inf.repository.support.GenericRepository;

/**
 * Repositório de acesso a dados de {@link Usuario}
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericRepository
 */
public interface UsuarioRepository extends GenericRepository<Usuario, Long> {

    /**
     * Consulta na base de dados usuário pelo email fornecido
     * 
     * @param email
     *            email do usuário na base de dados
     * @return {@link Usuario}
     */
    Usuario findByEmailIgnoreCase(final String email);

    /**
     * Consulta na base de dados usuário pelo nome fornecido
     * 
     * @param nomeCompleto
     *            nome completo do usuário na base de dados
     * @return {@link Usuario}
     */
    Usuario findByNomeCompletoIgnoreCase(final String nomeCompleto);

    /**
     * Consulta na base de dados usuário pelo usuario(login) fornecido
     * 
     * @param usuario
     *            nome completo do usuário na base de dados
     * @return {@link Usuario}
     */
    Usuario findByUsuario(final String usuario);

    /**
     * Consulta na base de dados usuário pelo login e senha fornecidos
     * 
     * @param usuario
     *            login do usuário
     * @param senha
     *            senha do usuário
     * @return {@link Usuario}
     */
    Usuario findByUsuarioAndSenha(final String usuario, final String senha);

}
