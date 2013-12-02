package br.ufg.inf.es.relprev.client.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 */
@JsonInclude(Include.NON_EMPTY)
public class ClassificacaoRisco {

    private static final long serialVersionUID = 80193580056312692L;

    @JsonIgnore
    private RelatorioPrevencao relPrev;

    @JsonProperty
    private String avaliacaoInicial;

    @JsonProperty
    private String avaliacaoFinal;

    public RelatorioPrevencao getRelPrev() {
        return this.relPrev;
    }

    public void setRelPrev(final RelatorioPrevencao relPrev) {
        this.relPrev = relPrev;
    }

    public String getAvaliacaoInicial() {
        return this.avaliacaoInicial;
    }

    public void setAvaliacaoInicial(final String avaliacaoInicial) {
        this.avaliacaoInicial = avaliacaoInicial;
    }

    public String getAvaliacaoFinal() {
        return this.avaliacaoFinal;
    }

    public void setAvaliacaoFinal(final String avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }
}
