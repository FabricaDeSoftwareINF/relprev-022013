package br.ufg.inf.model.test;

import java.util.Date;
import java.util.Set;

import org.springframework.test.util.ReflectionTestUtils;

import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.model.RelatorioPrevencao;
import br.ufg.inf.model.Relator;
import br.ufg.inf.model.support.Anexo;

/**
 * Classe para facilitar a criação de instâncias de Relatórios de Prevenção
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see RelatorioPrevencao
 */
public class RelatorioPrevencaoBuilder {

    private final RelatorioPrevencao relPrev;

    public RelatorioPrevencaoBuilder() {
        this.relPrev = new RelatorioPrevencao();
    }

    public RelatorioPrevencaoBuilder id(final Long id) {
        ReflectionTestUtils.setField(this.relPrev, "id", id);
        return this;
    }

    public RelatorioPrevencaoBuilder envolvidos(final String envolvidos) {
        ReflectionTestUtils.setField(this.relPrev, "envolvidos", envolvidos);
        return this;
    }

    public RelatorioPrevencaoBuilder local(final String local) {
        ReflectionTestUtils.setField(this.relPrev, "local", local);
        return this;
    }

    public RelatorioPrevencaoBuilder descricao(final String descricao) {
        ReflectionTestUtils.setField(this.relPrev, "descricaoSituacaoPerigosa", descricao);
        return this;
    }

    public RelatorioPrevencaoBuilder data(final Date data) {
        ReflectionTestUtils.setField(this.relPrev, "dataSituacaoPerigosa", data);
        return this;
    }

    public RelatorioPrevencaoBuilder eloSipaer(final EloSipaer eloSipaer) {
        ReflectionTestUtils.setField(this.relPrev, "eloSipaer", eloSipaer);
        return this;
    }

    public RelatorioPrevencaoBuilder relator(final Relator relator) {
        ReflectionTestUtils.setField(this.relPrev, "relator", relator);
        return this;
    }

    public RelatorioPrevencaoBuilder anexos(final Set<Anexo> anexos) {
        ReflectionTestUtils.setField(this.relPrev, "anexos", anexos);
        return this;
    }

    public RelatorioPrevencao build() {
        return this.relPrev;
    }

}
