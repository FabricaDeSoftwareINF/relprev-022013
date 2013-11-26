package br.ufg.inf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.ModelConstantNumbers;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Telefone;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e retorno de JSON de relatores de um relatório de prevenção
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@Table(name = "relatores")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class Relator extends AbstractEntity<Relator> {

    private static final long serialVersionUID = -671624807223719350L;

    @JsonProperty
    @Column(length = ModelConstantNumbers.COLUMN_SIZE_50)
    @Size(min = ModelConstantNumbers.FIELD_SIZE_1,
        max = ModelConstantNumbers.FIELD_SIZE_50,
        message = "{validation.Relator.nome.Size.message}")
    private String nome;

    @JsonProperty
    @Column(length = ModelConstantNumbers.COLUMN_SIZE_20)
    @Telefone(message = "{validation.Relator.telefoneCelular.Telefone.message}")
    private String telefoneCelular;

    @JsonProperty
    @Column(length = ModelConstantNumbers.COLUMN_SIZE_20)
    @Telefone(message = "{validation.Relator.telefoneResidencial.Telefone.message}")
    private String telefoneResidencial;

    @JsonProperty
    @Column(length = ModelConstantNumbers.COLUMN_SIZE_120)
    @Email(message = "{validation.Relator.email.Email.message}",
        regexp = "[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.[a-zA-Z]{2,5}")
    private String email;

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getTelefoneCelular() {
        return this.telefoneCelular;
    }

    public void setTelefoneCelular(final String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneResidencial() {
        return this.telefoneResidencial;
    }

    public void setTelefoneResidencial(final String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

}
