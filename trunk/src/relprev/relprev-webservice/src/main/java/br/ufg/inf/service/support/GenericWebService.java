package br.ufg.inf.service.support;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;
import java.util.Set;

import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.Log;
import br.ufg.inf.model.support.TipoAlteracao;
import br.ufg.inf.repository.support.GenericRepository;
import br.ufg.inf.repository.support.LogRepository;

/**
 * Serviços comuns a todos os EndPoints REST, contendo também métodos utilitários de construção de mensagens de resposta
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class GenericWebService<E extends AbstractEntity<E>, R extends GenericRepository<E, Long>> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected static final String APPLICATION_JSON = MediaType.APPLICATION_JSON_VALUE;

    private final R repository;

    private final LogRepository logRepository;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    public GenericWebService(final R repository, final LogRepository logRepository) {
        this.repository = repository;
        this.logRepository = logRepository;
    }

    /**
     * Lista todos os objetos contantes na base de dados
     * 
     * @return {@link Response} resposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_LIST, method = {GET, POST}, produces = APPLICATION_JSON)
    public final Response<E> list() {
        Response<E> response;
        this.getLogger().debug("listando objetos");
        try {
            final List<E> dataList = this.getRepository().findAll();
            final Integer dataListSize = dataList.size();
            final String message = dataListSize > 0 ? String.format(ResponseMessages.LIST_MESSAGE, dataListSize)
                    : ResponseMessages.NOTLIST_MESSAGE;
            response = new ResponseBuilder<E>().success(true).data(dataList).message(message).status(HttpStatus.OK).build();
            this.getLogger().debug(message);
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = new ResponseBuilder<E>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("erro ao listar objetos " + message, e);
        }
        return response;
    }

    /**
     * Consulta objeto pelo id
     * 
     * @param id
     *            identificado do objeto a ser consultado
     * @return {@link Response} resposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_FIND, method = {GET, POST}, produces = APPLICATION_JSON)
    public final Response<E> find(@PathVariable("id") final Long id) {
        Response<E> response;
        this.getLogger().debug("consultando objeto de id " + id);
        try {
            final E entity = this.getRepository().findOne(id);
            final String message = entity != null ? String.format(ResponseMessages.FIND_MESSAGE, id) : String.format(
                    ResponseMessages.NOTFIND_MESSAGE, id);
            response = new ResponseBuilder<E>().success(true).data(entity).message(message).status(HttpStatus.OK).build();
            this.getLogger().debug(message);
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = new ResponseBuilder<E>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("problema ao consultar objeto: " + message, e);
        }
        return response;
    }

    /**
     * Persisti um objeto
     * 
     * @param entity
     *            objeto a ser persistido
     * @return {@link Response} resposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_CREATE, method = POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public final Response<E> create(@Valid @RequestBody final E entity) {
        Response<E> response;
        this.getLogger().debug("criando objeto");
        try {
            final E persistedEntity = this.getRepository().save(entity);
            this.afterCreate(persistedEntity);
            this.getLogger().debug("objeto " + persistedEntity.toString() + " criado com sucesso");
            response = new ResponseBuilder<E>().success(true).data(persistedEntity).message(ResponseMessages.CREATE_MESSAGE)
                    .status(HttpStatus.OK).build();
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = handlingCatchedExceptions(e, message);
            this.getLogger().error("problema ao criar objeto " + entity.toString() + ": " + message, e);
        }
        return response;
    }

    /**
     * Atualiza o estado de um objeto persistido
     * 
     * @param entity
     *            entidade a ser atualizada
     * @return {@link Response} resposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_UPDATE, method = PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public final Response<E> update(@Valid @RequestBody final E entity) {
        Response<E> response;
        this.getLogger().debug("atualizando objeto " + entity.toString());
        try {
            final E persistedEntity = this.getRepository().save(entity);
            this.afterUpdate(persistedEntity);
            response = new ResponseBuilder<E>().success(true).data(persistedEntity)
                    .message(String.format(ResponseMessages.UPDATE_MESSAGE, entity.getId())).status(HttpStatus.OK).build();
            this.getLogger().debug("objeto " + persistedEntity.toString() + " atualizado com sucesso");
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = handlingCatchedExceptions(e, message);
            this.getLogger().error("problema ao atualizar objeto " + entity.toString() + ": " + message, e);
        }
        return response;
    }

    /**
     * Exclui um objeto persistido
     * 
     * @param id
     *            id da entidade a ser removida
     * @return {@link Response} resposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_DELETE, method = DELETE, produces = APPLICATION_JSON)
    public final Response<E> delete(@PathVariable("id") final Long id) {
        Response<E> response;
        final E entity = this.getRepository().findOne(id);
        this.getLogger().debug("excluindo objeto " + entity.toString());
        try {
            this.beforeDelete(entity);
            this.getRepository().delete(entity);
            response = new ResponseBuilder<E>().success(true).data(entity).message(ResponseMessages.DELETE_MESSAGE)
                    .status(HttpStatus.OK).build();
            this.getLogger().debug("objeto " + entity.toString() + " excluido com sucesso");
        } catch (final Exception e) {
            final String message = ExceptionUtils.getRootCauseMessage(e);
            response = new ResponseBuilder<E>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("problema ao excluir objeto " + entity.toString() + ": " + message, e);
        }
        return response;
    }

    /**
     * Executa alterações na entidade de domínio depois da criação do registro
     * 
     * @param entity
     *            entidade do modelo de domínio
     */
    protected <T extends AbstractEntity<T>> void afterCreate(final T entity) {
        final Log log = this.buildLogRegistry(TipoAlteracao.CREATE, entity);
        this.getLogRepository().save(log);
    }

    /**
     * Executa alterações na entidade de domínio antes da criação do registro
     * 
     * @param entity
     *            entidade do modelo de domínio
     */
    protected <T extends AbstractEntity<T>> void beforeCreate(final T entity) { }

    /**
     * Executa alterações na entidade de domínio depois da atualização do registro
     * 
     * @param entity
     *            entidade do modelo de domínio
     */
    protected <T extends AbstractEntity<T>> void afterUpdate(final T entity) {
        final Log log = this.buildLogRegistry(TipoAlteracao.UPDATE, entity);
        this.getLogRepository().save(log);
    }

    /**
     * Executa alterações na entidade de domínio antes da atualização do registro
     * 
     * @param entity
     *            entidade do modelo de domínio
     */
    protected <T extends AbstractEntity<T>> void beforeUpdate(final T entity) { }

    /**
     * Executa alterações na entidade de domínio depois da remoção do registro
     * 
     * @param entity
     *            entidade do modelo de domínio
     */
    protected <T extends AbstractEntity<T>> void afterDelete(final T entity) { }

    /**
     * Executa alterações na entidade de domínio antes da remoção do registro
     * 
     * @param entity
     *            entidade do modelo de domínio
     */
    protected <T extends AbstractEntity<T>> void beforeDelete(final T entity) {
        final Log log = this.buildLogRegistry(TipoAlteracao.DELETE, entity);
        this.getLogRepository().save(log);
    }

    /**
     * Recupera o repositório de acesso a dados aos objetos de domínio
     * 
     * @return {@code R extends GenericRepository<E, Long>}
     */
    protected R getRepository() {
        return this.repository;
    }

    /**
     * Repositório para persistência do log de alteração dos objetos
     * 
     * @return {@link LogRepository}
     */
    private LogRepository getLogRepository() {
        return this.logRepository;
    }

    /**
     * Recupera a entidade de log da alteração realizada no objeto
     * 
     * @param tipoAlteracao
     *            tipo da alteração realizada
     * @param entity
     *            entidade do domínio
     * @return {@link Log}
     */
    private <T extends AbstractEntity<T>> Log buildLogRegistry(final TipoAlteracao tipoAlteracao, final T entity) {
        final String tableName = this.getTableName(entity);
        final String descricaoAlteracao = String.format(tipoAlteracao.getDescricao() + " de objeto de id %s.", entity.getId());
        final Log log = new Log();
        log.setTabelaAlterada(tableName);
        log.setTipoAlteracao(tipoAlteracao);
        log.setDescricaoAlteracao(descricaoAlteracao);
        return log;
    }

    /**
     * Recupera, para log de alteração, o nome da tabela na base relacional de uma entidade JPA
     * 
     * @param entity
     *            &lt;E extends {@link AbstractEntity}&gt;
     * @return {@link String} nome da tabela na base de dados
     */
    private <T extends AbstractEntity<T>> String getTableName(final T entity) {
        final Class<?> clazz = entity.getClass();
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("Entidade " + entity.getClass().getName() + " não é uma entidade JPA");
        }
        final Table tableAnnotation = clazz.getAnnotation(Table.class);
        return tableAnnotation.name();
    }

    /**
     * Logger para uso também nas sub-classes
     * 
     * @return {@link Logger}
     */
    protected Logger getLogger() {
        return this.logger;
    }

    /**
     * Trata a exceção, para geração da resposta, captura pelos end points
     * 
     * @param ex
     *            {@link Exception}
     * @return resposta ao cliente
     */
    private Response<E> handlingCatchedExceptions(final Exception ex, final String message) {
        Response<E> response;
        if (ex instanceof ConstraintViolationException) {
            response = this.buildResponseForConstraintViolationException((ConstraintViolationException) ex);
        } else {
            response = new ResponseBuilder<E>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    /**
     * Manipula exceções para status HTTP {@code 5xx}, exceções do servidor
     * 
     * @param ex
     *            {@link ConstraintViolationException}
     * @return resposta ao cliente
     */
    private Response<E> buildResponseForConstraintViolationException(final ConstraintViolationException ex) {
        this.logger.info("handleConstraintViolationException - Catching: " + ex.getClass().getSimpleName(), ex);
        final StringBuilder messageResponse = new StringBuilder();
        final Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        Integer violationsSize = violations.size();
        for (final ConstraintViolation<?> violation : violations) {
            messageResponse.append(this.messageSource.getMessage(violation.getMessage(), null, null));
            if (violationsSize > 1) {
                messageResponse.append(" | ");
            }
            violationsSize--;
        }
        return new ResponseBuilder<E>().success(false).message(messageResponse.toString()).status(HttpStatus.BAD_REQUEST).build();
    }

}
