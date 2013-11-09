package br.ufg.inf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufg.inf.model.EloSipaer;
import br.ufg.inf.repository.EloSipaerRepository;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços para o Elo SIPAER
 * 
 * @created 07/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Controller
@RequestMapping(value = WebServicesURL.URL_ELOSIPAER)
public class EloSipaerWebService extends GenericWebService<EloSipaer, EloSipaerRepository> {

    @Autowired
    private EloSipaerRepository repository;

    @Override
    public EloSipaerRepository getRepository() {
        return this.repository;
    }

}
