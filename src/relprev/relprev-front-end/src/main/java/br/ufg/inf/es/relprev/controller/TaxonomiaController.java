package br.ufg.inf.es.relprev.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufg.inf.es.relprev.client.dominio.Taxonomia;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

@Resource
public class TaxonomiaController extends GenericController<Taxonomia> {


	protected TaxonomiaController(Result result,
			ResultadoServico resultadoServico) {
		super(result, resultadoServico);
	}

	@Path("/taxonomia")
	public void inicio(){}
	
    public void novo() {}

	@Override
	protected Class<Taxonomia> obtenhaTipo() {
		return Taxonomia.class;
	}

	@Override
	protected void gerarLog(Taxonomia t) {
		// TODO Auto-generated method stub

	}
}