package br.ufg.inf.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e retorno de JSON de
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@Table(name = "categorias")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Categoria extends AbstractEntity<Categoria> {

    private static final long serialVersionUID = 2429958840047244813L;

    @JsonProperty
    @OneToOne(optional = true)
    @JoinColumn(name = "categoria_pai")
    private Categoria categoriaPai;

    @JsonProperty
    @JoinColumn(name = "taxonomia_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Taxonomia taxonomia;

    @JsonProperty
    @Column(nullable = false)
    @NotNull(message = "{validation.Categoria.nome.NotNull.message}")
    @Size(min = 1, message = "{validation.Categoria.nome.Size.message}")
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
