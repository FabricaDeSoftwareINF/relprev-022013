package br.ufg.inf.repository;

import br.ufg.inf.model.Relator;
import br.ufg.inf.repository.support.GenericRepository;

/**
 * Repositório de acesso a dados de {@link Relator}.
 * 
 * <p>
 * Por enquanto só possui as ações básicas herdadas de {@link GenericRepository}.
 * <br>
 * A medida que for surgindo novas necessidades, serão implementadas. 
 * 
 * @created 05/11/2013
 * @author Danilo Guimarães J. Lemes - <a
 *         href="mailto:danilo.seusaraiva@gmail.com">danilo.seusaraiva@gmail.com</a>
 */
public interface RelatorRepository extends GenericRepository<Relator, Long> {

}
