package br.com.ufg.inf.relprev.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class InicioController {

	private final Result result;

	public InicioController(final Result result) {
		this.result = result;
	}
	
	public void template() {}
}
