package br.ufg.inf.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufg.inf.model.security.Usuario;
import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.ModelConstantNumbers;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Entidade para persistência e representação JSON de um Elo SIPAER
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@Table(name = "elos_sipaer")
@JsonInclude(Include.NON_EMPTY)
@JsonRootName(value = "eloSipaer")
@Updatable(newinsert = true, updatable = false)
public class EloSipaer extends AbstractEntity<EloSipaer> {

    private static final long serialVersionUID = 3850763253702817582L;

    @JsonIgnore
    @JoinColumn(name = "usuario_id")
    @ManyToOne(cascade = CascadeType.ALL)
    // , optional = false) TODO concluir mapeamento assim que existir validação dos usuários
    private Usuario usuario;

    @JsonProperty
    @Column(nullable = false, length = ModelConstantNumbers.COLUMN_SIZE_20)
    @NotNull(message = "{validation.EloSipaer.organizacao.NotNull.message}")
    @Size(min = ModelConstantNumbers.FIELD_SIZE_1,
        max = ModelConstantNumbers.FIELD_SIZE_20,
        message = "{validation.EloSipaer.organizacao.Size.message}")
    private String organizacao;

    @JsonProperty(value = "sigla")
    @Column(name = "sigla_organizacao", nullable = false, length = ModelConstantNumbers.COLUMN_SIZE_20)
    @NotNull(message = "{validation.EloSipaer.siglaOrganizacao.NotNull.message}")
    @Size(min = ModelConstantNumbers.FIELD_SIZE_1,
        max = ModelConstantNumbers.FIELD_SIZE_20,
        message = "{validation.EloSipaer.siglaOrganizacao.Size.message}")
    private String siglaOrganizacao;

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final Usuario usuario) {
        this.usuario = usuario;
    }

    public String getOrganizacao() {
        return this.organizacao;
    }

    public void setOrganizacao(final String organizacao) {
        this.organizacao = organizacao;
    }

    public String getSiglaOrganizacao() {
        return this.siglaOrganizacao;
    }

    public void setSiglaOrganizacao(final String siglaOrganizacao) {
        this.siglaOrganizacao = siglaOrganizacao;
    }

}
