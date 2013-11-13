package br.ufg.inf.model.test;

import org.springframework.test.util.ReflectionTestUtils;

import br.ufg.inf.model.Taxonomia;

/**
 * Classe para facilitar a criação de instâncias de Taxonomia usadas como mock nos testes
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Taxonomia
 */
public class TaxonomiaBuilder {

    private final Taxonomia taxonomia;

    public TaxonomiaBuilder() {
        this.taxonomia = new Taxonomia();
    }

    public TaxonomiaBuilder id(final Long id) {
        ReflectionTestUtils.setField(this.taxonomia, "id", id);
        return this;
    }

    public TaxonomiaBuilder nome(final String nome) {
        ReflectionTestUtils.setField(this.taxonomia, "nome", nome);
        return this;
    }

    public TaxonomiaBuilder status(final Boolean status) {
        ReflectionTestUtils.setField(this.taxonomia, "status", status);
        return this;
    }

    public TaxonomiaBuilder padrao(final Boolean padrao) {
        ReflectionTestUtils.setField(this.taxonomia, "padraoMinimo", padrao);
        return this;
    }

    public Taxonomia build() {
        return this.taxonomia;
    }

}
