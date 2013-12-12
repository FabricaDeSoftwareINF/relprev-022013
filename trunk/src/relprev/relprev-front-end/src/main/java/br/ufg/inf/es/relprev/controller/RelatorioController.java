package br.ufg.inf.es.relprev.controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.view.Results;
import br.ufg.inf.es.relprev.annotation.NaoAutenticado;
import br.ufg.inf.es.relprev.cdn.CDN;
import br.ufg.inf.es.relprev.client.dominio.AcaoRecomendada;
import br.ufg.inf.es.relprev.client.dominio.Anexo;
import br.ufg.inf.es.relprev.client.dominio.ClassificacaoRisco;
import br.ufg.inf.es.relprev.client.dominio.Encaminhamento;
import br.ufg.inf.es.relprev.client.dominio.Observacao;
import br.ufg.inf.es.relprev.client.dominio.ParecerSetor;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.dominio.Resposta;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.infraestrutura.ResultadoServico;

@Resource
public class RelatorioController extends GenericController<RelatorioPrevencao> {

	private final Logger logger;
	private Validator validator;
	private final int RISCO_PRIMEIRO_NIVEL[] = { 1, 2, 3, 4, 5 };
	private final String RISCO_SEGUNDO_NIVEL[] = { "A", "B", "C", "D", "E" };

	public RelatorioController(final Result result,
			final ResultadoServico resultado, final Validator validator) {
		super(result, resultado);
		this.validator = validator;
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
		ResultadoServico resultado = executeSave(relatorioPrevencao);
		result.include("resultado", resultado);
		validator.onErrorRedirectTo(this).relatorioCompleto();
		if(resultado.isSucesso()){
			result.forwardTo(this).relatorioCompleto();			
		} else{
			result.include(relatorioPrevencao);
			result.redirectTo(this).relatorioCompleto();			
		}
	}

	public void altereRelatorio(RelatorioPrevencao relatorioPrevencao,
			List<UploadedFile> files) throws FileNotFoundException {
		if (files == null) {
			files = new ArrayList<UploadedFile>();
		}
		relatorioPrevencao.setAnexos(CDN.save(files));
		ResultadoServico resultado = executeSave(relatorioPrevencao);
		result.include("resultado", resultado);
		validator.onErrorRedirectTo(this).dadosGerais(relatorioPrevencao.getId());		
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

	@Get
	public void realizeEncaminhamento(String remetente, String destinatario,
			String data, String descricao, int idRelatorio) {
		try {
			RelatorioPrevencao relatorio = (RelatorioPrevencao) new RelatorioPrevencao()
					.get(idRelatorio);
			Encaminhamento encaminhamento = new Encaminhamento();
			encaminhamento.setRemetente(remetente);
			encaminhamento.setDestinatario(destinatario);
			encaminhamento.setDescricao(descricao);
			encaminhamento.setData(trateData(data));
			encaminhamento.setRelPrev(relatorio);			
			relatorio.definaEncaminhamento(encaminhamento);
			result.use(Results.json())
					.from("Encaminhamento realizado com sucesso!", "resultado")
					.serialize();
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			result.use(Results.json())
					.from(e.getLocalizedMessage(), "resultado").serialize();
		}
	}

	@Get
	public void realizeParecerDoSetor(String setor, String data,
			String descricao, int idRelatorio) {
		try {
			RelatorioPrevencao relatorio = (RelatorioPrevencao) new RelatorioPrevencao()
					.get(idRelatorio);
			ParecerSetor parecerSetor = new ParecerSetor();
			parecerSetor.setDescricao(descricao);
			parecerSetor.setData(trateData(data));
			parecerSetor.setRelPrev(relatorio);
			relatorio.definaParecerSetor(parecerSetor);
			result.use(Results.json())
					.from("Parecer do setor registrado com sucesso!",
							"resultado").serialize();
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			result.use(Results.json())
					.from(e.getLocalizedMessage(), "resultado").serialize();
		}
	}

	@Get
	public void registreResposta(String remetente, String destinatario,
			String data, String descricao, int idRelatorio) {
		try {
			RelatorioPrevencao relatorio = (RelatorioPrevencao) new RelatorioPrevencao()
					.get(idRelatorio);
			Resposta resposta = new Resposta();
			resposta.setRemetente(remetente);
			resposta.setDestinatario(destinatario);
			resposta.setData(trateData(data));
			resposta.setDescricao(descricao);
			resposta.setRelPrev(relatorio);
			relatorio.definaResposta(resposta);
			result.use(Results.json())
					.from("Resposta realizada com sucesso!", "resultado")
					.serialize();
			return;
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			result.use(Results.json())
					.from(e.getLocalizedMessage(), "resultado").serialize();
		}
	}

	@Get
	public void registreAcaoRecomendada(String remetente, String destinatario,
			String data, String descricao, int idRelatorio) {
		try {
			RelatorioPrevencao relatorio = (RelatorioPrevencao) new RelatorioPrevencao()
					.get(idRelatorio);
			AcaoRecomendada acaoRecomendada = new AcaoRecomendada();
			acaoRecomendada.setRemetente(remetente);
			acaoRecomendada.setDestinatario(destinatario);
			acaoRecomendada.setData(trateData(data));
			acaoRecomendada.setDescricao(descricao);
			acaoRecomendada.setRelPrev(relatorio);
			relatorio.definaAcaoRecomendada(acaoRecomendada);
			result.use(Results.json())
					.from("A\u00e7\u00e3o recomendada registrada com sucesso!",
							"resultado").serialize();
			return;
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			result.use(Results.json())
					.from(e.getLocalizedMessage(), "resultado").serialize();
		}
	}

	@Get
	public void registreObservacoes(String observacoes, int idRelatorio) {
		try {
			RelatorioPrevencao relatorio = (RelatorioPrevencao) new RelatorioPrevencao()
					.get(idRelatorio);
			Observacao observacao = new Observacao();			
			observacao.setDescricao(observacoes);
			observacao.setRelPrev(relatorio);
			relatorio.definaObservacao(observacao);
			result.use(Results.json())
					.from("Observa\u00e7\u00e3o registrada com sucesso!",
							"resultado").serialize();
			return;
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			result.use(Results.json())
					.from(e.getLocalizedMessage(), "resultado").serialize();
		}
	}

	@Get
	public void realizeAvaliacao(String avaliacao, int idRelatorio) {
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
			result.use(Results.json())
					.from("Avalia\u00e7\u00e3o realizada com sucesso!",
							"resultado").serialize();
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			result.use(Results.json())
					.from(e.getLocalizedMessage(), "resultado").serialize();
		}
	}

	@Get
	public void realizeReavaliacao(String reavaliacao, int idRelatorio) {
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

			result.use(Results.json())
					.from("Reavalia\u00e7\u00e3o realizada com sucesso!",
							"resultado").serialize();
		} catch (RequestException e) {
			logger.info(e.getLocalizedMessage());
			result.use(Results.json())
					.from(e.getLocalizedMessage(), "resultado").serialize();
		}
	}

	private Date trateData(String data) {
		try {
			if (data != null && !data.equals("") && data.contains("/")) {
				String[] dataFormatada = data.split("/");
				if (dataFormatada.length == 3) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					return sdf.parse(data);
				}
			}
		} catch (ParseException e) {
			logger.info(e.getLocalizedMessage());
		}

		return null;
	}

	@Override
	protected void gerarLog(RelatorioPrevencao t) {
	}
}
