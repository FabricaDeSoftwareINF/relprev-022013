package br.ufg.inf.es.relprev.controller;

import java.util.List;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

public abstract class ControllerPadrao<T>  {
	
	protected final Result result;
	protected final Validator validator;
	
	protected ControllerPadrao(final Result result, final Validator validator){
		this.result = result;
		this.validator = validator;
		
	}
}
