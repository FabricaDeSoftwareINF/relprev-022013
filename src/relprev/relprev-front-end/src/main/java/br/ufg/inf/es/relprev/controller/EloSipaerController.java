package br.ufg.inf.es.relprev.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.ufg.inf.es.relprev.client.dominio.EloSipaer;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

public class EloSipaerController extends ControllerPadrao<EloSipaer> {

	protected EloSipaerController(Result result, Validator validator) {
		super(result, validator);
		// TODO Auto-generated constructor stub
	}

	@Get("/elosipaer/lista")
	public void lista(){
		List<EloSipaer> lista;
		try {
			lista = new EloSipaer().list();
			result.use(Results.json()).from(lista,"elosipaer");
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
