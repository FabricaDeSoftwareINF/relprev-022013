package br.ufg.inf.es.relprev.client.dominio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 */
@JsonInclude(Include.ALWAYS)
public class Situacao {

    @JsonProperty
    private Boolean temEncaminhamento = false;

    @JsonProperty
    private Boolean temDivulgacao = false;

    @JsonProperty
    private Boolean temAcaoRecomendada = false;

    @JsonProperty(value = "concluido")
    private Boolean foiConcluido = false;

    public Boolean getTemEncaminhamento() {
        return this.temEncaminhamento;
    }

    public void setTemEncaminhamento(final Boolean temEncaminhamento) {
        this.temEncaminhamento = temEncaminhamento;
    }

    public Boolean getTemDivulgacao() {
        return this.temDivulgacao;
    }

    public void setTemDivulgacao(final Boolean temDivulgacao) {
        this.temDivulgacao = temDivulgacao;
    }

    public Boolean getTemAcaoRecomendada() {
        return this.temAcaoRecomendada;
    }

    public void setTemAcaoRecomendada(final Boolean temAcaoRecomendada) {
        this.temAcaoRecomendada = temAcaoRecomendada;
    }

    public Boolean getFoiConcluido() {
        return this.foiConcluido;
    }

    public void setFoiConcluido(final Boolean foiConcluido) {
        this.foiConcluido = foiConcluido;
    }

}
