package br.ufg.inf.es.relprev.relatorios;

/**
 * Classe que representa a fonte de dados do relatório de resposta ao relator.
 * @author Ulysses
 *
 */
public class FonteDeDadosRespostaAoRelator {

	private String dataDaResposta;
	
	public String getDataDaResposta() {
		return dataDaResposta;
	}

	public void setDataDaResposta(String dataDaResposta) {
		this.dataDaResposta = dataDaResposta;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getNumeroDoRelprev() {
		return numeroDoRelprev;
	}

	public void setNumeroDoRelprev(String numeroDoRelprev) {
		this.numeroDoRelprev = numeroDoRelprev;
	}

	public String getSiglaDaOrganizacaoDoSipaer() {
		return siglaDaOrganizacaoDoSipaer;
	}

	public void setSiglaDaOrganizacaoDoSipaer(String siglaDaOrganizacaoDoSipaer) {
		this.siglaDaOrganizacaoDoSipaer = siglaDaOrganizacaoDoSipaer;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricaoDoRelprev() {
		return descricaoDoRelprev;
	}

	public void setDescricaoDoRelprev(String descricaoDoRelprev) {
		this.descricaoDoRelprev = descricaoDoRelprev;
	}

	public String getDescricaoDaResposta() {
		return descricaoDaResposta;
	}

	public void setDescricaoDaResposta(String descricaoDaResposta) {
		this.descricaoDaResposta = descricaoDaResposta;
	}

	public String getNomeDoUsuario() {
		return nomeDoUsuario;
	}

	public void setNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}

	public String getFuncaoDoUsuario() {
		return funcaoDoUsuario;
	}

	public void setFuncaoDoUsuario(String funcaoDoUsuario) {
		this.funcaoDoUsuario = funcaoDoUsuario;
	}

	public String getTelefoneFixoDoUsuario() {
		return telefoneFixoDoUsuario;
	}

	public void setTelefoneFixoDoUsuario(String telefoneFixoDoUsuario) {
		this.telefoneFixoDoUsuario = telefoneFixoDoUsuario;
	}

	public String getEmailDoUsuario() {
		return emailDoUsuario;
	}

	public void setEmailDoUsuario(String emailDoUsuario) {
		this.emailDoUsuario = emailDoUsuario;
	}

	public String getSecaoDoUsuario() {
		return secaoDoUsuario;
	}

	public void setSecaoDoUsuario(String secaoDoUsuario) {
		this.secaoDoUsuario = secaoDoUsuario;
	}

	private String remetente;
	
	private String destinatario;
	
	private String numeroDoRelprev;
	
	private String siglaDaOrganizacaoDoSipaer;
	
	private int ano;
	
	private String descricaoDoRelprev;
	
	private String descricaoDaResposta;
	
	private String nomeDoUsuario;
	
	private String funcaoDoUsuario;
	
	private String telefoneFixoDoUsuario;
	
	private String emailDoUsuario;
	
	private String secaoDoUsuario;
	
	public FonteDeDadosRespostaAoRelator(String dataDaResposta, String remetente, String destinatario, String numeroDoRelprev, String siglaDaOrganizacaoDoSipaer,
			int ano, String descricaoDoRelprev, String descricaoDaResposta, String nomeDoUsuario, String funcaoDoUsuario, String telefoneFixoDoUsuario,
			String emailDoUsuario, String secaoDoUsuario)
	{
		setDataDaResposta(dataDaResposta);
		setRemetente(remetente);
		setDestinatario(destinatario);
		setNumeroDoRelprev(numeroDoRelprev);
		setSiglaDaOrganizacaoDoSipaer(siglaDaOrganizacaoDoSipaer);
		setAno(ano);
		setDescricaoDoRelprev(descricaoDoRelprev);
		setDescricaoDaResposta(descricaoDaResposta);
		setNomeDoUsuario(nomeDoUsuario);
		setFuncaoDoUsuario(funcaoDoUsuario);
		setTelefoneFixoDoUsuario(telefoneFixoDoUsuario);
		setEmailDoUsuario(emailDoUsuario);
		setSecaoDoUsuario(secaoDoUsuario);
	}

}
