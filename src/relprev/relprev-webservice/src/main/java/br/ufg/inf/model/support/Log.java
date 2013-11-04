package br.ufg.inf.model.support;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidade para persistência de log de alteração de Dados
 * 
 * @created 03/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Table(name = "log_alteracao_dados")
public class Log extends AbstractEntity {

	private static final long serialVersionUID = 546132176769100844L;

	@Transient
	private TipoAlteracao tipoAlteracao;

	@Column(name = "tabela_alterada", length = 30)
	private String tabelaAlterada;

	@Column(name = "descricao_alteracao", length = 5000)
	private String descricaoAlteracao;

	public TipoAlteracao getTipoAlteracao() {
		return this.tipoAlteracao;
	}

	public void setTipoAlteracao(final TipoAlteracao tipoAlteracao) {
		this.tipoAlteracao = tipoAlteracao;
	}

	@Column(name = "tipo_alteracao", length = 10)
	public Integer getTipoAlteracaoInteiro() {
		if (this.getTipoAlteracao() != null) {
			return this.getTipoAlteracao().getTipo();
		}
		return null;
	}

	public void setTipoAlteracaoInteiro(final Integer tipoAlteracaoInteiro) {
		if (tipoAlteracaoInteiro != null && tipoAlteracaoInteiro > 0 && tipoAlteracaoInteiro < 4) {
			this.setTipoAlteracao(TipoAlteracao.fromTipo(tipoAlteracaoInteiro));
		} else {
			this.setTipoAlteracao(null);
		}
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
