package br.ufg.inf.es.relprev.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.ufg.inf.es.relprev.client.dominio.Relprev;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

@Resource
public class RelatorioController extends ControllerPadrao<Relprev> {

	private final Logger logger;
	private final Result result;

	public RelatorioController(final Result result, final ResultadoServico resultado) {
		super(result, resultado);
		this.result = result;
		this.logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
	}
	
	@Get("/relatorio/inicio") 
	public void relatorioCompleto() {}
	
	@Path("/relatorio/relatorio")
	public void relatorio() {}

	@Path("/relatorio/dadosgerais")
	public void dadosGerais() {}
	
	//TODO: Remover este método após conclusão da classe.
	private void gerarLog(final Relprev relprev, final List<UploadedFile> files){
		logger.log(Level.OFF, "Local: " + relprev.getLocal());
		logger.info("Situação: " + relprev.getSituacao());
		logger.info("Pessoal envolvido: " + relprev.getPessoalEnvolvido());
		if(relprev.getRelator() != null){
			logger.info("Nome do relator: " + relprev.getRelator().getNome());
			logger.info("Telefone do relator: " + relprev.getRelator().getTelefone());
			logger.info("Email do relator: " + relprev.getRelator().getEmail());
		}
		
		if(files!= null && files.size() > 0){
			logger.info(files.size() +"");
			logger.info(files.get(0)+"");
		}
	}

	@Override
	protected Class<Relprev> obtenhaTipo() {
		return Relprev.class;
	}
}
