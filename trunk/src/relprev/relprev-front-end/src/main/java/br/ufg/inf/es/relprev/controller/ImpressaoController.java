package br.ufg.inf.es.relprev.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

@Resource
public class ImpressaoController {

	private final Result result;

	public ImpressaoController(final Result result) {
		this.result = result;
	}

	@Path("/impressao")
	public List<RelatorioPrevencao> inicio() {
		List<RelatorioPrevencao> relatorios;
		try {
			relatorios = new RelatorioPrevencao().list();
		} catch (RequestException e) {
			relatorios = new ArrayList<RelatorioPrevencao>();
			e.printStackTrace();
		}

		return relatorios;
	}
}
