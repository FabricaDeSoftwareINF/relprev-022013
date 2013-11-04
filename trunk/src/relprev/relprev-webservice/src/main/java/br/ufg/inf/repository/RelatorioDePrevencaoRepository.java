package br.ufg.inf.repository;

import java.util.List;

import br.ufg.inf.model.RelPrev;
import br.ufg.inf.repository.support.GenericRepository;

/**
 * Repositório de acesso a dados de {@link RelPrev}
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public interface RelatorioDePrevencaoRepository extends GenericRepository<RelPrev, Long> {

	/**
	 * Recupera um {@link RelPrev} com o ID informado como parâmetro
	 * 
	 * @param id
	 *            id do {@link RelPrev} a ser consultado
	 * @return {@link RelPrev}
	 */
	RelPrev findById(final Long id);

	/**
	 * Recupera uma lista de {@link RelPrev} de acordo com o local
	 * 
	 * @param local
	 *            local de acontecimento que ocasionou o {@link RelPrev}
	 * @return {@link RelPrev}
	 */
	List<RelPrev> findByLocalIgnoreCase(final String local);

	/**
	 * Recupera uma lista de {@link RelPrev} de acordo com a descrição
	 * 
	 * @param descricaoSituacaoPerigosa
	 *            descrição do {@link RelPrev}
	 * @return {@link RelPrev}
	 */
	List<RelPrev> findByDescricaoSituacaoPerigosaContainsIgnoreCase(final String descricaoSituacaoPerigosa);

}
