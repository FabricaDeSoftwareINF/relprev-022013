package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.response.RelatorResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import static br.ufg.inf.es.relprev.client.RelprevConfig.*;

/**
 * User: halisson Date: 11/2/13
 */
public class Relator extends ObjetoDeDominio {

    private String nome;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "telefone")
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
