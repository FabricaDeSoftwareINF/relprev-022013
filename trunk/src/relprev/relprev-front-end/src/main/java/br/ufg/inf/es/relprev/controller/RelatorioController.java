package br.ufg.inf.es.relprev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.view.Results;
import br.ufg.inf.es.relprev.annotation.NaoAutenticado;
import br.ufg.inf.es.relprev.client.dominio.Relprev;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

@Resource
public class RelatorioController {

	private final Logger logger;
	private final Result result;

	public RelatorioController(final Result result) {
		this.result = result;
		this.logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
	}

	@Path("/relatorio/inicio")
	public void relatorio() {}
	
	public void template() {}
	
	@Post("/relatorio")
	public void salvar(final Relprev relprev, final List<UploadedFile> files) {
		try {
			relprev.save();
			this.gerarLog(relprev, files);
			this.result.redirectTo(RelatorioController.class).relatorio();
		} catch (RequestException e) {
			logger.info(e.getMessage());
		}		
	}
	
	@Get("/relatorio")
	public List<Relprev> lista(){
		try {
			return Relprev.list();
		} catch (RequestException e) {
			logger.info(e.getMessage());
			return new ArrayList<Relprev>();
		}		
	}
	
	@NaoAutenticado
	@Get("/teste")
	public void teste(){
		String teste = "teste";
		result.use(Results.json()).from(teste, "teste").serialize();
	}
	
	//Remover este método após conclusão da classe.
	private void gerarLog(final Relprev relprev, final List<UploadedFile> files){
		logger.log(Level.OFF, "Local: " + relprev.getLocal());
		logger.info("Situação: " + relprev.getSituacoes());
		logger.info("Pessoal envolvido: " + relprev.getPessoalEnvolvido());
		if(relprev.getRelator() != null){
			logger.info("Nome do relator: " + relprev.getRelator().getNome());
			logger.info("Contato do relator: " + relprev.getRelator().getContato());
		}
		
		if(files!= null && files.size() > 0){
			logger.info(files.size() +"");
			logger.info(files.get(0)+"");
		}
	}
}
