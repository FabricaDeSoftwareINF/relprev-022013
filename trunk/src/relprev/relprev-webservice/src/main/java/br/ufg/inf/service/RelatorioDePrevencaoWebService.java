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
import br.ufg.inf.service.support.GenericWebService;
import br.ufg.inf.service.support.ReponseMessages;
import br.ufg.inf.service.support.ResponseEntity;
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
    private RelatorioDePrevencaoRepository repository;

    @Override
    public RelatorioDePrevencaoRepository getRepository() {
        return this.repository;
    }

    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_RELPREV_FIND_LOCAL + "/{local}", method = {GET, POST}, produces = APPLICATION_JSON)
    public ResponseEntity<RelPrev> findRelPrevByLocal(@PathVariable("local") final String local) {
        ResponseEntity<RelPrev> response = new ResponseEntity<RelPrev>();
        this.getLogger().debug("listando relatórios de prevenção por local '" + local + "'");
        try {
            final List<RelPrev> dataList = this.getRepository().findByLocalIgnoreCase(local);
            response = response.success(true).data(dataList).message(ReponseMessages.LIST_MESSAGE).status(HttpStatus.OK);
            this.getLogger().debug("sucesso ao listar relatórios de prevenção por local '" + local + "'");
        } catch (final Exception e) {
            response = response.success(false).message(e.getMessage()).status(HttpStatus.BAD_REQUEST);
            this.getLogger().error("erro ao listar relatórios de prevenção por local '" + local + "'");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = WebServicesURL.URL_RELPREV_FIND_DESCRICAO + "/{descricao}",
        method = {GET, POST},
        produces = APPLICATION_JSON)
    public ResponseEntity<RelPrev> findRelPrevByDescricao(@PathVariable("descricao") final String descricao) {
        ResponseEntity<RelPrev> response = new ResponseEntity<RelPrev>();
        this.getLogger().debug("listando relatórios de prevenção por descrição '" + descricao + "'");
        try {
            final List<RelPrev> dataList = this.getRepository().findByDescricaoSituacaoPerigosaContainsIgnoreCase(descricao);
            response = response.success(true).data(dataList).message(ReponseMessages.LIST_MESSAGE).status(HttpStatus.OK);
            this.getLogger().debug("sucesso ao listar relatórios de prevenção por descrição '" + descricao + "'");
        } catch (final Exception e) {
            response = response.success(false).message(e.getMessage()).status(HttpStatus.BAD_REQUEST);
            this.getLogger().error("erro ao listar relatórios de prevenção por descrição '" + descricao + "'");
        }
        return response;
    }

}
