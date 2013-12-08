package br.ufg.inf.es.relprev.client.dominio;

import br.ufg.inf.es.relprev.client.RelPrevServicesConfig;
import br.ufg.inf.es.relprev.client.http.response.RelatorResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson Date: 11/2/13
 */
public class Relator extends ObjetoDeDominio {

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
        if (telefoneCelular != null) {
            this.telefoneCelular = telefoneCelular.replaceAll("\\D+", "");
        }
    }

    public String getTelefoneResidencial() {
        return this.telefoneResidencial;
    }

    public void setTelefoneResidencial(final String telefoneResidencial) {
        if (telefoneResidencial != null) {
            this.telefoneResidencial = telefoneResidencial.replaceAll("\\D+", "");
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    private final RelPrevServicesConfig config = RelPrevServicesConfig.getInstance();

    @Override
    protected String getListURL() {
        return this.config.listRelatorURL();
    }

    @Override
    protected String getFindByIDURL() {
        return this.config.findRelatorURL();
    }

    @Override
    protected String getCreateURL() {
        return this.config.createRelatorURL();
    }

    @Override
    protected String getUpdateURL() {
        return this.config.updateRelatorURL();
    }

    @Override
    protected String getDeleteURL() {
        return this.config.deleteRelatorURL();
    }

    @Override
    protected Class<?> getResponseClass() {
        return RelatorResponse.class;
    }

}
