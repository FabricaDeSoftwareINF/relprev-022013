package br.ufg.inf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufg.inf.model.Relator;
import br.ufg.inf.repository.RelatorRepository;
import br.ufg.inf.service.support.GenericWebService;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços para os Relatores de Relprev.
 * 
 * @created 05/11/2013
 * @author Danilo Guimarães J. Lemes - <a
 *         href="mailto:danilo.seusaraiva@gmail.com">danilo.seusaraiva@gmail.com</a>
 */
@Controller
@RequestMapping(value = WebServicesURL.URL_RELATOR)
public class RelatorWebService extends GenericWebService<Relator, RelatorRepository> {

    @Autowired
    private RelatorRepository repository;
    
    @Override
    public RelatorRepository getRepository() {
        return this.repository;
    }

}
