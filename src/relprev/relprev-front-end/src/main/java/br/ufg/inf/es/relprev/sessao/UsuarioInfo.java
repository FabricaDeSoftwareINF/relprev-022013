package br.ufg.inf.es.relprev.sessao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioInfo {
	private String usuario;
	
	public void login(String usuario){
		this.usuario = usuario;
	}
	
	public String getNome() {
	    return usuario;
	  }
	  
	  public boolean isLogado() {
	    return usuario != null;
	  }
	  
	  public void logout() {
		    this.usuario = null;
	  }
}
