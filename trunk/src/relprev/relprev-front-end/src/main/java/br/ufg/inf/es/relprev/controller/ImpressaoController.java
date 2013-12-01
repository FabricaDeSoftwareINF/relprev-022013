package br.ufg.inf.es.relprev.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ImpressaoController {

	private final Result result;

	public ImpressaoController(final Result result) {
		this.result = result;
	}

	@Path("/impressao")
	public void inicio() {
	}
}
