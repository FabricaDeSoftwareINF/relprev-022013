package br.ufg.inf.model.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Telefone;
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
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "usuario", "id"}))
// TODO verificar constraint
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Usuario extends AbstractEntity<Usuario> {

    private static final long serialVersionUID = -2583035988668453632L;

    @JsonProperty
    @Column(length = 120)
    @Email(message = "{validation.Usuario.email.Email.message}",
        regexp = "[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.[a-zA-Z]{2,5}")
    private String email;

    @JsonProperty
    @Column(length = 30)
    @Size(min = 1, max = 30, message = "{validation.Usuario.especialidade.Size.message}")
    private String especialidade;

    @JsonProperty
    @Column(nullable = false, length = 30)
    @NotNull(message = "{validation.Usuario.funcao.NotNull.message}")
    @Size(min = 1, max = 60, message = "{validation.Usuario.funcao.Size.message}")
    private String funcao;

    @JsonProperty
    @Column(nullable = false, length = 60, name = "nome_completo")
    @NotNull(message = "{validation.Usuario.nomeCompleto.NotNull.message}")
    @Size(min = 1, max = 60, message = "{validation.Usuario.nomeCompleto.Size.message}")
    private String nomeCompleto;

    @JsonProperty
    @Column(nullable = false, length = 20)
    @NotNull(message = "{validation.Usuario.posto.NotNull.message}")
    @Size(min = 1, max = 20, message = "{validation.Usuario.posto.Size.message}")
    private String posto;

    @JsonProperty
    @Column(nullable = false, length = 15, name = "sigla_secao")
    @NotNull(message = "{validation.Usuario.siglaSecao.NotNull.message}")
    @Size(min = 1, max = 15, message = "{validation.Usuario.siglaSecao.Size.message}")
    private String siglaSecao;

    @JsonProperty
    @Column(length = 30, name = "telefone_celular")
    @Telefone(message = "{validation.Usuario.telefoneCelular.Telefone.message}")
    private String telefoneCelular;

    @JsonProperty
    @Column(length = 30, name = "telefone_fixo")
    @Telefone(message = "{validation.Usuario.telefoneFixo.Telefone.message}")
    private String telefoneFixo;

    /* informações para login do usuário */
    @JsonProperty
    @Column(length = 45, nullable = false, updatable = false)
    @NotNull(message = "{validation.Usuario.usuario.NotNull.message}")
    @Size(min = 1, max = 45, message = "{validation.Usuario.usuario.Size.message}")
    private String usuario;

    @JsonProperty
    @Column(length = 128, nullable = false)
    @NotNull(message = "{validation.Usuario.senha.NotNull.message}")
    @Size(min = 128, max = 128, message = "{validation.Usuario.senha.Size.message}")
    private String senha;

    @JsonProperty
    @Column(nullable = false)
    @NotNull(message = "{validation.Usuario.ativo.NotNull.message}")
    private Boolean ativo;

    public String getEmail() { // NOSONAR
        return this.email;
    }

    public void setEmail(final String email) { // NOSONAR
        this.email = email;
    }

    public String getEspecialidade() { // NOSONAR
        return this.especialidade;
    }

    public void setEspecialidade(final String especialidade) { // NOSONAR
        this.especialidade = especialidade;
    }

    public String getFuncao() { // NOSONAR
        return this.funcao;
    }

    public void setFuncao(final String funcao) { // NOSONAR
        this.funcao = funcao;
    }

    public String getNomeCompleto() { // NOSONAR
        return this.nomeCompleto;
    }

    public void setNomeCompleto(final String nomeCompleto) { // NOSONAR
        this.nomeCompleto = nomeCompleto;
    }

    public String getPosto() { // NOSONAR
        return this.posto;
    }

    public void setPosto(final String posto) { // NOSONAR
        this.posto = posto;
    }

    public String getSiglaSecao() { // NOSONAR
        return this.siglaSecao;
    }

    public void setSiglaSecao(final String siglaSecao) { // NOSONAR
        this.siglaSecao = siglaSecao;
    }

    public String getTelefoneCelular() { // NOSONAR
        return this.telefoneCelular;
    }

    public void setTelefoneCelular(final String telefoneCelular) { // NOSONAR
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() { // NOSONAR
        return this.telefoneFixo;
    }

    public void setTelefoneFixo(final String telefoneFixo) { // NOSONAR
        this.telefoneFixo = telefoneFixo;
    }

    public String getUsuario() { // NOSONAR
        return this.usuario;
    }

    public void setUsuario(final String usuario) { // NOSONAR
        this.usuario = usuario;
    }

    public String getSenha() { // NOSONAR
        return this.senha;
    }

    public void setSenha(final String senha) { // NOSONAR
        this.senha = senha;
    }

    public Boolean getAtivo() { // NOSONAR
        return this.ativo;
    }

    public void setAtivo(final Boolean ativo) { // NOSONAR
        this.ativo = ativo;
    }

}
