package br.com.ufg.inf.relprev.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.ufg.inf.relprev.annotation.NaoAutenticado;
import br.com.ufg.inf.relprev.controller.LoginController;
import br.com.ufg.inf.relprev.sessao.UsuarioInfo;

@Intercepts
public class LoginInterceptor implements Interceptor {
	
	private final UsuarioInfo usuarioInfo;
	private final Result result;
	
	public LoginInterceptor(UsuarioInfo usuarioInfo, Result result){
		this.result = result;
		this.usuarioInfo = usuarioInfo;
	}	
	
	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.redirectTo(LoginController.class).login();
		
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		// TODO Auto-generated method stub
		return !usuarioInfo.isLogado() && !method.containsAnnotation(NaoAutenticado.class);
	}

}
