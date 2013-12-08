package br.ufg.inf.service.support;

/**
 * URLs dos endpoints REST (web services)
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public interface WebServicesURL {

    /**
     * GET, POST
     */
    String URL_LIST = "";
    /**
     * GET
     */
    String URL_FIND = "/{id}";
    /**
     * DELETE
     */
    String URL_DELETE = "{id}";
    /**
     * POST
     */
    String URL_CREATE = "/create";
    /**
     * PUT
     */
    String URL_UPDATE = "/update";

    // relprev service
    String URL_RELPREV = "/relprev";
    String URL_RELPREV_FIND_LOCAL = "/local";
    String URL_RELPREV_FIND_DESCRICAO = "/descricao";

    // elosipaer service
    String URL_ELOSIPAER = "/elosipaer";

    // relator service
    String URL_RELATOR = "/relator";

    // taxonomia service
    String URL_TAXONOMIA = "/taxonomia";

    // categoria service
    String URL_CATEGORIA = "/categoria";

}
