package br.ufg.inf.repository.support.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;
import br.ufg.inf.repository.support.GenericRepository;

/**
 * Extende recursos do Spring Data, para queries mais elaboradas, além de implementar modelo de persistência adotado para o
 * projeto
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see SimpleJpaRepository
 */
@Transactional(readOnly = true)
public class GenericRepositoryImpl<E extends AbstractEntity<E>, PK extends Serializable> extends SimpleJpaRepository<E, PK>
        implements GenericRepository<E, PK> {

    private final EntityManager entityManager;
    private final JpaEntityInformation<E, ?> entityInformation;

    public GenericRepositoryImpl(final JpaEntityInformation<E, ?> entityInformation, final EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }

    @Override
    @Transactional
    public <S extends E> S save(final S entity) {
        Assert.notNull(entity, "A entidade não pode ser nula!");
        final Date dataInsercaoAlteracao = Calendar.getInstance().getTime();
        entity.setDataInsercaoAlteracao(dataInsercaoAlteracao);
        if (entity.getClass().isAnnotationPresent(Hiddenable.class)) {
            entity.setHidden(Boolean.FALSE);
            /*
             * TODO necessário incluir feature que set todos os objetos relacionados que são também hiddenable com os atributos
             * 'hidden' e 'dataInsercaoAlteracao'
             */
        }
        if (this.getEntityInformation().isNew(entity)) {
            this.getEntityManager().persist(entity);
        } else {
            final Updatable updatable = entity.getClass().getAnnotation(Updatable.class);
            final Boolean newInsert = updatable.newinsert();
            final Boolean isUpdatable = updatable.updatable();
            if (newInsert) {
                // atualizando o estado da versão antiga da entidade
                final E oldEntity = this.findOne(this.isHiddenByID(entity.getId()));
                if (oldEntity.getClass().isAnnotationPresent(Hiddenable.class)) {
                    oldEntity.setHidden(Boolean.TRUE);
                }
                this.getEntityManager().merge(oldEntity);

                // a nova versão é a que foi enviada
                entity.setVersaoAnterior(oldEntity);
                this.getEntityManager().persist(entity);
                return entity;
            }
            if (isUpdatable) {
                return this.getEntityManager().merge(entity);
            }
            throw new PersistenceException(String.format(
                    "A entidade %s não pode ter seus valores atualizados, nem mesmo versionados.", entity.getClass()
                            .getSimpleName()));
        }
        return entity;
    }

    @Override
    @Transactional
    public void delete(final E entity) {
        Assert.notNull(entity, "A entidade não pode ser nula!");
        entity.setDataInsercaoAlteracao(Calendar.getInstance().getTime());
        if (entity.getClass().isAnnotationPresent(Hiddenable.class)) {
            entity.setHidden(Boolean.TRUE);
            this.getEntityManager().merge(entity);
        } else {
            throw new PersistenceException(
                    "Os objetos das entidades de persistência controladas por este framework não podem ser excluídas.");
        }
    }

    @Override
    public List<E> findAll() {
        if (this.getEntityInformation().getJavaType().isAnnotationPresent(Hiddenable.class)) {
            return super.findAll(this.isHidden());
        }
        return super.findAll();
    }

    @Override
    public E findOne(final PK pk) {
        if (this.getEntityInformation().getJavaType().isAnnotationPresent(Hiddenable.class)) {
            return this.findOne(this.isHiddenByID(pk));
        }
        return super.findOne(pk);
    }

    /**
     * {@link Specification} para listagem de objetos não ocultos
     * 
     * @return {@link Specification}
     */
    private Specification<E> isHidden() {
        return new Specification<E>() {

            @Override
            public Predicate toPredicate(final Root<E> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                return cb.isFalse(root.<Boolean> get("hidden"));
            }

        };
    }

    /**
     * {@link Specification} para consulta de um único objeto não oculto
     * 
     * @param pk
     *            id do objeto a ser consultado
     * @return {@link Specification}
     */
    private Specification<E> isHiddenByID(final PK pk) {
        return new Specification<E>() {

            @Override
            public Predicate toPredicate(final Root<E> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                final Predicate id = cb.equal(root.get("id"), pk);
                final Predicate hidden = cb.isFalse(root.<Boolean> get("hidden"));
                return cb.and(id, hidden);
            }

        };
    }

    /**
     * {@link Specification} para consulta de um único objeto não oculto
     * 
     * @param id
     *            id do objeto a ser consultado
     * @return {@link Specification}
     */
    private Specification<E> isHiddenByID(final Long id) {
        return new Specification<E>() {

            @Override
            public Predicate toPredicate(final Root<E> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                final Predicate pk = cb.equal(root.get("id"), id);
                final Predicate hidden = cb.isFalse(root.<Boolean> get("hidden"));
                return cb.and(pk, hidden);
            }

        };
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected JpaEntityInformation<E, ?> getEntityInformation() {
        return this.entityInformation;
    }

}
