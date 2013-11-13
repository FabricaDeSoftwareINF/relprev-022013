package br.ufg.inf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufg.inf.model.Taxonomia;
import br.ufg.inf.repository.TaxonomiaRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.GenericWebService;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços para a {@link Taxonomia}
 * 
 * @created 09/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericWebService
 */
@Controller
@RequestMapping(value = WebServicesURL.URL_TAXONOMIA)
public class TaxonomiaWebService extends GenericWebService<Taxonomia, TaxonomiaRepository> {

    @Autowired
    public TaxonomiaWebService(final TaxonomiaRepository repository, final LogRepository logRepository) {
        super(repository, logRepository);
    }

}
