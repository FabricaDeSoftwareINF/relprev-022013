package br.com.ufg.inf.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufg.inf.es.relprev.client.dominio.Relprev;

@Resource
public class RelatorioController {

	private final Result result;

	public RelatorioController(final Result result) {
		this.result = result;
	}

	public void relatorio() {}

	public void salvar(final Relprev relprev) {
		relprev.save();
		this.gerarLog(relprev);
		this.result.redirectTo(RelatorioController.class).relatorio();
	}

	// Remover este método após conclusão da classe.
	private void gerarLog(final Relprev relprev) {
		final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		logger.log(Level.OFF, "Local: " + relprev.getLocal());
		logger.info("Situação: " + relprev.getSituacao());
		logger.info("Pessoal envolvido: " + relprev.getPessoalEnvolvido());
		if (relprev.getRelator() != null) {
			logger.info("Nome do relator: " + relprev.getRelator().getNome());
			logger.info("Contato do relator: " + relprev.getRelator().getContato());
		}
	}
}
