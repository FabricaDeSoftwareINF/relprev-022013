package br.ufg.inf.repository;

import br.ufg.inf.model.Categoria;
import br.ufg.inf.repository.support.GenericRepository;

/**
 * Repositório de acesso a dados de {@link Categoria}
 * 
 * @created 06/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericRepository
 */
public interface CategoriaRepository extends GenericRepository<Categoria, Long> {

}
