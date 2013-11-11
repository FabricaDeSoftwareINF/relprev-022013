package br.ufg.inf.es.relprev.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class RsvController {

    private final Result result;

    public RsvController(final Result result) {
        this.result = result;
    }

    @Get("/rsv")
    public void rsv() {
    }

    public void novoRsv() {
    }
}
