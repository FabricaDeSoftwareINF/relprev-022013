package br.ufg.inf.es.relprev.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.ufg.inf.es.relprev.client.dominio.ObjetoDeDominio;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

@Resource
public class RsvController extends ControllerPadrao<ObjetoDeDominio> {

    public RsvController(
    		final Result result,
    		final ResultadoServico resultadoServico) {
    	super(result, resultadoServico);
    }

    @Get("/rsv")
    public void rsv() {
    }

    public void novoRsv() {
    }

	@Override
	protected Class<ObjetoDeDominio> obtenhaTipo() {
		return ObjetoDeDominio.class;
	}

}
