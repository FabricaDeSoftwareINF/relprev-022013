package br.ufg.inf.es.relprev.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

@Resource
public class RsvController extends ControllerPadrao<Object> {

    public RsvController(final Result result, final Validator validator) {
    	super(result, validator);
    }

    @Get("/rsv")
    public void rsv() {
    }

    public void novoRsv() {
    }

}
