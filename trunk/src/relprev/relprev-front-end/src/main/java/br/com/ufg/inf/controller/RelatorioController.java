package br.com.ufg.inf.controller;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.jdt.internal.compiler.parser.diagnose.LexStream;

import test.java.br.ufg.inf.es.relprev.client.dominio.Relprev;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class RelatorioController {
	
	private Result result;
	
	public RelatorioController(Result result){		
		this.result = result;
	}
	
	public void relatorio(){		
	}	
	
	public void salvar(Relprev relprev){
		boolean salvo = relprev.save();		
		gerarLog(relprev);
		result.redirectTo(RelatorioController.class).relatorio();
	}
	
	//Remover este método após conclusão da classe.
	private void gerarLog(Relprev relprev){
		Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		logger.log(Level.OFF, "Local: " + relprev.getLocal());
		logger.info("Situação: " + relprev.getSituacao());
		logger.info("Pessoal envolvido: " + relprev.getPessoalEnvolvido());
		if(relprev.getRelator() != null){
			logger.info("Nome do relator: " + relprev.getRelator().getNome());
			logger.info("Contato do relator: " + relprev.getRelator().getContato());
		}
	}
}
