package br.ufg.inf.es.relprev.controller;

import java.util.List;
import java.util.logging.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.ufg.inf.es.relprev.client.dominio.ObjetoDeDominio;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

public abstract class ControllerPadrao<T extends ObjetoDeDominio>  {
	protected final Result result;
	protected final ResultadoServico resultadoServico;
	
	protected ControllerPadrao(final Result result, final ResultadoServico resultadoServico){
		this.result = result;
		this.resultadoServico = resultadoServico;		
	}
	
	@Get
	@SuppressWarnings("unchecked")
	public void lista(){
		Logger log = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		List<T> lista;
		try {
			lista = obtenhaTipo().newInstance().list();
			resultadoServico.setObjeto(lista);
			resultadoServico.setSucesso(true);			
		} catch (Throwable e) {
			resultadoServico.setSucesso(false);
			resultadoServico.setMensagem(e.getMessage() + "  -  "+ obtenhaTipo());
		}
		log.info(resultadoServico.getMensagem());
		result.use(Results.json()).from(resultadoServico,"resultado").serialize();
	}
	
	@SuppressWarnings("unchecked")
	public void get(Integer id){
		T objeto = null;
		try {
			objeto = (T) obtenhaTipo().newInstance().get(id);
			resultadoServico.setObjeto(objeto);
			resultadoServico.setSucesso(true);
		} catch (Throwable e) {
			resultadoServico.setSucesso(false);
			resultadoServico.setMensagem(e.getMessage());
		}
		
		result.use(Results.json()).from(resultadoServico,"resultado").serialize();
	}
	
	public void save(T t){
		ResultadoServico resultado = executeSave(t);
		
		result.use(Results.json()).from(resultado,"resultado").serialize();;
	}
	
	public void delete(T t){
		ResultadoServico resultado = executeDelete(t);
		
		result.use(Results.json()).from(resultado,"resultado").serialize();;
	}
	
	protected ResultadoServico executeDelete(T t){
		try{
			t.delete();
			resultadoServico.setSucesso(true);
		} catch (Throwable e) {
			resultadoServico.setSucesso(false);
			resultadoServico.setMensagem(e.getMessage());
		}
		
		return resultadoServico;
	}
	
	protected ResultadoServico executeSave(T t){
		try{
			t.save();
			resultadoServico.setSucesso(true);
		} catch (Throwable e) {
			resultadoServico.setSucesso(false);
			resultadoServico.setMensagem(e.getMessage());
		}
		
		return resultadoServico;
	}
	
	protected abstract Class<T> obtenhaTipo();
}
