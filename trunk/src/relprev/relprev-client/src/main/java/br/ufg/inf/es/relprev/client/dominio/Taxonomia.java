package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.RelPrevServicesConfig;
import br.ufg.inf.es.relprev.client.http.response.TaxonomiaResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 */
public class Taxonomia extends ObjetoDeDominio {

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

    private final RelPrevServicesConfig config = RelPrevServicesConfig.getInstance();

    @Override
    protected String getListURL() {
        return this.config.listTaxonomiaURL();
    }

    @Override
    protected String getFindByIDURL() {
        return this.config.findTaxonomiaURL();
    }

    @Override
    protected String getCreateURL() {
        return this.config.createTaxonomiaURL();
    }

    @Override
    protected String getUpdateURL() {
        return this.config.updateTaxonomiaURL();
    }

    @Override
    protected String getDeleteURL() {
        return this.config.deleteTaxonomiaURL();
    }

    @Override
    protected Class<?> getResponseClass() {
        return TaxonomiaResponse.class;
    }

}
