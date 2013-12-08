package br.ufg.inf.service.support;

/**
 * Mensagens para retorno na resposta das chamadas aos Serviços
 * 
 * @created 03/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public interface ResponseMessages {

    String CREATE_MESSAGE = "Objeto criado com Sucesso";
    String UPDATE_MESSAGE = "Objeto de id %s atualizado com Sucesso";
    String DELETE_MESSAGE = "Objeto de id %s removido com Sucesso";

    String NOTFOUND_UPDATE_MESSAGE = "Objeto com id %s não foi encontrado para ser atualizado";
    String NOTFOUND_DELETE_MESSAGE = "Objeto com id %s não foi encontrado para ser removido";

    String FIND_MESSAGE = "Objeto com id %s consultado com Sucesso";
    String LIST_MESSAGE = "%s objeto(s) listado(s) com Sucesso";

    String NOTFOUND_MESSAGE = "Objeto com id %s é inexistente na base de Dados";
    String NOTFOUND_LIST_MESSAGE = "Não existe(m) objeto(s) a ser(em) Listado(s)";

}
