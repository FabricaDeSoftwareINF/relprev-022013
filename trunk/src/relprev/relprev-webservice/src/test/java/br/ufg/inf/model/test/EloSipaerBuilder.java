package br.ufg.inf.model.test;

import org.springframework.test.util.ReflectionTestUtils;

import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.model.security.Usuario;

/**
 * Classe para facilitar a criação de instâncias de Elos SIPAER usadas como mock nos testes
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see EloSipaer
 */
public final class EloSipaerBuilder {

    private final EloSipaer eloSipaer;

    public EloSipaerBuilder() {
        this.eloSipaer = new EloSipaer();
    }

    public EloSipaerBuilder id(final Long id) {
        ReflectionTestUtils.setField(this.eloSipaer, "id", id);
        return this;
    }

    public EloSipaerBuilder organizacao(final String organizacao) {
        ReflectionTestUtils.setField(this.eloSipaer, "organizacao", organizacao);
        return this;
    }

    public EloSipaerBuilder sigla(final String sigla) {
        ReflectionTestUtils.setField(this.eloSipaer, "siglaOrganizacao", sigla);
        return this;
    }

    public EloSipaerBuilder usuario(final Usuario usuario) {
        ReflectionTestUtils.setField(this.eloSipaer, "usuario", usuario);
        return this;
    }

    public EloSipaer build() {
        return this.eloSipaer;
    }

}
