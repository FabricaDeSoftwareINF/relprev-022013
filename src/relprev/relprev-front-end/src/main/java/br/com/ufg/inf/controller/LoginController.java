package br.com.ufg.inf.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LoginController {
	private final Result result;

	public LoginController(final Result result) {
		this.result = result;
	}
	
	public void login() {}
}
