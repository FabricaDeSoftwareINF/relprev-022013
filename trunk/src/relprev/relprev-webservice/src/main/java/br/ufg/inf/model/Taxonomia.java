package br.ufg.inf.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * Entidade para persistência e retorno de JSON de taxonomias de um relatório de prevenção
 * 
 * @created 09/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@Table(name = "taxonomias")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Taxonomia extends AbstractEntity<Taxonomia> {

    private static final long serialVersionUID = -8111373397877993819L;

    @JsonProperty
    @Column(nullable = false, length = 20)
    @NotNull(message = "{validation.Taxonomia.nome.NotNull.message}")
    @Size(min = 1, max = 20, message = "{validation.Taxonomia.nome.Size.message}")
    private String nome;

    @JsonProperty
    @Column(nullable = false)
    @NotNull(message = "{validation.Taxonomia.status.NotNull.message}")
    private Boolean status;

    @JsonProperty
    @Column(name = "padrao_minimo", nullable = false)
    @NotNull(message = "{validation.Taxonomia.padraoMinimo.NotNull.message}")
    private Boolean padraoMinimo;

    public String getNome() { // NOSONAR
        return this.nome;
    }

    public void setNome(final String nome) { // NOSONAR
        this.nome = nome;
    }

    public Boolean getStatus() { // NOSONAR
        return this.status;
    }

    public void setStatus(final Boolean status) { // NOSONAR
        this.status = status;
    }

    public Boolean getPadraoMinimo() { // NOSONAR
        return this.padraoMinimo;
    }

    public void setPadraoMinimo(final Boolean padraoMinimo) { // NOSONAR
        this.padraoMinimo = padraoMinimo;
    }

    /*
     * FORMATAÇÕES
     * Existem duas formatações para os itens de uma taxonomia, em que o usuário deve escolher uma.
     * 1). A taxonomia tem somente um campo para uma Descrição(TEXTO(600))
     * 2). A taxonomia tem uma lista de categorias(TEXTO(15)), onde cada categoria pode conter uma lista com
     * sub-categorias(TEXTO(15)).
     */
    @JsonProperty
    @Column(length = 600)
    @Size(min = 1, max = 600, message = "{validation.Taxonomia.descricao.Size.message}")
    private String descricao;

    @JsonProperty(value = "categorias")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "taxonomia_categorias",
        joinColumns = {@JoinColumn(name = "taxonomia_id")},
        inverseJoinColumns = {@JoinColumn(name = "categoria_id")})
    private Set<Categoria> categorias;

    public String getDescricao() { // NOSONAR
        return this.descricao;
    }

    public void setDescricao(final String descricao) { // NOSONAR
        this.descricao = descricao;
    }

    public Set<Categoria> getCategorias() { // NOSONAR
        return this.categorias;
    }

    public void setCategorias(final Set<Categoria> categorias) { // NOSONAR
        this.categorias = categorias;
    }

}
