package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.response.RelatorResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import static br.ufg.inf.es.relprev.client.RelprevConfig.*;

/**
 * User: halisson Date: 11/2/13
 */
public class Relator extends ObjetoDeDominio {

    private static final long serialVersionUID = -671624807223719350L;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String telefoneCelular;

    @JsonProperty
    private String telefoneResidencial;

    @JsonProperty
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

    @Override
    protected String getController() {
        return CONTROLLER_RELATOR;
    }

    @Override
    protected Class getResponseClass() {
        return RelatorResponse.class;
    }
}
