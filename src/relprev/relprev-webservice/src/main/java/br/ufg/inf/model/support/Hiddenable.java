package br.ufg.inf.model.support;

/**
 * Interface que permite que o framework de persistência exclua logicamente um objeto
 * 
 * @created 03/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public interface Hiddenable {

	/**
	 * Verifica se um objeto está oculto
	 * 
	 * @return {@code true}, se o objeto está oculto, {@code false}, caso contrário
	 */
	Boolean getIsHidden();

	/**
	 * Oculta ou torna o objeto visível
	 * 
	 * @param hidden
	 *            {@code true}, se o objeto deve ser ocultado, {@code false}, caso contrário
	 */
	void setIsHidden(final Boolean hidden);

}
