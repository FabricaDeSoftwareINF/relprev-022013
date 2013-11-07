package br.ufg.inf.repository.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import br.ufg.inf.repository.support.impl.GenericRepositoryImpl;

/**
 * Adapter para {@link FactoryBean} interface para habilitar a configuração dos repositórios
 * customizados
 * 
 * @created 03/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class RepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends
		JpaRepositoryFactoryBean<T, S, ID> {

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(final EntityManager entityManager) {
		return new RepositoryFactory(entityManager);
	}

	private static class RepositoryFactory extends JpaRepositoryFactory {

		public RepositoryFactory(final EntityManager entityManager) {
			super(entityManager);
		}

		@Override
		@SuppressWarnings({"unchecked", "rawtypes"})
		protected <T, ID extends Serializable> JpaRepository<?, ?> getTargetRepository(
				final RepositoryMetadata metadata, final EntityManager entityManager) {
			final JpaEntityInformation<?, Serializable> entityInformation = this.getEntityInformation(metadata
					.getDomainType());
			return new GenericRepositoryImpl(entityInformation, entityManager);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(final RepositoryMetadata metadata) {
			return GenericRepositoryImpl.class;
		}

	}

}
