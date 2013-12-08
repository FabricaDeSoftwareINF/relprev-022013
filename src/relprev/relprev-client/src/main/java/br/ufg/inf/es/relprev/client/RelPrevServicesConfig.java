package br.ufg.inf.es.relprev.client;

import br.ufg.inf.es.relprev.client.util.Configuration;

/**
 * User: halisson
 * Date: 11/7/13
 * Time: 12:13 AM
 */
public final class RelPrevServicesConfig {

    private static RelPrevServicesConfig instance;

    private final Configuration configuration;

    private RelPrevServicesConfig() {
        this.configuration = new Configuration("services");
    }

    public static RelPrevServicesConfig getInstance() {
        if (instance == null) {
            instance = new RelPrevServicesConfig();
        }
        return instance;
    }

    /**
     * Lista os Relatórios de Prevenção
     * 
     * @return {@link String} URL para listagem de Relatório de Prevenção
     */
    public String listRelPrevURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV;
    }

    /**
     * Busca um Relatório de Prevenção pelo ID
     * 
     * @return {@link String} URL para busca de Relatório de Prevenção
     */
    public String findRelPrevURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_FIND;
    }

    /**
     * Recupera a URL para criação de Relatório de Prevenção
     * 
     * @return {@link String} URL para criação de Relatório de Prevenção
     */
    public String createRelPrevURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_CREATE;
    }

    /**
     * Recupera a URL para atualização de Relatório de Prevenção
     * 
     * @return {@link String} URL para atualização de Relatório de Prevenção
     */
    public String updateRelPrevURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_UPDATE;
    }

    /**
     * Recupera a URL para remoção de Relatório de Prevenção
     * 
     * @return {@link String} URL para remoção de Relatório de Prevenção
     */
    public String deleteRelPrevURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV;
    }

    /**
     * Recupera a URL para busca de Relatório de Prevenção pelo Local
     * 
     * @return {@link String} URL para busca de Relatório de Prevenção pelo Local
     */
    public String findRelPrevByLocalURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_FIND_RELPREV_BY_LOCAL;
    }

    /**
     * Recupera a URL para busca de Relatório de Prevenção pela Descrição
     * 
     * @return {@link String} URL para busca de Relatório de Prevenção pela Descrição
     */
    public String findRelPrevByDescricaoURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_FIND_RELPREV_BY_DESCRICAO;
    }

    /**
     * Recupera a URL para adição de Ação Recomendada ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Ação Recomendada ao Relatório de Prevenção
     */
    public String addRelPrevAcaoRecomendadaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_SET_ACAO_RECOMENDADA;
    }

    /**
     * Recupera a URL para adição de Classificação de Risco ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Classificação de Risco ao Relatório de Prevenção
     */
    public String addRelPrevClassificadaoDeRiscoURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_SET_CLASSIFICACAO_DE_RISCO;
    }

    /**
     * Recupera a URL para adição de Encaminhamento ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Encaminhamento ao Relatório de Prevenção
     */
    public String addRelPrevEncaminhamentoURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_SET_ENCAMINHAMENTO;
    }

    /**
     * Recupera a URL para adição de Observação ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Observação ao Relatório de Prevenção
     */
    public String addRelPrevObservacaoURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_SET_OBSERVACAO;
    }

    /**
     * Recupera a URL para adição de Parecer do Setor ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Parecer do Setor ao Relatório de Prevenção
     */
    public String addRelPrevParecerDoSetorURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_SET_PARECER_SETOR;
    }

    /**
     * Recupera a URL para adição de Resposta ao Prevenção pela Descrição
     * 
     * @return {@link String} URL para adição de Resposta ao Relatório de Prevenção
     */
    public String addRelPrevRespostaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELPREV + this.ACTION_SET_RESPOSTA;
    }

    /**
     * Lista os Elos SIPAER
     * 
     * @return {@link String} URL para listagem de Elo SIPAER
     */
    public String listEloSIPAERURL() {
        return this.serviceBaseURL() + this.CONTROLLER_ELO_SIPAER;
    }

    /**
     * Busca um Elo SIPAER pelo ID
     * 
     * @return {@link String} URL para busca de Elo SIPAER
     */
    public String findEloSIPAERURL() {
        return this.serviceBaseURL() + this.CONTROLLER_ELO_SIPAER + this.ACTION_FIND;
    }

    /**
     * Recupera a URL para criação de Elo SIPAER
     * 
     * @return {@link String} URL para criação de Elo SIPAER
     */
    public String createEloSIPAERURL() {
        return this.serviceBaseURL() + this.CONTROLLER_ELO_SIPAER + this.ACTION_CREATE;
    }

    /**
     * Recupera a URL para atualização de Elo SIPAER
     * 
     * @return {@link String} URL para atualização de Elo SIPAER
     */
    public String updateEloSIPAERURL() {
        return this.serviceBaseURL() + this.CONTROLLER_ELO_SIPAER + this.ACTION_UPDATE;
    }

    /**
     * Recupera a URL para remoção de Elo SIPAER
     * 
     * @return {@link String} URL para remoção de Elo SIPAER
     */
    public String deleteEloSIPAERURL() {
        return this.serviceBaseURL() + this.CONTROLLER_ELO_SIPAER;
    }

    /**
     * Lista as Taxonomias
     * 
     * @return {@link String} URL para listagem de Taxonomia
     */
    public String listTaxonomiaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_TAXONOMIA;
    }

    /**
     * Busca um Taxonomia pelo ID
     * 
     * @return {@link String} URL para busca de Taxonomia
     */
    public String findTaxonomiaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_TAXONOMIA + this.ACTION_FIND;
    }

    /**
     * Recupera a URL para criação de Taxonomia
     * 
     * @return {@link String} URL para criação de Taxonomia
     */
    public String createTaxonomiaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_TAXONOMIA + this.ACTION_CREATE;
    }

    /**
     * Recupera a URL para atualização de Taxonomia
     * 
     * @return {@link String} URL para atualização de Taxonomia
     */
    public String updateTaxonomiaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_TAXONOMIA + this.ACTION_UPDATE;
    }

    /**
     * Recupera a URL para remoção de Taxonomia
     * 
     * @return {@link String} URL para remoção de Taxonomia
     */
    public String deleteTaxonomiaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_TAXONOMIA;
    }

    /**
     * Lista as Categorias
     * 
     * @return {@link String} URL para listagem de Categoria
     */
    public String listCategoriaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_CATEGORIA;
    }

    /**
     * Busca um Categoria pelo ID
     * 
     * @return {@link String} URL para busca de Categoria
     */
    public String findCategoriaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_CATEGORIA + this.ACTION_FIND;
    }

    /**
     * Recupera a URL para criação de Categoria
     * 
     * @return {@link String} URL para criação de Categoria
     */
    public String createCategoriaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_CATEGORIA + this.ACTION_CREATE;
    }

    /**
     * Recupera a URL para atualização de Categoria
     * 
     * @return {@link String} URL para atualização de Categoria
     */
    public String updateCategoriaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_CATEGORIA + this.ACTION_UPDATE;
    }

    /**
     * Recupera a URL para remoção de Categoria
     * 
     * @return {@link String} URL para remoção de Categoria
     */
    public String deleteCategoriaURL() {
        return this.serviceBaseURL() + this.CONTROLLER_CATEGORIA;
    }

    /**
     * Lista os Relatores
     * 
     * @return {@link String} URL para listagem de Relator
     */
    public String listRelatorURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELATOR;
    }

    /**
     * Busca um Relator pelo ID
     * 
     * @return {@link String} URL para busca de Relator
     */
    public String findRelatorURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELATOR + this.ACTION_FIND;
    }

    /**
     * Recupera a URL para criação de Relator
     * 
     * @return {@link String} URL para criação de Relator
     */
    public String createRelatorURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELATOR + this.ACTION_CREATE;
    }

    /**
     * Recupera a URL para atualização de Relator
     * 
     * @return {@link String} URL para atualização de Relator
     */
    public String updateRelatorURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELATOR + this.ACTION_UPDATE;
    }

    /**
     * Recupera a URL para remoção de Relator
     * 
     * @return {@link String} URL para remoção de Relator
     */
    public String deleteRelatorURL() {
        return this.serviceBaseURL() + this.CONTROLLER_RELATOR;
    }

    private final String ACTION_FIND = "/";
    private final String ACTION_CREATE = "/create";
    private final String ACTION_UPDATE = "/update";

    private final String CONTROLLER_RELPREV = "/relprev";
    private final String CONTROLLER_ELO_SIPAER = "/elosipaer";
    private final String CONTROLLER_TAXONOMIA = "/taxonomia";
    private final String CONTROLLER_RELATOR = "/relator";
    private final String CONTROLLER_CATEGORIA = "/categoria";

    private final String ACTION_FIND_RELPREV_BY_LOCAL = "/local/";
    private final String ACTION_FIND_RELPREV_BY_DESCRICAO = "/descricao/";

    private final String ACTION_SET_ACAO_RECOMENDADA = "/acao";
    private final String ACTION_SET_CLASSIFICACAO_DE_RISCO = "/classificacao";
    private final String ACTION_SET_ENCAMINHAMENTO = "/encaminhamento";
    private final String ACTION_SET_OBSERVACAO = "/observacao";
    private final String ACTION_SET_PARECER_SETOR = "/parecer";
    private final String ACTION_SET_RESPOSTA = "/resposta";

    private String serviceURL;

    private String serviceBaseURL() {
        if (this.serviceURL == null) {
            this.serviceURL = this.configuration.getProperty("services.url");
        }
        return this.serviceURL;
    }

}
