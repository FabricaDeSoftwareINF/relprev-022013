package br.ufg.inf.es.relprev.client.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: halisson Date: 11/2/13
 */
public class Relator {

	private String nome;
    @JsonProperty(value = "email")
    private String contato;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getContato() {
		return contato;
	}
	
}
