package br.ufg.inf.service;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.Log;
import br.ufg.inf.model.support.TipoAlteracao;
import br.ufg.inf.repository.support.GenericRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.ReponseMessages;
import br.ufg.inf.service.support.ResponseEntity;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços comuns a todos os EndPoints REST, contendo também métodos utilitários de construção de
 * mensagens de resposta
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public abstract class GenericWebService<E extends AbstractEntity, R extends GenericRepository<E, Long>> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Recupera o repositório de dados da entidade do modelo de domínio
	 * 
	 * @return {@code R extends GenericRepository<E, Long>}
	 */
	public abstract R getRepository();

	@Autowired
	private LogRepository logRepository;

	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = WebServicesURL.URL_LIST, method = {GET, POST})
	public final ResponseEntity<E> list() {
		ResponseEntity<E> retorno;
		this.getLogger().debug("listando objetos");
		try {
			final List<E> dataList = this.getRepository().findAll();
			retorno = this.buildResponseEntity(dataList, ReponseMessages.LIST_MESSAGE);
			this.getLogger().debug(dataList.size() + " objetos listados");
		} catch (final Exception e) {
			retorno = this.buildResponseEntity(e);
			this.getLogger().error("erro ao listar objetos " + e.getMessage(), e);
		}
		return retorno;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = WebServicesURL.URL_FIND, method = {GET, POST})
	public final ResponseEntity<E> find(@PathVariable("id") final Long id) {
		ResponseEntity<E> retorno;
		this.getLogger().debug("consultando objeto de id " + id);
		try {
			final E entity = this.getRepository().findOne(id);
			retorno = this.buildResponseEntity(entity, ReponseMessages.FIND_MESSAGE);
			this.getLogger().debug("objeto consultado com sucesso: " + entity.toString());
		} catch (final Exception e) {
			retorno = this.buildResponseEntity(e);
			this.getLogger().error("problema ao consultar objeto: " + e.getMessage(), e);
		}
		return retorno;
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = WebServicesURL.URL_CREATE, method = POST)
	public final ResponseEntity<E> create(final E entity) {
		ResponseEntity<E> retorno;
		this.getLogger().debug("criando objeto " + entity.toString());
		try {
			this.getRepository().save(entity);
			this.getLogger().debug("objeto " + entity.toString() + " criado com sucesso");
			retorno = this.buildResponseEntity(entity, ReponseMessages.CREATE_MESSAGE);
		} catch (final Exception e) {
			retorno = this.buildResponseEntity(e);
			this.getLogger().error("problema ao criar objeto " + entity.toString() + ": " + e.getMessage(), e);
		}
		return retorno;
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = WebServicesURL.URL_UPDATE, method = PUT)
	public final ResponseEntity<E> update(final E entity) {
		ResponseEntity<E> retorno;
		this.getLogger().debug("atualizando objeto " + entity.toString());
		try {
			this.beforeUpdate(entity);
			this.getRepository().save(entity);
			retorno = this.buildResponseEntity(entity, ReponseMessages.UPDATE_MESSAGE);
			this.getLogger().debug("objeto " + entity.toString() + " atualizado com sucesso");
		} catch (final Exception e) {
			retorno = this.buildResponseEntity(e);
			this.getLogger().error("problema ao atualizar objeto " + entity.toString() + ": " + e.getMessage(), e);
		}
		return retorno;
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = WebServicesURL.URL_DELETE, method = DELETE)
	public final ResponseEntity<E> delete(final E entity) {
		ResponseEntity<E> retorno;
		this.getLogger().debug("excluindo objeto " + entity.toString());
		try {
			this.beforeDelete(entity);
			this.getRepository().delete(entity);
			retorno = this.buildResponseEntity(entity, ReponseMessages.DELETE_MESSAGE);
			this.getLogger().debug("objeto " + entity.toString() + " excluido com sucesso");
		} catch (final Exception e) {
			retorno = this.buildResponseEntity(e);
			this.getLogger().error("problema ao excluir objeto " + entity.toString() + ": " + e.getMessage(), e);
		}
		return retorno;
	}

	/**
	 * Executa alterações na entidade de domínio antes da criação do registro
	 * 
	 * @param entity
	 *            entidade do modelo de domínio
	 */
	protected void beforeCreate(final E entity) {
		final Log log = this.buildLogRegistryCreate(entity);
		final Date dataInsercaoAlteracao = new Date();
		log.setDataInsercaoAlteracao(dataInsercaoAlteracao);
		entity.setDataInsercaoAlteracao(dataInsercaoAlteracao);
		this.getLogRepository().save(log);
	}

	/**
	 * Executa alterações na entidade de domínio antes da atualização do registro
	 * 
	 * @param entity
	 *            entidade do modelo de domínio
	 */
	protected void beforeUpdate(final E entity) {
		final Log log = this.buildLogRegistryUpdate(entity);
		final Date dataInsercaoAlteracao = new Date();
		log.setDataInsercaoAlteracao(dataInsercaoAlteracao);
		entity.setDataInsercaoAlteracao(dataInsercaoAlteracao);
		this.getLogRepository().save(log);
	}

	/**
	 * Executa alterações na entidade de domínio antes da remoção do registro
	 * 
	 * @param entity
	 *            entidade do modelo de domínio
	 */
	protected void beforeDelete(final E entity) {
		final Log log = this.buildLogRegistryDelete(entity);
		final Date dataInsercaoAlteracao = new Date();
		log.setDataInsercaoAlteracao(dataInsercaoAlteracao);
		entity.setDataInsercaoAlteracao(dataInsercaoAlteracao);
		this.getLogRepository().save(log);
	}

	private LogRepository getLogRepository() {
		return this.logRepository;
	}

	private Log buildLogRegistryCreate(final E entity) {
		return this.buildLogRegistry(TipoAlteracao.CREATE, entity);
	}

	private Log buildLogRegistryUpdate(final E entity) {
		// TODO atualizar objeto de log para conter a descrição de tudo que foi alterado
		return this.buildLogRegistry(TipoAlteracao.UPDATE, entity);
	}

	private Log buildLogRegistryDelete(final E entity) {
		return this.buildLogRegistry(TipoAlteracao.DELETE, entity);
	}

	private Log buildLogRegistry(final TipoAlteracao tipoAlteracao, final E entity) {
		final String tableName = this.getTableName(entity);
		final String descricaoAlteracao = String.format(tipoAlteracao.getDescricao()
				+ " de objeto de id %s na tabela %s.", entity.getId(), tableName);
		final Log log = new Log();
		log.setTabelaAlterada(tableName);
		log.setTipoAlteracao(tipoAlteracao);
		log.setDescricaoAlteracao(descricaoAlteracao);
		return log;
	}

	private String getTableName(final E entity) {
		final Class<?> clazz = entity.getClass();
		if (!clazz.isAnnotationPresent(Table.class)) {
			throw new IllegalArgumentException("Entidade " + entity.getClass().getName() + " não é uma entidade JPA");
		}
		final Table tableAnnotation = clazz.getAnnotation(Table.class);
		return tableAnnotation.name();
	}

	protected ResponseEntity<E> buildResponseEntity(final E data, final String message) {
		return this.buildResponseEntity(data, 1L, message);
	}

	protected ResponseEntity<E> buildResponseEntity(final E data, final Long count, final String message) {
		final List<E> dataList = new LinkedList<E>();
		dataList.add(data);
		return this.buildResponseEntity(dataList, message);
	}

	protected ResponseEntity<E> buildResponseEntity(final List<E> data, final String message) {
		return this.buildResponseEntity(data, new Long(data.size()), message);
	}

	protected ResponseEntity<E> buildResponseEntity(final List<E> data, final Long count, final String message) {
		return this.buildResponseEntity(Boolean.TRUE, data, count, message, "OK");
	}

	protected ResponseEntity<E> buildResponseEntity(final Exception exception) {
		return this.buildResponseEntity(Boolean.FALSE, null, 0L, exception.getMessage(),
				"NOTOK");
	}

	private ResponseEntity<E> buildResponseEntity(final Boolean success, final List<E> data, final Long count,
			final String message, final String status) {
		final ResponseEntity<E> response = new ResponseEntity<E>();
		response.setSuccess(success);
		response.setData(data);
		response.setCount(count);
		response.setMessage(message);
		response.setStatus(status);
		return response;
	}

	protected Logger getLogger() {
		return this.logger;
	}

}
