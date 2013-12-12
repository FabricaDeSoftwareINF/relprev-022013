package br.ufg.inf.es.relprev.infraestrutura;

import br.com.caelum.vraptor.ioc.Component;
import br.ufg.inf.es.relprev.client.dominio.ObjetoDeDominio;

@Component
public class ResultadoServico {
	
	private boolean sucesso;
	private String mensagem;
	private Object objeto;	
	
	public boolean isSucesso() {
		return sucesso;
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Object getObjeto() {
		return objeto;
	}
	
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
	@Override
	public String toString(){
		return mensagem == null ? "" : mensagem;
	}
}
