package br.ufg.inf.model.support;

/**
 * Enumerado dos tipos de alterações em uma entidade do modelo persistível
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public enum TipoAlteracao {

	/**
	 * Representa um evento de criação de dados na base de dados
	 */
	CREATE(1, "Criação"),

	/**
	 * Representa um evento de atualização de dados na base de dados
	 */
	UPDATE(2, "Atualização"),

	/**
	 * Representa um evento de remoção de dados na base de dados
	 */
	DELETE(3, "Remoção");

	private Integer tipo;
	private String descricao;

	private TipoAlteracao(final Integer tipo, final String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	/**
	 * Recupera a representação numérica do tipo de alteração
	 * 
	 * @return {@link Integer} tipo
	 */
	public Integer getTipo() {
		return this.tipo;
	}

	/**
	 * Recupera a descrição do tipo de alteração
	 * 
	 * @return {@link String} descrição
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Entrega valor do tipo enumerado {@link TipoAlteracao} de acordo com a representação numérica dele
	 * 
	 * @param tipo
	 *            tipo da alteração, senco {@code 1} para Criação ({@code CREATE}),
	 * {@code 2} para Atualização ({@code UPDATE}) e {@code 3} para Remoção ({@code DELETE})
	 * @return {@link TipoAlteracao}
	 */
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
