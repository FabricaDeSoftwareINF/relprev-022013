package br.ufg.inf.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.beans.Introspector;
import java.util.List;

import javax.validation.Valid;

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
        this.getLogger().debug("listando relatórios de prevenção por local '" + local + "'");
        try {
            final List<RelatorioPrevencao> dataList = this.getRepository().findByLocalIgnoreCase(local);
            response = new ResponseBuilder<RelatorioPrevencao>().success(true).data(dataList)
                    .message(String.format(ResponseMessages.LIST_MESSAGE, dataList.size())).status(HttpStatus.OK).build();
            this.getLogger().debug("sucesso ao listar relatórios de prevenção por local '" + local + "'");
        } catch (final Exception e) {
            response = new ResponseBuilder<RelatorioPrevencao>().success(false).message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("erro ao listar relatórios de prevenção por local '" + local + "'");
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
        this.getLogger().debug("listando relatórios de prevenção por descrição '" + descricao + "'");
        try {
            final List<RelatorioPrevencao> dataList = this.getRepository().findByDescricaoSituacaoPerigosaContainsIgnoreCase(
                    descricao);
            response = new ResponseBuilder<RelatorioPrevencao>().success(true).data(dataList)
                    .message(String.format(ResponseMessages.LIST_MESSAGE, dataList.size())).status(HttpStatus.OK).build();
            this.getLogger().debug("sucesso ao listar relatórios de prevenção por descrição '" + descricao + "'");
        } catch (final Exception e) {
            response = new ResponseBuilder<RelatorioPrevencao>().success(false).message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST).build();
            this.getLogger().error("erro ao listar relatórios de prevenção por descrição '" + descricao + "'");
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
        return this.persistInterationObject(id, acaoRecomendada, this.acaoRecomendadaRepository);
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
        return this.persistInterationObject(id, classificacaoRisco, this.classificacaoRiscoRepository);
    }

    /**
     * Adiciona a um relatório de prevenção um encaminhamento
     * 
     * @param id
     *            id do relprev a ter o encaminhamento incluído
     * @param encaminhamento
     *            encaminhamento a ser incluído
     * @return {@link Response}
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/encaminhamento", method = POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public Response<RelatorioPrevencao> addEncaminhamento(@PathVariable("id") final Long id,
            @Valid @RequestBody final Encaminhamento encaminhamento, final BindingResult result) {
        if (result.hasErrors()) {
            return this.buildDataInteracaoResponse(result);
        }
        return this.persistInterationObject(id, encaminhamento, this.encaminhamentoRepository);
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
        return this.persistInterationObject(id, observacao, this.observacaoRepository);
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
            return this.buildDataInteracaoResponse(result);
        }
        return this.persistInterationObject(id, parecerSetor, this.parecerSetorRepository);
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
            return this.buildDataInteracaoResponse(result);
        }
        return this.persistInterationObject(id, resposta, this.respostaRepository);
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
     * Persiste o objeto da interação com o relatório de prevenção. A interação pode ser uma das seguintes:
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
    private <E extends AbstractEntity<E>, R extends GenericRepository<E, Long>> Response<RelatorioPrevencao> persistInterationObject(
            final Long relPrevID, final E entity, final R targetRepository) {
        Response<RelatorioPrevencao> response;
        this.getLogger().debug("consultando relprev de id " + relPrevID + " para inclusão de " + entity.getClass().getName());
        final RelatorioPrevencao relprev = this.getRepository().findOne(relPrevID);
        if (relprev != null) {
            try {
                final String property = Introspector.decapitalize(entity.getClass().getSimpleName());
                // preenche o relprev com a entity para o retorno, para não consultar novamente
                ReflectionUtil.setField(relprev, property, entity);

                ReflectionUtil.setField(entity, "relPrev", relprev);
                this.getLogger().debug("incluindo " + entity.getClass().getName() + " para relprev de id " + relPrevID);
                targetRepository.save(entity);
                response = new ResponseBuilder<RelatorioPrevencao>().success(true).data(relprev)
                        .message(ResponseMessages.CREATE_MESSAGE).status(HttpStatus.OK).build();
                this.getLogger().debug("sucesso ao incluir " + entity.getClass().getName() + " para relprev de id " + relPrevID);
            } catch (final Exception e) {
                response = new ResponseBuilder<RelatorioPrevencao>().success(false).message(e.getMessage())
                        .status(HttpStatus.BAD_REQUEST).build();
                this.getLogger().error(
                        "erro ao incluir " + entity.getClass().getSimpleName() + " para o relprev de id " + relPrevID, e);
            }
        } else {
            this.getLogger().debug(
                    "relprev de id " + relPrevID + " não encontrado para inclusão de " + entity.getClass().getName());
            response = new ResponseBuilder<RelatorioPrevencao>().success(true)
                    .message(String.format(ResponseMessages.NOTFIND_UPDATE_MESSAGE, relPrevID)).status(HttpStatus.OK).build();
        }
        return response;
    }

}
