package br.ufg.inf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.ModelConstants;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e representação JSON sobre da Classificação de Risco
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@JsonInclude(Include.NON_EMPTY)
@Table(name = "classificacoes_risco")
@Updatable(newinsert = true, updatable = false)
public class ClassificacaoRisco extends AbstractEntity<ClassificacaoRisco> {

    private static final long serialVersionUID = 80193580056312692L;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "relprev_id")
    private RelatorioPrevencao relPrev;

    @JsonProperty
    @Column(name = "avaliacao_inicial", length = ModelConstants.COLUMN_SIZE_2)
    private String avaliacaoInicial;

    @JsonProperty
    @Column(name = "avaliacao_final", length = ModelConstants.COLUMN_SIZE_2)
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
