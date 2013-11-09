package br.ufg.inf.model.support;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.domain.Persistable;

/**
 * Entidade abstrata para objetos persistíveis.<br />
 * Todas as outras entidades persistíveis do modelo de dados devem extender esta entidade ou uma
 * sub-classe dela
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@MappedSuperclass
public abstract class AbstractEntity implements Hiddenable, Persistable<Long> {

    private static final long serialVersionUID = -2187928984731943693L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long versao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_insercao_alteracao", nullable = false)
    private Date dataInsercaoAlteracao;

    @Column(name = "hidden")
    private Boolean isHidden;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getVersao() {
        return this.versao;
    }

    public void setVersao(final Long versao) {
        this.versao = versao;
    }

    public Date getDataInsercaoAlteracao() {
        return this.dataInsercaoAlteracao;
    }

    public void setDataInsercaoAlteracao(final Date dataInsercaoAlteracao) {
        this.dataInsercaoAlteracao = dataInsercaoAlteracao;
    }

    @Override
    public Boolean getIsHidden() {
        return this.isHidden;
    }

    @Override
    public void setIsHidden(final Boolean isHidden) {
        this.isHidden = isHidden;
    }

    @Override
    public boolean isNew() {
        return this.getId() == null;
    }

    @Override
    public String toString() {
        return String.format("%s id: %s", this.getClass().getSimpleName(), this.getId());
    }

    @PrePersist
    public void populateDataInsercaoAlteracao() {
        if (this.getDataInsercaoAlteracao() == null) {
            this.setDataInsercaoAlteracao(Calendar.getInstance().getTime());
        }
        if (this.getIsHidden() == null) {
            this.setIsHidden(false);
        }
        if (this.getVersao() != null) {
            /*
             * - para que nunca atualize dados, apenas inclua;
             * - para que continue o uso de versionamento pelo hibernate;
             * - para a versão do objeto ser uma a mais, para facilitar queries
             */
            this.setVersao(1 + this.getVersao());
        }
    }

}
