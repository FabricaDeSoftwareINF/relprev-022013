package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.http.response.TaxonomiaResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import static br.ufg.inf.es.relprev.client.RelprevConfig.CONTROLLER_TAXONOMIA;

/**
 * User: halisson
 */
public class Taxonomia extends ObjetoDeDominio {

    private static final long serialVersionUID = -8111373397877993819L;
    @JsonProperty
    private String nome;
    @JsonProperty
    private Boolean status;
    @JsonProperty
    private Boolean padraoMinimo;

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(final Boolean status) {
        this.status = status;
    }

    public Boolean getPadraoMinimo() {
        return this.padraoMinimo;
    }

    public void setPadraoMinimo(final Boolean padraoMinimo) {
        this.padraoMinimo = padraoMinimo;
    }

    protected String getController() {
        return CONTROLLER_TAXONOMIA;
    }

    protected Class getResponseClass() {
        return TaxonomiaResponse.class;
    }
}
