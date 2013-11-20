package br.ufg.inf.model.test;

import org.springframework.test.util.ReflectionTestUtils;

import br.ufg.inf.model.security.Usuario;

/**
 * Classe para facilitar a criação de instâncias de Usuário usadas como mock nos testes
 * 
 * @created 20/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Usuario
 */
public class UsuarioBuilder {

    private final Usuario usuario;

    public UsuarioBuilder() {
        this.usuario = new Usuario();
    }

    public UsuarioBuilder id(final Long id) {
        ReflectionTestUtils.setField(this.usuario, "id", id);
        return this;
    }

    public UsuarioBuilder email(final String email) {
        ReflectionTestUtils.setField(this.usuario, "email", email);
        return this;
    }

    public UsuarioBuilder especialidade(final String especialidade) {
        ReflectionTestUtils.setField(this.usuario, "especialidade", especialidade);
        return this;
    }

    public UsuarioBuilder funcao(final String funcao) {
        ReflectionTestUtils.setField(this.usuario, "funcao", funcao);
        return this;
    }

    public UsuarioBuilder nome(final String nomeCompleto) {
        ReflectionTestUtils.setField(this.usuario, "nomeCompleto", nomeCompleto);
        return this;
    }

    public UsuarioBuilder posto(final String posto) {
        ReflectionTestUtils.setField(this.usuario, "posto", posto);
        return this;
    }

    public UsuarioBuilder siglaSecao(final String siglaSecao) {
        ReflectionTestUtils.setField(this.usuario, "siglaSecao", siglaSecao);
        return this;
    }

    public UsuarioBuilder celular(final String telefoneCelular) {
        ReflectionTestUtils.setField(this.usuario, "telefoneCelular", telefoneCelular);
        return this;
    }

    public UsuarioBuilder fixo(final String telefoneFixo) {
        ReflectionTestUtils.setField(this.usuario, "telefoneFixo", telefoneFixo);
        return this;
    }

    public UsuarioBuilder usuario(final String usuario) {
        ReflectionTestUtils.setField(this.usuario, "usuario", usuario);
        return this;
    }

    public UsuarioBuilder senha(final String senha) {
        ReflectionTestUtils.setField(this.usuario, "senha", senha);
        return this;
    }

    public UsuarioBuilder ativo(final Boolean ativo) {
        ReflectionTestUtils.setField(this.usuario, "ativo", ativo);
        return this;
    }

    public Usuario build() {
        return this.usuario;
    }

}
