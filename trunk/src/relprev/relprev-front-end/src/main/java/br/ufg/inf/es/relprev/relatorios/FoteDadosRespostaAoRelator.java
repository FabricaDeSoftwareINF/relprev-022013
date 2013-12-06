package br.ufg.inf.es.relprev.relatorios;

import java.util.Iterator;
import java.util.Vector;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * Classe que representa a fonte de dados do relatório de resposta ao relator.
 * @author Ulysses
 *
 */
public class FoteDadosRespostaAoRelator implements JRDataSource {

	private Iterator<DadosRespostaAoRelator> iterator;
	private DadosRespostaAoRelator cursor;
	
	
	public FoteDadosRespostaAoRelator(Vector<DadosRespostaAoRelator> dadosRespostaAoRelator) {
		super();
		
		iterator = dadosRespostaAoRelator.iterator();
	}
	
	@Override
	public Object getFieldValue(JRField campo) throws JRException {
		DadosRespostaAoRelator dadosRespostaAoRelator = cursor;
		
		if (campo.getName().equals("DATADARESPOSTA")) {
			return dadosRespostaAoRelator.getDataDaResposta();
		}
		
		if (campo.getName().equals("REMETENTE")) {
			return dadosRespostaAoRelator.getRemetente();
		}
		
		if (campo.getName().equals("DESTINATARIO")) {
			return dadosRespostaAoRelator.getDestinatario();
		}
		
		if (campo.getName().equals("NUMERODORELPREV")) {
			return dadosRespostaAoRelator.getNumeroDoRelprev();
		}
		
		if (campo.getName().equals("SIGLADAORGANIZACAODOSIPAER")) {
			return dadosRespostaAoRelator.getSiglaDaOrganizacaoDoSipaer();
		}
		
		if (campo.getName().equals("ANO")) {
			return dadosRespostaAoRelator.getAno();
		}
		
		if (campo.getName().equals("DESCRICAODORELPREV")) {
			return dadosRespostaAoRelator.getDescricaoDoRelprev();
		}
		
		if (campo.getName().equals("NOMEDOUSUARIO")) {
			return dadosRespostaAoRelator.getNomeDoUsuario();
		}
		
		if (campo.getName().equals("FUNCAODOUSUARIO")) {
			return dadosRespostaAoRelator.getFuncaoDoUsuario();
		}
		
		if (campo.getName().equals("TELEFONEFIXODOUSUARIO")) {
			return dadosRespostaAoRelator.getTelefoneFixoDoUsuario();
		}
		
		if (campo.getName().equals("EMAILDOUSUARIO")) {
			return dadosRespostaAoRelator.getEmailDoUsuario();
		}
		
		if (campo.getName().equals("SECAODOUSUARIO")) {
			return dadosRespostaAoRelator.getSecaoDoUsuario();
		}
		
		return null;
	}

	@Override
	public boolean next() throws JRException {
		boolean retorno = iterator.hasNext();
		
		if(retorno){
			cursor = iterator.next();
		}
		
		return retorno;
	}

	

}
