package br.ufg.inf.repository.support.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.Hiddenable;
import br.ufg.inf.repository.support.GenericRepository;

/**
 * Extende recursos do Spring Data, para queries mais elaboradas
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Transactional(readOnly = true)
public class GenericRepositoryImpl<E extends AbstractEntity, PK extends Serializable> extends
		SimpleJpaRepository<E, PK> implements GenericRepository<E, PK> {

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
		if (this.getEntityInformation().isNew(entity)) {
			if (entity instanceof Hiddenable) {
				((Hiddenable) entity).setIsHidden(Boolean.FALSE);
			}
			this.getEntityManager().persist(entity);
			return entity;
		} else {
			return this.getEntityManager().merge(entity);
		}
	}

	@Override
	@Transactional
	public void delete(final E entity) {
		if (entity instanceof Hiddenable) {
			((Hiddenable) entity).setIsHidden(Boolean.TRUE);
			this.getEntityManager().merge(entity);
		} else {
			super.delete(entity);
		}
	}

	@Override
	public void deleteInBatch(final Iterable<E> entities) {
		if (null == entities || !entities.iterator().hasNext()) {
			return;
		}
		final Iterator<E> iterator = entities.iterator();
		while (iterator.hasNext()) {
			this.delete(iterator.next());
		}
	}

	@Override
	public <OE> OE findOne(final Class<OE> entityClass, final PK id) {
		return this.getEntityManager().find(entityClass, id);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	protected JpaEntityInformation<E, ?> getEntityInformation() {
		return this.entityInformation;
	}

}
