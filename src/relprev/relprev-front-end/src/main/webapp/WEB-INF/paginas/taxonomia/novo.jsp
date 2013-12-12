<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:template>
    <jsp:attribute name="titulo">
        Taxonomia - RELPREV
    </jsp:attribute>
    <jsp:body>

        <link href="<c:url value="/css/taxonomia.css" />" rel="stylesheet" media="all">

        <div class="text-center">
            <label><fmt:message key="taxonomia" /></label>
        </div>
        <hr/>

        <div class="row">


            <div class="form-group col-md-8">
                <label><fmt:message key="taxonomia.nome" /></label>
                <input type="text" class="form-control">
            </div>

            <div class="form-group col-md-2">
                <label><fmt:message key="taxonomia.padraominimo" /></label>
                <select class="form-control">
                    <option><fmt:message key="sim" /></option>
                    <option><fmt:message key="nao" /></option>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label><fmt:message key="taxonomia.status" /></label>
                <select class="form-control">
                    <option><fmt:message key="taxonomia.status.ativada" /></option>
                    <option><fmt:message key="taxonomia.status.desativada" /></option>
                </select>
            </div>
        </div>

        <div class="checkbox" id="checkboxSubCategorias">
            <label>
                <input type="checkbox" value="">
                Sub-Categorias
            </label>
        </div>

        <div class="panel panel-default col-md-4" id="categorias">
            <div class="panel-heading">
                <h3 class="panel-title"><fmt:message key="taxonomia.categorias" /></h3>
            </div>
            <div class="panel-body">
                <div class="list-group" id="listaCategorias">
                </div>
            </div>
        </div>

        <div class="panel panel-default col-md-4 hidden" id="subcategorias">
            <div class="panel-heading">
                <h3 class="panel-title"><fmt:message key="taxonomia.subcategorias" /></h3>
            </div>
            <div class="panel-body">
                <div class="list-group" id="listaSubCategorias">

                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="modalConfirmacaoExclusao" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="modalLabel"><fmt:message key="taxonomia.excluirCategoria" /></h4>
                    </div>
                    <div class="modal-body">
                        <fmt:message key="taxonomia.confirmacaoExclusao" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="cancelar" /></button>
                        <button type="button" class="btn btn-primary" id="botaoExcluirCategoria"><fmt:message key="excluir" /></button>
                    </div>
                </div>
            </div>
        </div>

        <div class="container" style="max-width: 200px; margin-bottom: 20px; margin-top: 50px; clear: both;">
            <button type="submit" class="btn btn-primary">
                <fmt:message key="salvar" />
            </button>
            <button class="btn btn-default">
                <fmt:message key="cancelar" />
            </button>
        </div>

        <a href="#" class="list-group-item text-center adicionarCategoria hidden">
            <span id="iconeAdicionar" class="glyphicon glyphicon-plus"/>
        </a>

        <button type="button" id="botaoModalExclusao" class="btn btn-default pull-right hidden">
            <span class="glyphicon glyphicon-trash" />
        </button>
        <input type="text" class="form-control inputNome hidden"/>
        <a href="#" class="list-group-item hidden" id="itemCategoria">

        </a>


        <script type="text/javascript" src="<c:url value="/js/taxonomia.js"/>" ></script>
    </jsp:body>

</t:template>
