package br.ufg.inf.es.relprev.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufg.inf.es.relprev.client.dominio.EloSipaer;
import br.ufg.inf.es.relprev.client.dominio.Encaminhamento;
import br.ufg.inf.es.relprev.client.dominio.Relator;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

@Resource
public class ImpressaoController {

	private final Result result;

	public ImpressaoController(final Result result) {
		this.result = result;
	}

	@Path("/impressao")
	public List<RelatorioPrevencao> inicio()  {
		List<RelatorioPrevencao> relatorios;
		  try { 
			  relatorios = new RelatorioPrevencao().list();
			  
		  } catch (RequestException e)
		  { 
			  relatorios = new ArrayList<RelatorioPrevencao>();
			  e.printStackTrace();
		  }
		  
		 return relatorios;
		 
		/*
		List<RelatorioPrevencao> relatorios = new ArrayList<RelatorioPrevencao>();
		RelatorioPrevencao relatorio = new RelatorioPrevencao();
		relatorio.id = 1;
		relatorio.setDataSituacaoPerigosa(new Date(2011, 11, 27));
		relatorio.setSituacao("Pegaram meu checklist no bolso do meu anti-g e colocaram outro...");
		Relator relator = new Relator();
		relator.setNome("Cap. José");
		relatorio.setRelator(relator);
		relatorios.add(relatorio);
		relatorio = new RelatorioPrevencao();
		relatorio.id = 2;
		relatorio.setDataSituacaoPerigosa(new Date(2012, 01, 01));		
		relatorio.setSituacao("Objeto estranho encontrado no chão dos hangaretes");
		relator = new Relator();		
		relator.setNome("3s Pagan");
		relatorio.setRelator(relator);
		relatorios.add(relatorio);
		
		relatorio = new RelatorioPrevencao();
		relatorio.id = 3;
		relatorio.setDataSituacaoPerigosa(new Date(2012, 0, 05));
		relatorio.setSituacao("Objeto estranho encontrado na caixa de partida da nacele do 1p");
		relator = new Relator();
		relator.setNome("3s Gilbert");
		relatorio.setRelator(relator);
		relatorios.add(relatorio);
		return relatorios;*/
	}
}
