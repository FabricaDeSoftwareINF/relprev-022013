package br.ufg.inf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufg.inf.model.Situacao;
import br.ufg.inf.repository.SituacaoRepository;
import br.ufg.inf.service.support.GenericWebService;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços para a {@link Situacao}
 * 
 * @created 10/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericWebService
 */
@Controller
@RequestMapping(value = WebServicesURL.URL_SITUACAO)
public class SituacaoWebService extends GenericWebService<Situacao, SituacaoRepository> {

    @Autowired
    private SituacaoRepository repository;

    @Override
    public SituacaoRepository getRepository() {
        return this.repository;
    }

}
