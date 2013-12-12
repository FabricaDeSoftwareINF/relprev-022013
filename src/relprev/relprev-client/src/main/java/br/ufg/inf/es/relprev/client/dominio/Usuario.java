package br.ufg.inf.es.relprev.client.dominio;

import static br.ufg.inf.es.relprev.client.http.HttpClient.doPost;
import static br.ufg.inf.es.relprev.client.http.JsonConverter.fromJson;
import br.ufg.inf.es.relprev.client.RelPrevServicesConfig;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;
import br.ufg.inf.es.relprev.client.http.response.UsuarioResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para Usuário
 * 
 * @created 12/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@JsonInclude(Include.NON_EMPTY)
public class Usuario extends ObjetoDeDominio {

    @JsonProperty
    private String email;

    @JsonProperty
    private String especialidade;

    @JsonProperty
    private String funcao;

    @JsonProperty
    private String nomeCompleto;

    @JsonProperty
    private String posto;

    @JsonProperty
    private String siglaSecao;

    @JsonProperty
    private String telefoneCelular;

    @JsonProperty
    private String telefoneFixo;

    @JsonProperty
    private String usuario;

    @JsonProperty
    private String senha;

    @JsonProperty
    private Boolean ativo;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(final String especialidade) {
        this.especialidade = especialidade;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(final String funcao) {
        this.funcao = funcao;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(final String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPosto() {
        return this.posto;
    }

    public void setPosto(final String posto) {
        this.posto = posto;
    }

    public String getSiglaSecao() {
        return this.siglaSecao;
    }

    public void setSiglaSecao(final String siglaSecao) {
        this.siglaSecao = siglaSecao;
    }

    public String getTelefoneCelular() {
        return this.telefoneCelular;
    }

    public void setTelefoneCelular(final String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return this.telefoneFixo;
    }

    public void setTelefoneFixo(final String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(final Boolean ativo) {
        this.ativo = ativo;
    }

    private final RelPrevServicesConfig config = RelPrevServicesConfig.getInstance();

    @Override
    protected String getListURL() {
        return this.config.listUsuarioURL();
    }

    @Override
    protected String getFindByIDURL() {
        return this.config.findUsuarioURL();
    }

    @Override
    protected String getCreateURL() {
        return this.config.createUsuarioURL();
    }

    @Override
    protected String getUpdateURL() {
        return this.config.updateUsuarioURL();
    }

    @Override
    protected String getDeleteURL() {
        return this.config.deleteUsuarioURL();
    }

    @Override
    protected Class<?> getResponseClass() {
        return Usuario.class;
    }

    public static Usuario findUsuarioByLoginAndSenha(final String usuario, final String senha) throws RequestException {
        if (usuario == null || usuario.isEmpty()) {
            throw new IllegalArgumentException("O usuário é obrigatório");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória");
        }

        final String url = RelPrevServicesConfig.getInstance().findUsuarioByUsuarioSenhaURL();
        final UsuarioResponse response = fromJson(doPost(String.format(url, usuario, senha), ""), UsuarioResponse.class);

        if (!response.getSuccess()) {
            throw new RequestException(response.getMessage());
        }

        return response.getData().get(0);
    }

}
