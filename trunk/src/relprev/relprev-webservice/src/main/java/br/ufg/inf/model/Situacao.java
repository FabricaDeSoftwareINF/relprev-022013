package br.ufg.inf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e retorno de JSON das situação de um Relatório de Prevenção
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@JsonInclude(Include.NON_EMPTY)
@Table(name = "situacoes")
public class Situacao extends AbstractEntity<Situacao> {

    private static final long serialVersionUID = 990407097291869785L;

    @JsonProperty
    @Column(nullable = false, name = "tem_encaminhamento")
    @NotNull(message = "validation.Situacao.temEncaminhamento.NotNull.message")
    private Boolean temEncaminhamento;

    @JsonProperty
    @Column(nullable = false, name = "tem_divulgacao")
    @NotNull(message = "validation.Situacao.temDivulgacao.NotNull.message")
    private Boolean temDivulgacao;

    @JsonProperty
    @Column(nullable = false, name = "tem_acao_recomendada")
    @NotNull(message = "validation.Situacao.temAcaoRecomendada.NotNull.message")
    private Boolean temAcaoRecomendada;

    @JsonProperty(value = "concluido")
    @Column(nullable = false, name = "foi_concluido")
    @NotNull(message = "validation.Situacao.foiConcluido.NotNull.message")
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
