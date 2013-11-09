package br.ufg.inf.service;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

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

    protected static final String APPLICATION_JSON = MediaType.APPLICATION_JSON_VALUE;

    /**
     * Recupera o repositório de dados da entidade do modelo de domínio
     * 
     * @return {@code R extends GenericRepository<E, Long>}
     */
    public abstract R getRepository();

    @Autowired
    private LogRepository logRepository;

    /**
     * Lista todos os objetos contantes na base de dados
     * 
     * @return reposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_LIST, method = {GET, POST}, produces = APPLICATION_JSON)
    public final ResponseEntity<E> list() {
        ResponseEntity<E> _return = new ResponseEntity<E>();
        this.getLogger().debug("listando objetos");
        try {
            final List<E> dataList = this.getRepository().findAll();
            _return = _return.success(true).data(dataList).count(new Long(dataList.size()))
                    .message(ReponseMessages.LIST_MESSAGE).status(HttpStatus.OK);
            this.getLogger().debug(dataList.size() + " objetos listados");
        } catch (final Exception e) {
            _return = _return.success(false).count(0L).message(e.getMessage()).status(HttpStatus.BAD_REQUEST);
            this.getLogger().error("erro ao listar objetos " + e.getMessage(), e);
        }
        return _return;
    }

    /**
     * Consulta objeto pelo id
     * 
     * @param id
     *            identificado do objeto a ser consultado
     * @return resposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_FIND, method = {GET, POST}, produces = APPLICATION_JSON)
    public final ResponseEntity<E> find(@PathVariable("id") final Long id) {
        ResponseEntity<E> _return = new ResponseEntity<E>();
        this.getLogger().debug("consultando objeto de id " + id);
        try {
            final E entity = this.getRepository().findOne(id);
            _return = _return.success(true).data(entity).message(ReponseMessages.FIND_MESSAGE).status(HttpStatus.OK);
            this.getLogger().debug("objeto consultado com sucesso: " + entity.toString());
        } catch (final Exception e) {
            _return = _return.success(false).count(0L).message(e.getMessage()).status(HttpStatus.BAD_REQUEST);
            this.getLogger().error("problema ao consultar objeto: " + e.getMessage(), e);
        }
        return _return;
    }

    /**
     * Persisti um objeto
     * 
     * @param entity
     *            objeto a ser persistido
     * @return reposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_CREATE,
        method = POST,
        consumes = APPLICATION_JSON,
        produces = APPLICATION_JSON)
    public final ResponseEntity<E> create(@RequestBody final E entity) {
        ResponseEntity<E> _return = new ResponseEntity<E>();
        this.getLogger().debug("criando objeto");
        try {
            final E persistedEntity = this.getRepository().save(entity);
            this.beforeCreate(persistedEntity);
            this.getLogger().debug("objeto " + persistedEntity.toString() + " criado com sucesso");
            _return = _return.success(true).data(persistedEntity).message(ReponseMessages.CREATE_MESSAGE)
                    .status(HttpStatus.OK);
        } catch (final Exception e) {
            _return = _return.success(false).count(0L).message(e.getMessage()).status(HttpStatus.BAD_REQUEST);
            this.getLogger().error("problema ao criar objeto " + entity.toString() + ": " + e.getMessage(), e);
        }
        return _return;
    }

    /**
     * Atualiza o estado de um objeto persistido
     * 
     * @param entity
     *            entidade a ser atualizada
     * @return reposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_UPDATE,
        method = PUT,
        consumes = APPLICATION_JSON,
        produces = APPLICATION_JSON)
    public final ResponseEntity<E> update(@RequestBody final E entity) {
        ResponseEntity<E> _return = new ResponseEntity<E>();
        this.getLogger().debug("atualizando objeto " + entity.toString());
        try {
            final E persistedEntity = this.getRepository().save(entity);
            this.beforeUpdate(persistedEntity);
            _return = _return.success(true).data(persistedEntity).message(ReponseMessages.UPDATE_MESSAGE)
                    .status(HttpStatus.OK);
            this.getLogger().debug("objeto " + persistedEntity.toString() + " atualizado com sucesso");
        } catch (final Exception e) {
            _return = _return.success(false).count(0L).message(e.getMessage()).status(HttpStatus.BAD_REQUEST);
            this.getLogger().error("problema ao atualizar objeto " + entity.toString() + ": " + e.getMessage(), e);
        }
        return _return;
    }

    /**
     * Exclui um objeto persistido
     * 
     * @param id
     *            id da entidade a ser removida
     * @return reposta do processamento
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_DELETE, method = DELETE, produces = APPLICATION_JSON)
    public final ResponseEntity<E> delete(@PathVariable("id") final Long id) {
        ResponseEntity<E> _return = new ResponseEntity<E>();
        final E entity = this.getRepository().findOne(id);
        this.getLogger().debug("excluindo objeto " + entity.toString());
        try {
            this.beforeDelete(entity);
            this.getRepository().delete(entity);
            _return = _return.success(true).data(entity).message(ReponseMessages.DELETE_MESSAGE).status(HttpStatus.OK);
            this.getLogger().debug("objeto " + entity.toString() + " excluido com sucesso");
        } catch (final Exception e) {
            _return = _return.success(false).count(0L).message(e.getMessage()).status(HttpStatus.BAD_REQUEST);
            this.getLogger().error("problema ao excluir objeto " + entity.toString() + ": " + e.getMessage(), e);
        }
        return _return;
    }

    /**
     * Manipula exceções para status HTTP {@code 4xx}, exceções do cliente
     * 
     * @param ex
     *            {@link HttpClientErrorException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<E> handleException(final HttpClientErrorException ex) {
        final ResponseEntity<E> _return = new ResponseEntity<E>();
        return _return.success(false).count(0L).message(ex.getMessage()).status(ex.getStatusCode());
    }

    /**
     * Manipula exceções para status HTTP {@code 5xx}, exceções do servidor
     * 
     * @param ex
     *            {@link HttpServerErrorException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<E> handleException(final HttpServerErrorException ex) {
        final ResponseEntity<E> _return = new ResponseEntity<E>();
        return _return.success(false).count(0L).message(ex.getMessage()).status(ex.getStatusCode());
    }

    /**
     * Manipula exceções para status HTTP {@code 4xx}
     * 
     * @param ex
     *            {@link BeanCreationException}
     * @return resposta ao cliente
     */
    @ResponseBody
    @ExceptionHandler(BeanCreationException.class)
    public ResponseEntity<E> handleException(final BeanCreationException ex) {
        final ResponseEntity<E> _return = new ResponseEntity<E>();
        return _return.success(false).count(0L).message(ex.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Executa alterações na entidade de domínio antes da criação do registro
     * 
     * @param entity
     *            entidade do modelo de domínio
     */
    protected void beforeCreate(final E entity) {
        final Log log = this.buildLogRegistryCreate(entity);
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
        this.getLogRepository().save(log);
    }

    private LogRepository getLogRepository() {
        return this.logRepository;
    }

    private Log buildLogRegistryCreate(final E entity) {
        return this.buildLogRegistry(TipoAlteracao.CREATE, entity);
    }

    private Log buildLogRegistryUpdate(final E entity) {
        return this.buildLogRegistry(TipoAlteracao.UPDATE, entity);
    }

    private Log buildLogRegistryDelete(final E entity) {
        return this.buildLogRegistry(TipoAlteracao.DELETE, entity);
    }

    private Log buildLogRegistry(final TipoAlteracao tipoAlteracao, final E entity) {
        final String tableName = this.getTableName(entity);
        final String descricaoAlteracao = String.format(tipoAlteracao.getDescricao() + " de objeto de id %s.",
                entity.getId());
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

    protected Logger getLogger() {
        return this.logger;
    }

}
