package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.RelPrevServicesConfig;
import br.ufg.inf.es.relprev.client.http.response.EloSipaerResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 * Date: 11/9/13
 * Time: 12:25 AM
 */
public class EloSipaer extends ObjetoDeDominio {

    @JsonProperty
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

    private final RelPrevServicesConfig config = RelPrevServicesConfig.getInstance();

    @Override
    protected String getListURL() {
        return this.config.listEloSIPAERURL();
    }

    @Override
    protected String getFindByIDURL() {
        return this.config.findEloSIPAERURL();
    }

    @Override
    protected String getCreateURL() {
        return this.config.createEloSIPAERURL();
    }

    @Override
    protected String getUpdateURL() {
        return this.config.updateEloSIPAERURL();
    }

    @Override
    protected String getDeleteURL() {
        return this.config.deleteEloSIPAERURL();
    }

    @Override
    protected Class<?> getResponseClass() {
        return EloSipaerResponse.class;
    }

}
