package br.ufg.inf.es.relprev.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufg.inf.es.relprev.client.dominio.EloSipaer;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

@Resource
public class EloSipaerController extends ControllerPadrao<EloSipaer> {

	protected EloSipaerController(Result result, ResultadoServico resultadoServico) {
		super(result, resultadoServico);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<EloSipaer> obtenhaTipo() {
		return EloSipaer.class;
	}
}
