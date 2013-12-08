package br.ufg.inf.es.relprev.client;

import br.ufg.inf.es.relprev.client.util.Configuration;

/**
 * User: halisson
 * Date: 11/7/13
 * Time: 12:13 AM
 */
public final class RelPrevServicesConfig {

    private static RelPrevServicesConfig instance;

    private Configuration configuration;

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
        return this.serviceBaseURL() + this.controllerRelPrev;
    }

    /**
     * Busca um Relatório de Prevenção pelo ID
     * 
     * @return {@link String} URL para busca de Relatório de Prevenção
     */
    public String findRelPrevURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + this.actionFind;
    }

    /**
     * Recupera a URL para criação de Relatório de Prevenção
     * 
     * @return {@link String} URL para criação de Relatório de Prevenção
     */
    public String createRelPrevURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + this.actionCreate;
    }

    /**
     * Recupera a URL para atualização de Relatório de Prevenção
     * 
     * @return {@link String} URL para atualização de Relatório de Prevenção
     */
    public String updateRelPrevURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + this.actionUpdate;
    }

    /**
     * Recupera a URL para remoção de Relatório de Prevenção
     * 
     * @return {@link String} URL para remoção de Relatório de Prevenção
     */
    public String deleteRelPrevURL() {
        return this.serviceBaseURL() + this.controllerRelPrev;
    }

    /**
     * Recupera a URL para busca de Relatório de Prevenção pelo Local
     * 
     * @return {@link String} URL para busca de Relatório de Prevenção pelo Local
     */
    public String findRelPrevByLocalURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + "/local/";
    }

    /**
     * Recupera a URL para busca de Relatório de Prevenção pela Descrição
     * 
     * @return {@link String} URL para busca de Relatório de Prevenção pela Descrição
     */
    public String findRelPrevByDescricaoURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + "/descricao/";
    }

    /**
     * Recupera a URL para adição de Ação Recomendada ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Ação Recomendada ao Relatório de Prevenção
     */
    public String addRelPrevAcaoRecomendadaURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + "/acao";
    }

    /**
     * Recupera a URL para adição de Classificação de Risco ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Classificação de Risco ao Relatório de Prevenção
     */
    public String addRelPrevClassificadaoDeRiscoURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + "/classificacao";
    }

    /**
     * Recupera a URL para adição de Encaminhamento ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Encaminhamento ao Relatório de Prevenção
     */
    public String addRelPrevEncaminhamentoURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + "/encaminhamento";
    }

    /**
     * Recupera a URL para adição de Observação ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Observação ao Relatório de Prevenção
     */
    public String addRelPrevObservacaoURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + "/observacao";
    }

    /**
     * Recupera a URL para adição de Parecer do Setor ao Relatório de Prevenção
     * 
     * @return {@link String} URL para adição de Parecer do Setor ao Relatório de Prevenção
     */
    public String addRelPrevParecerDoSetorURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + "/parecer";
    }

    /**
     * Recupera a URL para adição de Resposta ao Prevenção pela Descrição
     * 
     * @return {@link String} URL para adição de Resposta ao Relatório de Prevenção
     */
    public String addRelPrevRespostaURL() {
        return this.serviceBaseURL() + this.controllerRelPrev + "/resposta";
    }

    /**
     * Lista os Elos SIPAER
     * 
     * @return {@link String} URL para listagem de Elo SIPAER
     */
    public String listEloSIPAERURL() {
        return this.serviceBaseURL() + this.controllerEloSipaer;
    }

    /**
     * Busca um Elo SIPAER pelo ID
     * 
     * @return {@link String} URL para busca de Elo SIPAER
     */
    public String findEloSIPAERURL() {
        return this.serviceBaseURL() + this.controllerEloSipaer + this.actionFind;
    }

    /**
     * Recupera a URL para criação de Elo SIPAER
     * 
     * @return {@link String} URL para criação de Elo SIPAER
     */
    public String createEloSIPAERURL() {
        return this.serviceBaseURL() + this.controllerEloSipaer + this.actionCreate;
    }

    /**
     * Recupera a URL para atualização de Elo SIPAER
     * 
     * @return {@link String} URL para atualização de Elo SIPAER
     */
    public String updateEloSIPAERURL() {
        return this.serviceBaseURL() + this.controllerEloSipaer + this.actionUpdate;
    }

    /**
     * Recupera a URL para remoção de Elo SIPAER
     * 
     * @return {@link String} URL para remoção de Elo SIPAER
     */
    public String deleteEloSIPAERURL() {
        return this.serviceBaseURL() + this.controllerEloSipaer;
    }

    /**
     * Lista as Taxonomias
     * 
     * @return {@link String} URL para listagem de Taxonomia
     */
    public String listTaxonomiaURL() {
        return this.serviceBaseURL() + this.controllerTaxonomia;
    }

    /**
     * Busca um Taxonomia pelo ID
     * 
     * @return {@link String} URL para busca de Taxonomia
     */
    public String findTaxonomiaURL() {
        return this.serviceBaseURL() + this.controllerTaxonomia + this.actionFind;
    }

    /**
     * Recupera a URL para criação de Taxonomia
     * 
     * @return {@link String} URL para criação de Taxonomia
     */
    public String createTaxonomiaURL() {
        return this.serviceBaseURL() + this.controllerTaxonomia + this.actionCreate;
    }

    /**
     * Recupera a URL para atualização de Taxonomia
     * 
     * @return {@link String} URL para atualização de Taxonomia
     */
    public String updateTaxonomiaURL() {
        return this.serviceBaseURL() + this.controllerTaxonomia + this.actionUpdate;
    }

    /**
     * Recupera a URL para remoção de Taxonomia
     * 
     * @return {@link String} URL para remoção de Taxonomia
     */
    public String deleteTaxonomiaURL() {
        return this.serviceBaseURL() + this.controllerTaxonomia;
    }

    /**
     * Lista as Categorias
     * 
     * @return {@link String} URL para listagem de Categoria
     */
    public String listCategoriaURL() {
        return this.serviceBaseURL() + this.controllerCategoria;
    }

    /**
     * Busca um Categoria pelo ID
     * 
     * @return {@link String} URL para busca de Categoria
     */
    public String findCategoriaURL() {
        return this.serviceBaseURL() + this.controllerCategoria + this.actionFind;
    }

    /**
     * Recupera a URL para criação de Categoria
     * 
     * @return {@link String} URL para criação de Categoria
     */
    public String createCategoriaURL() {
        return this.serviceBaseURL() + this.controllerCategoria + this.actionCreate;
    }

    /**
     * Recupera a URL para atualização de Categoria
     * 
     * @return {@link String} URL para atualização de Categoria
     */
    public String updateCategoriaURL() {
        return this.serviceBaseURL() + this.controllerCategoria + this.actionUpdate;
    }

    /**
     * Recupera a URL para remoção de Categoria
     * 
     * @return {@link String} URL para remoção de Categoria
     */
    public String deleteCategoriaURL() {
        return this.serviceBaseURL() + this.controllerCategoria;
    }

    /**
     * Lista os Relatores
     * 
     * @return {@link String} URL para listagem de Relator
     */
    public String listRelatorURL() {
        return this.serviceBaseURL() + this.controllerRelator;
    }

    /**
     * Busca um Relator pelo ID
     * 
     * @return {@link String} URL para busca de Relator
     */
    public String findRelatorURL() {
        return this.serviceBaseURL() + this.controllerRelator + this.actionFind;
    }

    /**
     * Recupera a URL para criação de Relator
     * 
     * @return {@link String} URL para criação de Relator
     */
    public String createRelatorURL() {
        return this.serviceBaseURL() + this.controllerRelator + this.actionCreate;
    }

    /**
     * Recupera a URL para atualização de Relator
     * 
     * @return {@link String} URL para atualização de Relator
     */
    public String updateRelatorURL() {
        return this.serviceBaseURL() + this.controllerRelator + this.actionUpdate;
    }

    /**
     * Recupera a URL para remoção de Relator
     * 
     * @return {@link String} URL para remoção de Relator
     */
    public String deleteRelatorURL() {
        return this.serviceBaseURL() + this.controllerRelator;
    }

    private final String actionFind = "/";
    private final String actionCreate = "/create";
    private final String actionUpdate = "/update";

    private final String controllerRelPrev = "/relprev";
    private final String controllerEloSipaer = "/elosipaer";
    private final String controllerTaxonomia = "/taxonomia";
    private final String controllerRelator = "/relator";
    private final String controllerCategoria = "/categoria";

    private String serviceURL;

    /**
     * Associa à instância de configuração dos serviços RelPrev uma {@link Configuration} Caso não seja associada uma, a padrão,
     * de nome {@code services.properties} será usada
     * 
     * @param configuration
     *            {@link Configuration} a ser associada
     */
    public void setConfiguration(final Configuration configuration) {
        this.configuration = configuration;
    }

    private String serviceBaseURL() {
        if (this.serviceURL == null) {
            this.serviceURL = this.configuration.getProperty("services.url");
        }
        return this.serviceURL;
    }

}
