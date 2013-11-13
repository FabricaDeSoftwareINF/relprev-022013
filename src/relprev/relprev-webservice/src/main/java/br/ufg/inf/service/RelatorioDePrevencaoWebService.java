package br.ufg.inf.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufg.inf.model.RelPrev;
import br.ufg.inf.repository.RelatorioDePrevencaoRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.GenericWebService;
import br.ufg.inf.service.support.ReponseMessages;
import br.ufg.inf.service.support.Response;
import br.ufg.inf.service.support.ResponseBuilder;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços para os Relatório de Prevenção ({@link RelPrev})
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericWebService
 */
@Controller
@RequestMapping(value = WebServicesURL.URL_RELPREV)
public class RelatorioDePrevencaoWebService extends GenericWebService<RelPrev, RelatorioDePrevencaoRepository> {

    @Autowired
    public RelatorioDePrevencaoWebService(final RelatorioDePrevencaoRepository repository, final LogRepository logRepository) {
        super(repository, logRepository);
    }

    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_RELPREV_FIND_LOCAL + "/{local}", method = {GET, POST}, produces = APPLICATION_JSON)
    public Response<RelPrev> findRelPrevByLocal(@PathVariable("local") final String local) {
        Response<RelPrev> response;
        getLogger().debug("listando relatórios de prevenção por local '" + local + "'");
        try {
            final List<RelPrev> dataList = getRepository().findByLocalIgnoreCase(local);
            response = new ResponseBuilder<RelPrev>().success(true).data(dataList).message(ReponseMessages.LIST_MESSAGE).status(HttpStatus.OK).build();
            getLogger().debug("sucesso ao listar relatórios de prevenção por local '" + local + "'");
        } catch (final Exception e) {
            response = new ResponseBuilder<RelPrev>().success(false).message(e.getMessage()).status(HttpStatus.BAD_REQUEST).build();
            getLogger().error("erro ao listar relatórios de prevenção por local '" + local + "'");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_RELPREV_FIND_DESCRICAO + "/{descricao}",
    method = {GET, POST},
    produces = APPLICATION_JSON)
    public Response<RelPrev> findRelPrevByDescricao(@PathVariable("descricao") final String descricao) {
        Response<RelPrev> response;
        getLogger().debug("listando relatórios de prevenção por descrição '" + descricao + "'");
        try {
            final List<RelPrev> dataList = getRepository().findByDescricaoSituacaoPerigosaContainsIgnoreCase(descricao);
            response = new ResponseBuilder<RelPrev>().success(true).data(dataList).message(ReponseMessages.LIST_MESSAGE).status(HttpStatus.OK).build();
            getLogger().debug("sucesso ao listar relatórios de prevenção por descrição '" + descricao + "'");
        } catch (final Exception e) {
            response = new ResponseBuilder<RelPrev>().success(false).message(e.getMessage()).status(HttpStatus.BAD_REQUEST).build();
            getLogger().error("erro ao listar relatórios de prevenção por descrição '" + descricao + "'");
        }
        return response;
    }

}
