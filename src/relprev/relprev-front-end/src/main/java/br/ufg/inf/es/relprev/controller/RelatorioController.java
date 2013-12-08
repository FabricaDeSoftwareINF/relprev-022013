package br.ufg.inf.es.relprev.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.ufg.inf.es.relprev.annotation.NaoAutenticado;
import br.ufg.inf.es.relprev.cdn.CDN;
import br.ufg.inf.es.relprev.client.dominio.Anexo;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

@Resource
public class RelatorioController extends GenericController<RelatorioPrevencao> {

	private final Logger logger;
	private final Result result;
	private int RISCO_PRIMEIRO_NIVEL[] = { 1, 2, 3, 4, 5 };
	private String RISCO_SEGUNDO_NIVEL[] = { "A", "B", "C", "D", "E" };

	public RelatorioController(final Result result,
			final ResultadoServico resultado) {
		super(result, resultado);
		this.result = result;
		this.logger = Logger
				.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
	}

	@NaoAutenticado
	public void saveWithFiles(RelatorioPrevencao relatorioPrevencao,
			List<UploadedFile> files) throws FileNotFoundException {
		if (files == null) {
			files = new ArrayList<UploadedFile>();
		}
		relatorioPrevencao.setAnexos(CDN.save(files));
		super.save(relatorioPrevencao); // To change body of overridden methods
										// use File | Settings | File Templates.
	}

	@NaoAutenticado
	@Get("/relatorio/inicio")
	public void relatorioCompleto() {
	}

	@Path("/relatorio/relatorio")
	public void relatorio() {
	}

	@Path("/relatorio/dadosgerais/{id}")
	public RelatorioPrevencao dadosGerais(Integer id) {
		result.include("riscoPrimeiroNivel", RISCO_PRIMEIRO_NIVEL);
		result.include("riscoSegundoNivel", RISCO_SEGUNDO_NIVEL);
		try {
			return (RelatorioPrevencao) new RelatorioPrevencao().get(id);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RelatorioPrevencao();
	}

	public List<RelatorioPrevencao> ultimosRelatorios() {
		List<RelatorioPrevencao> lista = new ArrayList<RelatorioPrevencao>();
		try {
			lista = new RelatorioPrevencao().list();
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	// Remover este método após conclusão da classe.
	protected void gerarLog(final RelatorioPrevencao relprev) {
		logger.log(Level.OFF, "Local: " + relprev.getLocal());
		logger.info("Situação: " + relprev.getSituacao());
		logger.info("Pessoal envolvido: " + relprev.getEnvolvidos());

		if (relprev.getRelator() != null) {
			logger.info("Nome do relator: " + relprev.getRelator().getNome());
			logger.info("Telefone do relator: "
					+ relprev.getRelator().getTelefoneCelular());
			logger.info("Email do relator: " + relprev.getRelator().getEmail());
		}

		if (relprev.getAnexos() != null) {
			for (Anexo anexo : relprev.getAnexos()) {
				logger.info("Nome do anexo: " + anexo.getPathAnexo());
				logger.info("Mimetype do anexo: " + anexo.getMimeType());
			}
		}

		/*
		 * if(files!= null && files.size() > 0){ logger.info(files.size() +"");
		 * logger.info(files.get(0)+""); }
		 */
	}

	@Override
	protected Class<RelatorioPrevencao> obtenhaTipo() {
		return RelatorioPrevencao.class;
	}
}
