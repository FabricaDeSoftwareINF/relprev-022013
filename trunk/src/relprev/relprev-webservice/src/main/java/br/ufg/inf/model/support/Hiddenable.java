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
	 * Verifica se um objeto está hidden
	 * 
	 * @return true quando um objeto está oculto
	 */
	Boolean getIsHidden();

	/**
	 * Seta o objeto para hidden
	 * 
	 * @param isOculto
	 *            valor da flag hidden
	 */
	void setIsHidden(final Boolean hidden);

}
