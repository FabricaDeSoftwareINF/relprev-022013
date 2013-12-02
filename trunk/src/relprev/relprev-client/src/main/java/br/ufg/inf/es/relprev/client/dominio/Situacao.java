package br.ufg.inf.es.relprev.client.dominio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson
 */
@JsonInclude(Include.NON_EMPTY)
public class Situacao {

    private static final long serialVersionUID = 990407097291869785L;

    @JsonProperty
    private Boolean temEncaminhamento;

    @JsonProperty
    private Boolean temDivulgacao;

    @JsonProperty
    private Boolean temAcaoRecomendada;

    @JsonProperty(value = "concluido")
    private Boolean foiConcluido;

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
