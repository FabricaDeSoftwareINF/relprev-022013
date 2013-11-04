package br.ufg.inf.model.support;

/**
 * Enumerado dos tipos de alterações em uma entidade do modelo persistível
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public enum TipoAlteracao {

	CREATE(1, "Criação"), UPDATE(2, "Atualização"), DELETE(2, "Remoção");

	private Integer tipo;
	private String descricao;

	private TipoAlteracao(final Integer tipo, final String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static TipoAlteracao fromTipo(final Integer tipo) {
		final TipoAlteracao[] tipos = TipoAlteracao.values();
		for (final TipoAlteracao tipoAlteracao : tipos) {
			if (tipoAlteracao.getTipo() == tipo) {
				return tipoAlteracao;
			}
		}
		return null;
	}

}
