package br.ufg.inf.es.relprev.controller;

import java.io.FileNotFoundException;
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
import br.ufg.inf.es.relprev.annotation.NaoAutenticado;
import br.ufg.inf.es.relprev.cdn.CDN;
import br.ufg.inf.es.relprev.client.dominio.Anexo;
import br.ufg.inf.es.relprev.client.dominio.ClassificacaoRisco;
import br.ufg.inf.es.relprev.client.dominio.Encaminhamento;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

@Resource
public class RelatorioController extends GenericController<RelatorioPrevencao> {

	private final Logger logger;
	private final Result result;
	private final int RISCO_PRIMEIRO_NIVEL[] = { 1, 2, 3, 4, 5 };
	private final String RISCO_SEGUNDO_NIVEL[] = { "A", "B", "C", "D", "E" };

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

	@Override
	protected Class<RelatorioPrevencao> obtenhaTipo() {
		return RelatorioPrevencao.class;
	}

	@SuppressWarnings("deprecation")
	@Get
	public String realizeEncaminhamento(String remetente, String destinatario,
			String data, String descricao, int idRelatorio) {
		try {
			RelatorioPrevencao relatorio = (RelatorioPrevencao) new RelatorioPrevencao()
					.get(idRelatorio);			
			Encaminhamento encaminhamento = new Encaminhamento();
			encaminhamento.setRemetente(remetente);
			encaminhamento.setDestinatario(destinatario);
			encaminhamento.setDescricao(descricao);
			if (data != null && !data.equals("") && data.contains("/")) {
				String[] dataFormatada = data.split("/");
				if (dataFormatada.length == 3) {
					int dia = Integer.parseInt(dataFormatada[1]);
					int mes = Integer.parseInt(dataFormatada[0]) + 2;
					int ano = Integer.parseInt(dataFormatada[2]);
					encaminhamento.setData(new Date(ano, mes, dia));
				}
			}						
			relatorio.definaEncaminhamento(encaminhamento);
			return "Encaminhamento realizado com sucesso!";
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			return "Falha ao realizar o encaminhamento!";
		}
	}

	@Get
	public String realizeAvaliacao(String avaliacao, int idRelatorio) {
		try {
			ClassificacaoRisco classificacao;
			RelatorioPrevencao relatorio = (RelatorioPrevencao) new RelatorioPrevencao()
					.get(idRelatorio);
			if (relatorio.getClassificacaoRisco() == null) {
				classificacao = new ClassificacaoRisco();
			} else {
				classificacao = relatorio.getClassificacaoRisco();
			}

			classificacao.setAvaliacaoInicial(avaliacao);
			classificacao.setRelPrev(relatorio);
			relatorio.definaClassificacaoDeRisco(classificacao);
			return "Avaliação realizada com sucesso!";
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			return "Erro ao realizar avaliação!";
		}
	}

	@Get
	public String realizeReavaliacao(String reavaliacao, int idRelatorio) {
		try {
			RelatorioPrevencao relatorio = (RelatorioPrevencao) new RelatorioPrevencao()
					.get(idRelatorio);
			ClassificacaoRisco classificacao = relatorio
					.getClassificacaoRisco();
			if (classificacao != null) {
				classificacao.setAvaliacaoFinal(reavaliacao);
				classificacao.setRelPrev(relatorio);
				relatorio.definaClassificacaoDeRisco(classificacao);
			}

			return "Reavaliação realizada com sucesso!";
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			return "Erro ao realizar reavaliação!";
		}
	}

	@Override
	protected void gerarLog(RelatorioPrevencao t) {
	}
}
