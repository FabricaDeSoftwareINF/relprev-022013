package br.ufg.inf.es.relprev.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

@Resource
public class RelatorioController extends GenericController<RelatorioPrevencao> {

	private final Logger logger;
	private final Result result;

	public RelatorioController(final Result result, final ResultadoServico resultado) {
		super(result, resultado);
		this.result = result;
		this.logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
	}
	
	@Get("/relatorio/inicio") 
	public void relatorioCompleto() {		
	}
	
	@Path("/relatorio/relatorio")
	public void relatorio() {}

	@Path("/relatorio/dadosgerais/{id}")
	public RelatorioPrevencao dadosGerais(Integer id) {
		try {
			return (RelatorioPrevencao) new RelatorioPrevencao().get(id);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RelatorioPrevencao();
	}
	
	public List<RelatorioPrevencao> ultimosRelatorios(){
		List<RelatorioPrevencao> lista = new ArrayList<RelatorioPrevencao>();
		try {
			lista = new RelatorioPrevencao().list();
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		RelatorioPrevencao r = new RelatorioPrevencao();
		r.setLocal("minhaCasa");
		Date data = new Date(2013,11,04);
		data.setHours(8);
		data.setMinutes(20);
		r.setDataSituacaoPerigosa(data);
		r.setEnvolvidos("envolvidos");
		r.setDescricaoSituacaoPerigosa("descricao situacao");
		r.setId(1);
		lista.add(r);
		r = new RelatorioPrevencao();
		r.setLocal("minhaCasa2");
		r.setId(2);
		Date data2 = new Date(2013,12,04,8,20);
		r.setDataSituacaoPerigosa(data2);
		r.setEnvolvidos("envolvidos2");
		r.setDescricaoSituacaoPerigosa("descricao situacao2");
		
		lista.add(r);
		return lista;
	}
	
	//Remover este método após conclusão da classe.
	protected void gerarLog(final RelatorioPrevencao relprev){
		logger.log(Level.OFF, "Local: " + relprev.getLocal());
		logger.info("Situação: " + relprev.getSituacao());
		logger.info("Pessoal envolvido: " + relprev.getEnvolvidos());
		
		if(relprev.getRelator() != null){
			logger.info("Nome do relator: " + relprev.getRelator().getNome());
			logger.info("Telefone do relator: " + relprev.getRelator().getTelefoneCelular());
			logger.info("Email do relator: " + relprev.getRelator().getEmail());			
		}
		
		/*
		if(files!= null && files.size() > 0){
			logger.info(files.size() +"");
			logger.info(files.get(0)+"");
		}*/
	}

	@Override
	protected Class<RelatorioPrevencao> obtenhaTipo() {
		return RelatorioPrevencao.class;
	}
}
