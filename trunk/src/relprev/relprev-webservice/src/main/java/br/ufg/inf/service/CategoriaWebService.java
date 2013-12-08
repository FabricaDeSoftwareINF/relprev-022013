package br.ufg.inf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufg.inf.model.Categoria;
import br.ufg.inf.repository.CategoriaRepository;
import br.ufg.inf.repository.support.LogRepository;
import br.ufg.inf.service.support.GenericWebService;
import br.ufg.inf.service.support.WebServicesURL;

/**
 * Serviços para a {@link Categoria}
 * 
 * @created 06/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see GenericWebService
 */
@Controller
@RequestMapping(value = WebServicesURL.URL_CATEGORIA)
public class CategoriaWebService extends GenericWebService<Categoria, CategoriaRepository> {

    @Autowired
    public CategoriaWebService(final CategoriaRepository repository, final LogRepository logRepository) {
        super(repository, logRepository);
    }

}
