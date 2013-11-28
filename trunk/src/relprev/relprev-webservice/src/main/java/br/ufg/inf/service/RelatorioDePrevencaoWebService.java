package br.ufg.inf.service;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.beans.Introspector;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufg.inf.model.AcaoRecomendada;
import br.ufg.inf.model.ClassificacaoRisco;
import br.ufg.inf.model.Encaminhamento;
import br.ufg.inf.model.Observacao;
import br.ufg.inf.model.ParecerSetor;
import br.ufg.inf.model.RelatorioPrevencao;
import br.ufg.inf.model.Resposta;
import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.TipoAlteracao;
import br.ufg.inf.model.util.ReflectionUtil;
import br.ufg.inf.repository.AcaoRecomendadaRepository;
import br.ufg.inf.repository.ClassificacaoRiscoRepository;
import br.ufg.inf.repository.EncaminhamentoRepository;
import br.ufg.inf.repository.ObservacaoRepository;
import br.ufg.inf.repository.ParecerSetorRepository;
import br.ufg.inf.repository.RelatorioDePrevencaoRepository;
import br.ufg.inf.repository.RespostaRepository;
import br.ufg.inf.repository.support.GenericRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.GenericWebService;
import br.ufg.inf.service.support.Response;
import br.ufg.inf.service.support.ResponseBuilder;
import br.ufg.inf.service.support.ResponseMessages;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços para os Relatório de Prevenção ({@link RelatorioPrevencao})
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericWebService
 */
@Controller
@RequestMapping(value = WebServicesURL.URL_RELPREV)
public class RelatorioDePrevencaoWebService extends GenericWebService<RelatorioPrevencao, RelatorioDePrevencaoRepository> {

    @Autowired
    private AcaoRecomendadaRepository acaoRecomendadaRepository;

    @Autowired
    private ClassificacaoRiscoRepository classificacaoRiscoRepository;

    @Autowired
    private EncaminhamentoRepository encaminhamentoRepository;

    @Autowired
    private ObservacaoRepository observacaoRepository;

    @Autowired
    private ParecerSetorRepository parecerSetorRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    public RelatorioDePrevencaoWebService(final RelatorioDePrevencaoRepository repository, final LogRepository logRepository) {
        super(repository, logRepository);
    }

    /**
     * Busca por relatórios de prevenção que possuam o local informado
     * 
     * @param local
     *            local a ser pesquisado nos relatórios de prevenção
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_RELPREV_FIND_LOCAL + "/{local}", method = {GET, POST}, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> findRelPrevByLocal(@PathVariable("local") final String local) {
        Response<RelatorioPrevencao> response;
        getLogger().debug("listando relatórios de prevenção por local '" + local + "'");
        try {
            final List<RelatorioPrevencao> dataList = getRepository().findByLocalIgnoreCase(local);
            response = new ResponseBuilder<RelatorioPrevencao>().success(true).data(dataList)
                    .message(String.format(ResponseMessages.LIST_MESSAGE, dataList.size())).status(HttpStatus.OK).build();
            getLogger().debug("sucesso ao listar relatórios de prevenção por local '" + local + "'");
        } catch (final Exception e) {
            response = new ResponseBuilder<RelatorioPrevencao>().success(false).message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST).build();
            getLogger().error("erro ao listar relatórios de prevenção por local '" + local + "'");
        }
        return response;
    }

    /**
     * Busca por relatórios de prevenção que possuam a descrição informada
     * 
     * @param descricao
     *            descrição a ser pesquisada nos relatórios de prevenção
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_RELPREV_FIND_DESCRICAO + "/{descricao}",
    method = {GET, POST},
    produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> findRelPrevByDescricao(@PathVariable("descricao") final String descricao) {
        Response<RelatorioPrevencao> response;
        getLogger().debug("listando relatórios de prevenção por descrição '" + descricao + "'");
        try {
            final List<RelatorioPrevencao> dataList = getRepository().findByDescricaoSituacaoPerigosaContainsIgnoreCase(
                    descricao);
            response = new ResponseBuilder<RelatorioPrevencao>().success(true).data(dataList)
                    .message(String.format(ResponseMessages.LIST_MESSAGE, dataList.size())).status(HttpStatus.OK).build();
            getLogger().debug("sucesso ao listar relatórios de prevenção por descrição '" + descricao + "'");
        } catch (final Exception e) {
            response = new ResponseBuilder<RelatorioPrevencao>().success(false).message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST).build();
            getLogger().error("erro ao listar relatórios de prevenção por descrição '" + descricao + "'");
        }
        return response;
    }

    /**
     * Adiciona a um relatório de prevenção uma ação recomendada
     * 
     * @param id
     *            id do relprev a ter a ação recomendada incluída
     * @param acaoRecomendada
     *            ação recomendada a ser incluída
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/acao", method = POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> addAcaoRecomendada(@PathVariable("id") final Long id,
            @RequestBody final AcaoRecomendada acaoRecomendada) {
        return createInterationObject(id, acaoRecomendada, this.acaoRecomendadaRepository);
    }

    /**
     * Atualiza uma ação recomendada de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter a ação recomendada atualizada
     * @param acaoRecomendada
     *            ação recomendada a ser atualizada
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/acao", method = PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> updateAcaoRecomendada(@PathVariable("id") final Long id,
            @RequestBody final AcaoRecomendada acaoRecomendada) {
        return updateInterationObject(id, acaoRecomendada, this.acaoRecomendadaRepository);
    }

    /**
     * Exclui uma ação recomendada de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter a ação recomendada excluida
     * @param acaoRecomendada
     *            ação recomendada a ser excluida
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/acao", method = DELETE, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> deleteAcaoRecomendada(@PathVariable("id") final Long id) {
        // TODO work in progress
        return null;
    }

    /**
     * Adiciona a um relatório de prevenção uma classifcação
     * 
     * @param id
     *            id do relprev a ter a classifcação incluída
     * @param classificacao
     *            classifcação a ser incluída
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/classificacao", method = POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> addClassificacaoDeRisco(@PathVariable("id") final Long id,
            @RequestBody final ClassificacaoRisco classificacaoRisco) {
        return createInterationObject(id, classificacaoRisco, this.classificacaoRiscoRepository);
    }

    /**
     * Atualiza uma classificação de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter a classifcação atualizada
     * @param classificacao
     *            classifcação a ser atualizada
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/classificacao", method = PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> updateClassificacaoDeRisco(@PathVariable("id") final Long id,
            @RequestBody final ClassificacaoRisco classificacaoRisco) {
        return updateInterationObject(id, classificacaoRisco, this.classificacaoRiscoRepository);
    }

    /**
     * Exclui uma classificação de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter a classifcação excluida
     * @param classificacao
     *            classifcação a ser excluida
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/classificacao", method = DELETE, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> deleteClassificacaoDeRisco(@PathVariable("id") final Long id) {
        // TODO work in progress
        return null;
    }

    /**
     * Atualiza um encaminhamento de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter o encaminhamento incluído
     * @param encaminhamento
     *            encaminhamento a ser incluído
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/encaminhamento", method = PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> addEncaminhamento(@PathVariable("id") final Long id,
            @Valid @RequestBody final Encaminhamento encaminhamento, final BindingResult result) {
        if (result.hasErrors()) {
            return buildDataInteracaoResponse(result);
        }
        return createInterationObject(id, encaminhamento, this.encaminhamentoRepository);
    }

    /**
     * Adiciona a um relatório de prevenção um encaminhamento
     * 
     * @param id
     *            id do relprev a ter o encaminhamento atualizado
     * @param encaminhamento
     *            encaminhamento a ser atualizado
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/encaminhamento", method = PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> updateEncaminhamento(@PathVariable("id") final Long id,
            @Valid @RequestBody final Encaminhamento encaminhamento, final BindingResult result) {
        if (result.hasErrors()) {
            return buildDataInteracaoResponse(result);
        }
        return updateInterationObject(id, encaminhamento, this.encaminhamentoRepository);
    }

    /**
     * Exclui a um relatório de prevenção um encaminhamento
     * 
     * @param id
     *            id do relprev a ter o encaminhamento excluido
     * @param encaminhamento
     *            encaminhamento a ser excluido
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/encaminhamento", method = DELETE, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> deleteEncaminhamento(@PathVariable("id") final Long id) {
        // TODO work in progress
        return null;
    }

    /**
     * Adiciona a um relatório de prevenção uma observação
     * 
     * @param id
     *            id do relprev a ter a observação incluída
     * @param observacao
     *            observação a ser incluída
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/observacao", method = POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> addObservacao(@PathVariable("id") final Long id, @RequestBody final Observacao observacao) {
        return createInterationObject(id, observacao, this.observacaoRepository);
    }

    /**
     * Atualiza a observação de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter a observação atualizada
     * @param observacao
     *            observação a ser atualizada
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/observacao", method = PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> updateObservacao(@PathVariable("id") final Long id, @RequestBody final Observacao observacao) {
        return updateInterationObject(id, observacao, this.observacaoRepository);
    }

    /**
     * Exclui a observação de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter a observação excluída
     * @param observacao
     *            observação a ser excluída
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/observacao", method = DELETE, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> deleteObservacao(@PathVariable("id") final Long id) {
        // TODO work in progress
        return null;
    }

    /**
     * Adiciona a um relatório de prevenção o parecer do setor
     * 
     * @param id
     *            id do relprev a ter o parecer do setor incluído
     * @param parecerSetor
     *            parecer do setor a ser incluído
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/parecer", method = POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> addParecerSetor(@PathVariable("id") final Long id,
            @Valid @RequestBody final ParecerSetor parecerSetor, final BindingResult result) {
        if (result.hasErrors()) {
            return buildDataInteracaoResponse(result);
        }
        return createInterationObject(id, parecerSetor, this.parecerSetorRepository);
    }

    /**
     * Atualiza o parecer do setor de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter o parecer do setor atualizado
     * @param parecerSetor
     *            parecer do setor a ser atualizado
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/parecer", method = PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> updateParecerSetor(@PathVariable("id") final Long id,
            @Valid @RequestBody final ParecerSetor parecerSetor, final BindingResult result) {
        if (result.hasErrors()) {
            return buildDataInteracaoResponse(result);
        }
        return updateInterationObject(id, parecerSetor, this.parecerSetorRepository);
    }

    /**
     * Exclui o parecer do setor de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter o parecer do setor excluído
     * @param parecerSetor
     *            parecer do setor a ser excluído
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/parecer", method = DELETE, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> deleteParecerSetor(@PathVariable("id") final Long id) {
        // TODO work in progress
        return null;
    }

    /**
     * Adiciona a um relatório de prevenção uma resposta
     * 
     * @param id
     *            id do relprev a ter a resposta incluída
     * @param resposta
     *            resposta a ser incluída
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/resposta", method = POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> addResposta(@PathVariable("id") final Long id,
            @Valid @RequestBody final Resposta resposta, final BindingResult result) {
        if (result.hasErrors()) {
            return buildDataInteracaoResponse(result);
        }
        return createInterationObject(id, resposta, this.respostaRepository);
    }

    /**
     * Atualiza a resposta de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter a resposta atualizada
     * @param resposta
     *            resposta a ser atualizada
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/resposta", method = PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> updateResposta(@PathVariable("id") final Long id,
            @Valid @RequestBody final Resposta resposta, final BindingResult result) {
        if (result.hasErrors()) {
            return buildDataInteracaoResponse(result);
        }
        return updateInterationObject(id, resposta, this.respostaRepository);
    }

    /**
     * Exclui a resposta de um relatório de prevenção
     * 
     * @param id
     *            id do relprev a ter a resposta excluída
     * @param resposta
     *            resposta a ser excluída
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/resposta", method = DELETE, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> deleteResposta(@PathVariable("id") final Long id) {
        // TODO work in progress
        return null;
    }

    /**
     * Constrói resposta em caso de validação com falha para a data das interações em relação à data de persistência do relatório
     * de prevenção
     * 
     * @param result
     *            {@link BindingResult}
     * @return {@link Response}
     */
    private Response<RelatorioPrevencao> buildDataInteracaoResponse(final BindingResult result) {
        return new ResponseBuilder<RelatorioPrevencao>().success(false).status(HttpStatus.BAD_REQUEST)
                .message(result.getFieldError("data").getDefaultMessage()).build();
    }

    /**
     * Cria o objeto da interação com o relatório de prevenção. A interação pode ser uma das seguintes:
     * <ul>
     * <li>{@link AcaoRecomendada}</li>
     * <li>{@link ClassificacaoRisco}</li>
     * <li>{@link Encaminhamento}</li>
     * <li>{@link Observacao}</li>
     * <li>{@link ParecerSetor}</li>
     * <li>{@link Resposta}</li>
     * </ul>
     * 
     * @param relPrevID
     *            id do relatório de prevenção a ter a interação persistida
     * @param entity
     *            entidade da interação do relatório de prevenção a ser persistida
     * @param targetRepository
     *            repositório de dados da interação do relatório de prevenção
     * @return {@link Response}
     */
    private <E extends AbstractEntity<E>, R extends GenericRepository<E, Long>> Response<RelatorioPrevencao> createInterationObject(
            final Long relPrevID, final E entity, final R targetRepository) {
        return persistInterationObject(relPrevID, entity,  targetRepository, TipoAlteracao.CREATE);
    }

    /**
     * Atualiza o objeto da interação com o relatório de prevenção. A interação pode ser uma das seguintes:
     * <ul>
     * <li>{@link AcaoRecomendada}</li>
     * <li>{@link ClassificacaoRisco}</li>
     * <li>{@link Encaminhamento}</li>
     * <li>{@link Observacao}</li>
     * <li>{@link ParecerSetor}</li>
     * <li>{@link Resposta}</li>
     * </ul>
     * 
     * @param relPrevID
     *            id do relatório de prevenção a ter a interação persistida
     * @param entity
     *            entidade da interação do relatório de prevenção a ser persistida
     * @param targetRepository
     *            repositório de dados da interação do relatório de prevenção
     * @return {@link Response}
     */
    private <E extends AbstractEntity<E>, R extends GenericRepository<E, Long>> Response<RelatorioPrevencao> updateInterationObject(
            final Long relPrevID, final E entity, final R targetRepository) {
        return persistInterationObject(relPrevID, entity, targetRepository, TipoAlteracao.UPDATE);
    }

    /**
     * Persiste o objeto da interação com o relatório de prevenção. A interação pode ser uma das seguintes:
     * 
     * @param relPrevID
     *            id do relatório de prevenção a ter a interação persistida
     * @param entity
     *            entidade da interação do relatório de prevenção a ser persistida
     * @param targetRepository
     *            repositório de dados da interação do relatório de prevenção
     * @param alteracao
     *            tipo da alteração/criação no objeto
     * @return {@link Response}
     * @see #createInterationObject(Long, AbstractEntity, GenericRepository)
     */
    private <E extends AbstractEntity<E>, R extends GenericRepository<E, Long>> Response<RelatorioPrevencao> persistInterationObject(
            final Long relPrevID, final E entity, final R targetRepository, final TipoAlteracao alteracao) {
        final String className = entity.getClass().getName();
        final String partialLogMessage = alteracao.getDescricao() + " de " + className + " para relprev de id " + relPrevID;

        Response<RelatorioPrevencao> response;
        getLogger().debug("consultando relprev de id " + relPrevID + " para " + alteracao.getDescricao() + " de " + className);
        final RelatorioPrevencao relprev = getRepository().findOne(relPrevID);
        if (relprev != null) {
            try {
                final String property = Introspector.decapitalize(entity.getClass().getSimpleName());
                // preenche o relprev com a entity para o retorno, para não consultar novamente
                ReflectionUtil.setField(relprev, property, entity);
                ReflectionUtil.setField(entity, "relPrev", relprev);
                getLogger().debug(alteracao.getDescricao() + " de " + className + " para relprev de id " + relPrevID);

                E persistedEntity;
                String responseMessage;
                if (alteracao.equals(TipoAlteracao.CREATE)) {
                    persistedEntity = targetRepository.save(entity);
                    afterCreate(persistedEntity);
                    responseMessage = ResponseMessages.CREATE_MESSAGE;
                } else if (alteracao.equals(TipoAlteracao.UPDATE)) {
                    persistedEntity = targetRepository.save(entity);
                    afterUpdate(persistedEntity);
                    responseMessage = ResponseMessages.UPDATE_MESSAGE;
                } else {
                    beforeDelete(entity);
                    targetRepository.delete(entity);
                    responseMessage = ResponseMessages.DELETE_MESSAGE;
                }
                response = new ResponseBuilder<RelatorioPrevencao>().success(true).data(relprev).message(responseMessage)
                        .status(HttpStatus.OK).build();
                getLogger().debug("sucesso na " + partialLogMessage);
            } catch (final Exception e) {
                final String message = ExceptionUtils.getRootCauseMessage(e);
                response = new ResponseBuilder<RelatorioPrevencao>().success(false).message(message).status(HttpStatus.BAD_REQUEST).build();
                getLogger().error("erro na " + partialLogMessage, e);
            }
        } else {
            final String message = String.format("RelPrev de %s não encontrato para %s de %s.", relPrevID, alteracao.getDescricao(),
                    className);
            getLogger().debug(message);
            response = new ResponseBuilder<RelatorioPrevencao>().success(true).message(message).status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
