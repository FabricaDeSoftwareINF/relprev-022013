package br.ufg.inf.es.relprev.client.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 */
public class Anexo {

    private static final long serialVersionUID = 4571775183834766912L;
    @JsonProperty
    private String mimeType;
    @JsonProperty
    private String pathAnexo;

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(final String mimeType) {
        this.mimeType = mimeType;
    }

    public String getPathAnexo() {
        return this.pathAnexo;
    }

    public void setPathAnexo(final String pathAnexo) {
        this.pathAnexo = pathAnexo;
    }
}
