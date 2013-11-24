package br.ufg.inf.repository;

import java.util.List;

import br.ufg.inf.model.RelatorioPrevencao;
import br.ufg.inf.repository.support.GenericRepository;

/**
 * Repositório de acesso a dados de {@link RelatorioPrevencao}
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericRepository
 */
public interface RelatorioDePrevencaoRepository extends GenericRepository<RelatorioPrevencao, Long> {

    /**
     * Recupera uma lista de {@link RelatorioPrevencao} de acordo com o local
     * 
     * @param local
     *            local de acontecimento que ocasionou o {@link RelatorioPrevencao}
     * @return {@link RelatorioPrevencao}
     */
    List<RelatorioPrevencao> findByLocalIgnoreCase(final String local);

    /**
     * Recupera uma lista de {@link RelatorioPrevencao} de acordo com a descrição
     * 
     * @param descricaoSituacaoPerigosa
     *            descrição do {@link RelatorioPrevencao}
     * @return {@link RelatorioPrevencao}
     */
    List<RelatorioPrevencao> findByDescricaoSituacaoPerigosaContainsIgnoreCase(final String descricaoSituacaoPerigosa);

}
