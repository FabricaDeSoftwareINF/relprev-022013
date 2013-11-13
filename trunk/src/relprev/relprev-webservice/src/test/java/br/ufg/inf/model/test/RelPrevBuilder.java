package br.ufg.inf.model.test;

import java.util.Date;
import java.util.Set;

import org.springframework.test.util.ReflectionTestUtils;

import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.model.RelPrev;
import br.ufg.inf.model.Relator;
import br.ufg.inf.model.support.Anexo;

/**
 * Classe para facilitar a criação de instâncias de Relatórios de Prevenção
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see RelPrev
 */
public class RelPrevBuilder {

    private final RelPrev relPrev;

    public RelPrevBuilder() {
        this.relPrev = new RelPrev();
    }

    public RelPrevBuilder id(final Long id) {
        ReflectionTestUtils.setField(this.relPrev, "id", id);
        return this;
    }

    public RelPrevBuilder envolvidos(final String envolvidos) {
        ReflectionTestUtils.setField(this.relPrev, "envolvidos", envolvidos);
        return this;
    }

    public RelPrevBuilder local(final String local) {
        ReflectionTestUtils.setField(this.relPrev, "local", local);
        return this;
    }

    public RelPrevBuilder descricao(final String descricao) {
        ReflectionTestUtils.setField(this.relPrev, "descricaoSituacaoPerigosa", descricao);
        return this;
    }

    public RelPrevBuilder data(final Date data) {
        ReflectionTestUtils.setField(this.relPrev, "dataSituacaoPerigosa", data);
        return this;
    }

    public RelPrevBuilder eloSipaer(final EloSipaer eloSipaer) {
        ReflectionTestUtils.setField(this.relPrev, "eloSipaer", eloSipaer);
        return this;
    }

    public RelPrevBuilder relator(final Relator relator) {
        ReflectionTestUtils.setField(this.relPrev, "relator", relator);
        return this;
    }

    public RelPrevBuilder anexos(final Set<Anexo> anexos) {
        ReflectionTestUtils.setField(this.relPrev, "anexos", anexos);
        return this;
    }

    public RelPrev build() {
        return this.relPrev;
    }

}
