package br.ufg.inf.es.relprev.client.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson Date: 11/2/13
 */
public class Relator {

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

}
