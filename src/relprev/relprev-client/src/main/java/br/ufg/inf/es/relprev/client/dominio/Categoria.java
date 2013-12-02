package br.ufg.inf.es.relprev.client.dominio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 */
@JsonInclude(Include.NON_EMPTY)
public class Categoria {

    private static final long serialVersionUID = 2429958840047244813L;

    @JsonProperty
    private Categoria categoriaPai;

    @JsonProperty
    private Taxonomia taxonomia;

    @JsonProperty
    private String nome;

    public Categoria getCategoriaPai() {
        return this.categoriaPai;
    }

    public void setCategoriaPai(final Categoria categoriaPai) {
        this.categoriaPai = categoriaPai;
    }

    public Taxonomia getTaxonomia() {
        return this.taxonomia;
    }

    public void setTaxonomia(final Taxonomia taxonomia) {
        this.taxonomia = taxonomia;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

}
