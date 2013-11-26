package br.ufg.inf.model.support;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.ufg.inf.model.support.annotation.Updatable;

/**
 * Entidade para persistência de log de alteração de Dados
 * 
 * @created 03/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Updatable(updatable = false)
@Table(name = "log_alteracao_dados")
public class Log extends AbstractEntity<Log> {

    private static final long serialVersionUID = 546132176769100844L;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_alteracao", nullable = false)
    private TipoAlteracao tipoAlteracao;

    @Column(name = "tabela_alterada", length = ModelConstantNumbers.COLUMN_SIZE_30, nullable = false)
    private String tabelaAlterada;

    @Column(name = "descricao_alteracao", length = ModelConstantNumbers.COLUMN_SIZE_5000, nullable = false)
    private String descricaoAlteracao;

    public TipoAlteracao getTipoAlteracao() {
        return this.tipoAlteracao;
    }

    public void setTipoAlteracao(final TipoAlteracao tipoAlteracao) {
        this.tipoAlteracao = tipoAlteracao;
    }

    public String getTabelaAlterada() {
        return this.tabelaAlterada;
    }

    public void setTabelaAlterada(final String tabelaAlterada) {
        this.tabelaAlterada = tabelaAlterada;
    }

    public String getDescricaoAlteracao() {
        return this.descricaoAlteracao;
    }

    public void setDescricaoAlteracao(final String descricaoAlteracao) {
        this.descricaoAlteracao = descricaoAlteracao;
    }

}
