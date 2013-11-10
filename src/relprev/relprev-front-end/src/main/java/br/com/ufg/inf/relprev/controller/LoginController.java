package br.com.ufg.inf.relprev.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.ufg.inf.relprev.annotation.NaoAutenticado;
import br.com.ufg.inf.relprev.sessao.UsuarioInfo;

@Resource
public class LoginController {
	private final Result result;
	private final UsuarioInfo usuarioInfo;
	private Validator validator;

	public LoginController(final Result result, final Validator validator, final UsuarioInfo usuarioInfo) {
		this.result = result;
		this.usuarioInfo = usuarioInfo;
		this.validator = validator;
	}	
	
	@NaoAutenticado
	@Path("/")
	public void login() {}
	
	@NaoAutenticado
	@Post("/login")
	public void logar(final String usuario, final String senha){
		final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		logger.log(Level.INFO, "Usuario: " + usuario);
		logger.log(Level.INFO, "Senha: " + senha);
		
		if(!usuario.equals(senha)){
			validator.add(new ValidationMessage("Login e/ou senha inválidos", "erro"));	
		}
		
		validator.onErrorUsePageOf(LoginController.class).login();
		usuarioInfo.login(usuario);
		
		result.redirectTo(RelatorioController.class).relatorio();		
	}
	
	@Path("/logout")
	public void logout(){
		usuarioInfo.logout();
		result.redirectTo(LoginController.class).login();
	}
}
