package br.ufg.inf.repository.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import br.ufg.inf.model.support.AbstractEntity;

/**
 * Repositório genérico para extender recursos do Spring Data, para queries ou métodos mais elaborados
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see JpaRepository
 */
@NoRepositoryBean
public interface GenericRepository<E extends AbstractEntity<E>, PK extends Serializable> extends JpaRepository<E, PK>,
        JpaSpecificationExecutor<E> {

    /**
     * Recupera o {@link EntityManager}
     * 
     * @return {@link EntityManager}
     */
    EntityManager getEntityManager();

}
