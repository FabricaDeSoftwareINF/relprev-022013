package br.ufg.inf.service.support;

/**
 * URLs dos endpoints REST (web services)
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public interface WebServicesURL {

    String URL_LIST = ""; // GET, POST
    String URL_FIND = "/{id}"; // GET
    String URL_CREATE = "/create"; // POST
    String URL_UPDATE = "/update"; // PUT
    String URL_DELETE = "/delete/{id}"; // DELETE

    // relprev service
    String URL_RELPREV = "/relprev";
    String URL_RELPREV_FIND_LOCAL = "/local";
    String URL_RELPREV_FIND_DESCRICAO = "/descricao";

    // elosipaer service
    String URL_ELOSIPAER = "/elosipaer";

    // relator service
    String URL_RELATOR = "/relator";

}
