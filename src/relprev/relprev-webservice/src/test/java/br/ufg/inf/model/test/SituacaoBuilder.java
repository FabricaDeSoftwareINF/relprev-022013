package br.ufg.inf.model.test;

import org.springframework.test.util.ReflectionTestUtils;

import br.ufg.inf.model.Situacao;

/**
 * Classe para facilitar a criação de instâncias de Situacao usadas como mock nos testes
 * 
 * @created 05/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Situacao
 */
public class SituacaoBuilder {

    private final Situacao situacao;

    public SituacaoBuilder() {
        this.situacao = new Situacao();
    }

    public SituacaoBuilder encaminhamento(final Boolean encaminhamento) {
        ReflectionTestUtils.setField(this.situacao, "temEncaminhamento", encaminhamento);
        return this;
    }

    public SituacaoBuilder divulgacao(final Boolean divulgacao) {
        ReflectionTestUtils.setField(this.situacao, "temDivulgacao", divulgacao);
        return this;
    }

    public SituacaoBuilder acaoRecomendada(final Boolean acaoRecomendada) {
        ReflectionTestUtils.setField(this.situacao, "temAcaoRecomendada", acaoRecomendada);
        return this;
    }

    public SituacaoBuilder concluido(final Boolean concluido) {
        ReflectionTestUtils.setField(this.situacao, "foiConcluido", concluido);
        return this;
    }

    public Situacao build() {
        return this.situacao;
    }

}
