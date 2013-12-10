package br.ufg.inf.model.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.ModelConstants;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e retorno de JSON de usuário do sistema
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "usuario", "hidden"}),
        @UniqueConstraint(columnNames = {"email", "hidden"})})
public class Usuario extends AbstractEntity<Usuario> {

    private static final long serialVersionUID = -2583035988668453632L;

    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_120)
    @Email(message = "validation.Usuario.email.Email.message", regexp = "[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.[a-zA-Z]{2,5}")
    private String email;

    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_30)
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_30,
        message = "validation.Usuario.especialidade.Size.message")
    private String especialidade;

    @JsonProperty
    @NotNull(message = "validation.Usuario.funcao.NotNull.message")
    @Column(nullable = false, length = ModelConstants.COLUMN_SIZE_30)
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_60,
        message = "validation.Usuario.funcao.Size.message")
    private String funcao;

    @JsonProperty
    @NotNull(message = "validation.Usuario.nomeCompleto.NotNull.message")
    @Column(nullable = false, length = ModelConstants.COLUMN_SIZE_60, name = "nome_completo")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_60,
        message = "validation.Usuario.nomeCompleto.Size.message")
    private String nomeCompleto;

    @JsonProperty
    @NotNull(message = "validation.Usuario.posto.NotNull.message")
    @Column(nullable = false, length = ModelConstants.COLUMN_SIZE_20)
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_20,
        message = "validation.Usuario.posto.Size.message")
    private String posto;

    @JsonProperty
    @NotNull(message = "validation.Usuario.siglaSecao.NotNull.message")
    @Column(nullable = false, length = ModelConstants.COLUMN_SIZE_15, name = "sigla_secao")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_15,
        message = "validation.Usuario.siglaSecao.Size.message")
    private String siglaSecao;

    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_30, name = "telefone_celular")
    @Pattern(regexp = ModelConstants.TELEFONE_REGEX, message = "validation.Usuario.telefoneCelular.Telefone.message")
    private String telefoneCelular;

    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_30, name = "telefone_fixo")
    @Pattern(regexp = ModelConstants.TELEFONE_REGEX, message = "validation.Usuario.telefoneFixo.Telefone.message")
    private String telefoneFixo;

    /* informações para login do usuário */
    @JsonProperty
    @NotNull(message = "validation.Usuario.usuario.NotNull.message")
    @Column(length = ModelConstants.COLUMN_SIZE_45, nullable = false, updatable = false)
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_45,
        message = "validation.Usuario.usuario.Size.message")
    private String usuario;

    @JsonProperty
    @NotNull(message = "validation.Usuario.senha.NotNull.message")
    @Column(length = ModelConstants.COLUMN_SIZE_40, nullable = false)
    @Size(min = ModelConstants.FIELD_SIZE_40,
        max = ModelConstants.FIELD_SIZE_40,
        message = "validation.Usuario.senha.Size.message")
    private String senha;

    @JsonProperty
    @Column(nullable = false)
    @NotNull(message = "validation.Usuario.ativo.NotNull.message")
    private Boolean ativo;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(final String especialidade) {
        this.especialidade = especialidade;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(final String funcao) {
        this.funcao = funcao;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(final String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPosto() {
        return this.posto;
    }

    public void setPosto(final String posto) {
        this.posto = posto;
    }

    public String getSiglaSecao() {
        return this.siglaSecao;
    }

    public void setSiglaSecao(final String siglaSecao) {
        this.siglaSecao = siglaSecao;
    }

    public String getTelefoneCelular() {
        return this.telefoneCelular;
    }

    public void setTelefoneCelular(final String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return this.telefoneFixo;
    }

    public void setTelefoneFixo(final String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(final Boolean ativo) {
        this.ativo = ativo;
    }

}
