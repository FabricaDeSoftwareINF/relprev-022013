package br.ufg.inf.model.support;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entidade abstrata para objetos persistíveis.<br />
 * Todas as outras entidades persistíveis do modelo de dados devem extender esta entidade ou uma sub-classe dela
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@MappedSuperclass
public abstract class AbstractEntity<E extends Serializable> implements Persistable<Long> {

    private static final long serialVersionUID = -2187928984731943693L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Versão utilizada pelo provider JPA para solução em concorrência
     */
    @Version
    @JsonIgnore
    private Long versao;

    @Column
    @JsonIgnore
    private Boolean hidden;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_insercao_alteracao")
    private Date dataInsercaoAlteracao;

    @JsonIgnore
    @OneToOne(optional = true)
    // não retirar a opcionalidade, pois não é obrigatório. A primeira versão nunca tem versão anterior
    @JoinColumn(name = "versao_anterior")
    private E versaoAnterior;

    @Override
    public Long getId() { // NOSONAR
        return this.id;
    }

    public void setId(final Long id) { // NOSONAR
        this.id = id;
    }

    public Long getVersao() { // NOSONAR
        return this.versao;
    }

    public void setVersao(final Long versao) { // NOSONAR
        this.versao = versao;
    }

    public Boolean getHidden() { // NOSONAR
        return this.hidden;
    }

    public void setHidden(final Boolean hidden) { // NOSONAR
        this.hidden = hidden;
    }

    public Date getDataInsercaoAlteracao() { // NOSONAR
        return this.dataInsercaoAlteracao;
    }

    public void setDataInsercaoAlteracao(final Date dataInsercaoAlteracao) { // NOSONAR
        this.dataInsercaoAlteracao = dataInsercaoAlteracao;
    }

    public E getVersaoAnterior() { // NOSONAR
        return this.versaoAnterior;
    }

    public void setVersaoAnterior(final E versaoAnterior) { // NOSONAR
        this.versaoAnterior = versaoAnterior;
    }

    @Override
    @JsonIgnore
    public boolean isNew() { // NOSONAR
        return this.getId() == null;
    }

    @Override
    public String toString() {
        return String.format("%s id: %s", this.getClass().getSimpleName(), this.getId());
    }

}
