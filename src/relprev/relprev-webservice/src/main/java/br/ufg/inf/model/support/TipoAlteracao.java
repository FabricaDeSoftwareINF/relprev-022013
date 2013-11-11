package br.ufg.inf.model.support;

/**
 * Enumerado dos tipos de alterações em uma entidade do modelo persistível
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public enum TipoAlteracao {

    /**
     * Representa um evento de criação de dados na base de dados
     */
    CREATE(0, "Criação", "Criação de objeto de id %s."),

    /**
     * Representa um evento de atualização de dados na base de dados
     */
    UPDATE(1, "Atualização", "Atualização de objeto de id %s para novo objeto de id %s."),

    /**
     * Representa um evento de remoção de dados na base de dados
     */
    DELETE(2, "Remoção", "Remoção de objeto de id %s.");

    private Integer tipo;
    private String descricao;
    private String mensagem;

    private TipoAlteracao(final Integer tipo, final String descricao, final String mensagem) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.mensagem = mensagem;
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
     * Recupera uma mensagem descritiva do tipo de alteração
     * 
     * @return {@link String} mensagem
     */
    public String getMensagem() {
        return this.mensagem;
    }

    /**
     * Entrega valor do tipo enumerado {@link TipoAlteracao} de acordo com a representação numérica dele
     * 
     * @param tipo
     *            tipo da alteração, sendo<br />
     *            <ul>
     *            <li>{@code 0} para Criação ({@code CREATE})</li>
     *            <li>{@code 1} para Atualização ({@code UPDATE})</li>
     *            <li>{@code 2} para Remoção ({@code DELETE})</li>
     *            </ul>
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
