package br.ufg.inf.es.relprev.client.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 * Date: 11/9/13
 * Time: 12:25 AM
 */
public class EloSipaer extends ObjetoDeDominio {
    private static final long serialVersionUID = 3850763253702817582L;
    private String organizacao;
    @JsonProperty(value = "sigla")
    private String sigla;

    public String getOrganizacao() {
        return this.organizacao;
    }

    public void setOrganizacao(final String organizacao) {
        this.organizacao = organizacao;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(final String siglaOrganizacao) {
        this.sigla = siglaOrganizacao;
    }
}
