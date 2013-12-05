package br.ufg.inf.model.test;

import org.springframework.test.util.ReflectionTestUtils;

import br.ufg.inf.model.Relator;

/**
 * Classe para facilitar a criação de instâncias de Relator usadas como mock nos testes
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Relator
 */
public class RelatorBuilder {

    private final Relator relator;

    public RelatorBuilder() {
        this.relator = new Relator();
    }

    public RelatorBuilder id(final Long id) {
        ReflectionTestUtils.setField(this.relator, "id", id);
        return this;
    }

    public RelatorBuilder nome(final String nome) {
        ReflectionTestUtils.setField(this.relator, "nome", nome);
        return this;
    }

    public RelatorBuilder telefone(final String telefone) {
        ReflectionTestUtils.setField(this.relator, "telefoneCelular", telefone);
        return this;
    }

    public RelatorBuilder email(final String email) {
        ReflectionTestUtils.setField(this.relator, "email", email);
        return this;
    }

    public Relator build() {
        return this.relator;
    }

}
