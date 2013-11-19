package br.ufg.inf.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
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

    @JsonProperty
    @JoinColumn(name = "analise_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Analise analise;

    @Column(name = "avaliacao_inicial", length = 2)
    private String avaliacaoInicial;

    @Column(name = "avaliacao_final", length = 2)
    private String avaliacaoFinal;

    public Analise getAnalise() {
        return this.analise;
    }

    public void setAnalise(final Analise analise) {
        this.analise = analise;
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
